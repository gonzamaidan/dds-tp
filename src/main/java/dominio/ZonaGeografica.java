package dominio;

import java.util.Comparator;
import java.util.List;

public class ZonaGeografica {
	private double radio;
	private List<Transformador> transformadores;
	
	public double calcularConsumoTotal() {
		
		return transformadores.stream().mapToDouble(t->t.calcularConsumoTotal()).sum();
	}
	
	public Transformador transformadorMasCercano(Double unaLongitud, Double unaLatitud) {
	Transformador transformador;
	transformador=transformadores.stream()
		.sorted(Comparator.comparing(t->t.calcularKilometrosDesde(unaLongitud,unaLatitud)))
		.findFirst().get();
		
	return transformador;
	}
}
