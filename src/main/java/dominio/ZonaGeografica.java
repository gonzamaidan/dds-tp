package dominio;

import java.util.Comparator;
import java.util.List;

import dominio.clientes.Cliente;

public class ZonaGeografica {
	private Double radio;
	private List<Transformador> transformadores;
	
	public Double calcularConsumoTotal() {
		
		return transformadores.stream().mapToDouble(t->t.calcularConsumoTotal()).sum();
	}
	
	public Transformador transformadorMasCercano(Double unaLongitud, Double unaLatitud) {
	Transformador transformador;
	transformador=transformadores.stream()
		.sorted(Comparator.comparing(t->t.posicion.calcularKilometrosDesde(unaLongitud,unaLatitud)))
		.findFirst().get();
		
	return transformador;
	}
	
	public void buscaryConectarATransformadorCercano(Cliente cliente) {
		Transformador transformador;
		transformador=cliente.zonaGeo.transformadorMasCercano(cliente.posicion.longitud, cliente.posicion.latitud);
		transformador.conectarCliente(cliente);
	}
}
