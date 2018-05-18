package funcional;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import com.google.gson.JsonSyntaxException;

import dominio.clientes.Cliente;

public class SerializadorJsonTest {

	Path pathClientes;
	Path pathClientesDefectuoso;
	SerializadorJson serializador;
	
	@Before
	public void TestSetup() throws URISyntaxException {
		pathClientes = obtenerPath("archivoClientes.json");
		pathClientesDefectuoso = obtenerPath("archivoClientesDefectuoso.json");
		serializador = new SerializadorJson();
	}

	private Path obtenerPath(String pathString) throws URISyntaxException {
		return Paths.get(this.getClass().getClassLoader().getResource(pathString).toURI());
	}
	
	@Test
	public void elSerializadorPuedeDeserializarElArchivoDeClientes() throws FileNotFoundException {
		assertNotNull(serializador.deserializarClientes(pathClientes));
	}

	@Test
	public void elSerializadorPuedeDeserializarArchivosDeClientesVacios() throws FileNotFoundException, IOException{
		File dummyFile = new File("clientesDummy.json");
		dummyFile.createNewFile();
		Path dummyJson = Paths.get(dummyFile.getAbsolutePath());

		serializador.deserializarClientes(dummyJson);
		dummyFile.delete();
	}

	// TODO: este test estaria muy acoplado al archivo del dominio, que va a cambiar mucho...
	@Test
	public void deserializarUnArchivoConTresClientesTraeLosTres() throws FileNotFoundException{
		int cantidadEsperada = 3;
		List<Cliente> clientes = serializador.deserializarClientes(pathClientes);		
		assertEquals(cantidadEsperada, clientes.size());
	}

	// TODO: creo que habria que ver que onda con que casos de error prevenir
	@Test(expected = JsonSyntaxException.class)
	public void cargarUnArchivoDefectuosoProduceUnaFalla() throws FileNotFoundException{
		serializador.deserializarClientes(pathClientesDefectuoso);
	}	
}
