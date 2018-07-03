package dominio;

import java.util.List;

import dominio.clientes.Cliente;

public class Transformador {
	private double  posicionX;
	private double posicionY;
	private List<Cliente> usuariosConectados;
	
	public double calcularConsumoTotal() {
	
		return usuariosConectados.stream().mapToDouble(u->u.calcularConsumoTotal()).sum();
	}
	
	public void conectarCliente(Cliente cliente) {
		this.usuariosConectados.add(cliente);
	}
	
	public void desconectarCliente(Cliente cliente) {
		this.usuariosConectados.remove(cliente);
	}
}
