package dominio;

import java.util.Comparator;
import java.util.List;

import dominio.clientes.Cliente;

public class ZonaGeografica {
	private Double radio;
	private List<Transformador> transformadores;
	
	
	
	public ZonaGeografica(Double radio) {
		this.radio = radio;
	
	}

	public Double calcularConsumoTotal() {
		
		return transformadores.stream().mapToDouble(t->t.calcularConsumoTotal()).sum();
	}
	
	public Transformador transformadorMasCercano(Posicion posicion) {
	Transformador transformador;
	transformador=transformadores.stream()
		.sorted(Comparator.comparing(t->t.getPosicion().calcularKilometrosDesde(posicion)))
		.findFirst().get();
		
	return transformador;
	}
	
	public void buscaryConectarATransformadorCercano(Cliente cliente) {
		Transformador transformador;
		transformador=cliente.zonaGeo.transformadorMasCercano(cliente.getPosicion());
		transformador.conectarCliente(cliente);
	}
	
	public agregarTransformador()
}
