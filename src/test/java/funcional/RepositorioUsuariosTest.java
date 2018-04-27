package funcional;

import funcional.RepositorioUsuarios;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.file.Path;
import java.nio.file.Paths;

import org.junit.Before;
import org.junit.Test;

import com.google.gson.JsonSyntaxException;

public class RepositorioUsuariosTest {

	Path pathClientes;
	Path pathClientesDefectuoso;
	RepositorioUsuarios repo;
	
	@Before
	public void TestSetup() throws URISyntaxException {
		pathClientes = obtenerPath("archivoClientes.json");
		pathClientesDefectuoso = obtenerPath("archivoClientesDefectuoso.json");
		repo = RepositorioUsuarios.getRepositorio();
	}

	private Path obtenerPath(String pathString) throws URISyntaxException {
		return Paths.get(this.getClass().getClassLoader().getResource(pathString).toURI());
	}
	
	@Test
	public void elRepositorioPuedeLevantarElArchivoDeClientes() throws FileNotFoundException {
		repo.cargarClientes(pathClientes);
		assertNotNull(repo.getClientes());
	}

	@Test
	public void elRepositorioPuedeLevantarArchivosDeClientesVacios() throws FileNotFoundException, IOException{
		File dummyFile = new File("clientesDummy.json");
		dummyFile.createNewFile();
		Path dummyJson = Paths.get(dummyFile.getAbsolutePath());

		repo.cargarClientes(dummyJson);
		dummyFile.delete();
	}

	// TODO: este test estaria muy acoplado al archivo del dominio, que va a cambiar mucho...
	@Test
	public void cargarUnArchivoConTresClientesTraeLosTres() throws FileNotFoundException{
		int cantidadEsperada = 3;
		repo.cargarClientes(pathClientes);
		
		assertEquals(cantidadEsperada, repo.getClientes().size());
	}
	
	@Test
	public void cargarElRepositorioMasDeUnaVezNoExtiendeLaListaDeClientes() throws FileNotFoundException {
		repo.cargarClientes(pathClientes);
		int sizeInicial = repo.getClientes().size();
		
		repo.cargarClientes(pathClientes);
		
		assertEquals(sizeInicial, repo.getClientes().size());
	}
	
	// TODO: creo que habria que ver que onda con que casos de error prevenir
	@Test(expected = JsonSyntaxException.class)
	public void cargarUnArchivoDefectuosoProduceUnaFalla() throws FileNotFoundException{
		repo.cargarClientes(pathClientesDefectuoso);
	}	
}
