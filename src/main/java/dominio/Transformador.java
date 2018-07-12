package dominio;

import java.util.List;

import dominio.clientes.Cliente;

public class Transformador {
	
	private List<Cliente> usuariosConectados;
	private Posicion posicion;
	
	public double calcularConsumoTotal() {
	
		return usuariosConectados.stream().mapToDouble(u->u.calcularConsumoTotal()).sum();
	}
	
	public void conectarCliente(Cliente cliente) {
		this.usuariosConectados.add(cliente);
	}
	
	public void desconectarCliente(Cliente cliente) {
		this.usuariosConectados.remove(cliente);
	}

	public Posicion getPosicion() {
		return posicion;
	}

	
	
}
