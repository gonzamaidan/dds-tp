package funcional;

import java.util.List;

import dominio.clientes.Cliente;
import dominio.excepciones.FalloTraduccionException;

public class AlmacenamientoDeClientes {

	private InterpreteAlmacenamiento interprete;
	private List<Cliente> clientes = null;
	
	public AlmacenamientoDeClientes(InterpreteAlmacenamiento interprete) {
		this.interprete = interprete;
	}
	
	public List<Cliente> getClientes() throws FalloTraduccionException {
		if (clientes == null) {
			clientes = interprete.traducirAClientes();
		}
		return clientes;
	}
}
