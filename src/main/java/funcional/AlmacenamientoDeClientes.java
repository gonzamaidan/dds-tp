package funcional;

import java.util.List;

import dominio.clientes.Cliente;
import dominio.excepciones.FalloTraduccionException;

public class AlmacenamientoDeClientes {

	private InterpreteAlmacenamiento interprete;
	private List<Cliente> clientes;
	
	public AlmacenamientoDeClientes(InterpreteAlmacenamiento interprete) {
		this.interprete = interprete;
	}
	
	public void cargarClientes(String formaAlmacenamiento) throws FalloTraduccionException {
		this.clientes = interprete.traducirAClientes(formaAlmacenamiento);
	}
	
	public List<Cliente> getClientes() {
		return clientes;
	}
}
