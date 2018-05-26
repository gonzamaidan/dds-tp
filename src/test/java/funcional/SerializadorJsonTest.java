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
import dominio.excepciones.FalloTraduccionException;

public class SerializadorJsonTest {

	String pathClientes;
	String pathClientesDefectuoso;
	SerializadorJson serializador;

	@Before
	public void TestSetup() throws URISyntaxException {
		pathClientes = obtenerPath("archivoClientes.json");
		pathClientesDefectuoso = obtenerPath("archivoClientesDefectuoso.json");
	}

	private String obtenerPath(String pathString) throws URISyntaxException {
		return Paths.get(this.getClass().getClassLoader().getResource(pathString).toURI()).toString();
	}

	@Test
	public void elSerializadorPuedeDeserializarElArchivoDeClientes() throws FalloTraduccionException, FileNotFoundException {
		serializador = new SerializadorJson(pathClientes);

		assertNotNull(serializador.deserializarClientes());
	}

	@Test
	public void elSerializadorPuedeDeserializarArchivosDeClientesVacios() throws FalloTraduccionException, FileNotFoundException, IOException {
		File dummyFile = new File("clientesDummy.json");
		dummyFile.createNewFile();
		String dummyJson = Paths.get(dummyFile.getAbsolutePath()).toString();
		serializador = new SerializadorJson(dummyJson);

		serializador.deserializarClientes();
		dummyFile.delete();
	}

	// TODO: este test estaria muy acoplado al archivo del dominio, que va a cambiar
	// mucho...
	@Test
	public void deserializarUnArchivoConTresClientesTraeLosTres() throws FalloTraduccionException, FileNotFoundException {
		int cantidadEsperada = 3;
		serializador = new SerializadorJson(pathClientes);
		List<Cliente> clientes = serializador.deserializarClientes();

		assertEquals(cantidadEsperada, clientes.size());
	}

	// TODO: creo que habria que ver que onda con que casos de error prevenir
	@Test(expected = JsonSyntaxException.class)
	public void cargarUnArchivoDefectuosoProduceUnaFalla() throws FalloTraduccionException, FileNotFoundException {
		serializador = new SerializadorJson(pathClientesDefectuoso);

		serializador.deserializarClientes();
	}
}
