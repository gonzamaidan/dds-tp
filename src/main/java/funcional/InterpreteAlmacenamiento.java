package funcional;

import java.util.List;

import dominio.clientes.Cliente;
import dominio.excepciones.FalloTraduccionException;

public interface InterpreteAlmacenamiento {

	public List<Cliente> traducirAClientes(String formaAlmacenamiento) throws FalloTraduccionException;
	abstract void validarFormaAlmacenamiento(String formaAlmacenamiento) throws FalloTraduccionException;
}
