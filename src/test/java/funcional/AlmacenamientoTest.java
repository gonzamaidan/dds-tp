package funcional;


import static org.junit.Assert.assertNotNull;

import java.io.FileNotFoundException;
import java.net.URISyntaxException;
import java.nio.file.Path;
import java.nio.file.Paths;

import org.junit.Test;

public class AlmacenamientoTest {
	
	private Path obtenerPath(String pathString) throws URISyntaxException {
		return Paths.get(this.getClass().getClassLoader().getResource(pathString).toURI());
	}
	
	@Test
	public void InicializarAlmacenamientoParaUnArchivoValidoTraeClientes() throws FileNotFoundException, URISyntaxException {
		AlmacenamientoDeClientes store = new AlmacenamientoDeClientes(this.obtenerPath("archivoClientes.json"));
	
		assertNotNull(store.getClientes());
	}
}
