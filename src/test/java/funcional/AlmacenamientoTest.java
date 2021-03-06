package funcional;


import static org.junit.Assert.assertNotNull;

import java.net.URISyntaxException;
import java.nio.file.Paths;

import org.junit.Test;

import dominio.excepciones.FalloTraduccionException;

public class AlmacenamientoTest {
	
	private String obtenerPathString(String pathString) throws URISyntaxException {
		return Paths.get(this.getClass().getClassLoader().getResource(pathString).toURI()).toString();
	}
	
	@Test
	public void InicializarAlmacenamientoParaUnArchivoValidoTraeClientes() throws URISyntaxException, FalloTraduccionException {
		String archivoClientes = this.obtenerPathString("archivoClientes.json");
		AlmacenamientoDeClientes store = new AlmacenamientoDeClientes(new SerializadorJson(archivoClientes));
		
		assertNotNull(store.getClientes());
	}
}
