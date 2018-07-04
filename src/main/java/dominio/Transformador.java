package dominio;

import java.util.List;

import dominio.clientes.Cliente;

public class Transformador {
	private double  longitud;
	private double latitud;
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
	
	private double calcularKilometrosDesde(Double unaLongitud, Double unaLatitud) {
		
		double radioTerrestre = 6371.00;
		
		double latitudOrigen = unaLatitud;
		
		double latitudDestino = this.latitud;
		
		double longitudOrigen = unaLongitud;
		
		double longitudDestino = this.longitud;
		
		double dLat = Math.toRadians(latitudDestino - latitudOrigen);
		
		double dLon = Math.toRadians(longitudDestino - longitudOrigen);
		
		double a = Math.sin(dLat/2) * Math.sin(dLat/2) +
				Math.cos(Math.toRadians(latitudOrigen)) * Math.cos(Math.toRadians(latitudDestino)) *
				Math.sin(dLon/2) * Math.sin(dLon/2);
		double c = 2 * Math.asin(Math.sqrt(a));
		
		return radioTerrestre * c;
	}
}
