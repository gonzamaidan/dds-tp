package funcional;

import java.io.FileNotFoundException;
import java.nio.file.Path;
import java.util.List;

import dominio.clientes.Cliente;

public class AlmacenamientoDeClientes {

	private SerializadorJson serializador = new SerializadorJson();
	private List<Cliente> clientes;
	
	public AlmacenamientoDeClientes(Path archivoClientes) throws FileNotFoundException {
		clientes = serializador.deserializarClientes(archivoClientes);
	}
	
	public List<Cliente> getClientes() {
		return clientes;
	}
}
