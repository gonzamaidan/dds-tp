package dominio;

import java.util.List;

public class ZonaGeografica {
	private double radio;
	private List<Transformador> transformadores;
	
	public double calcularConsumoTotal() {
		
		return transformadores.stream().mapToDouble(u->u.calcularConsumoTotal()).sum();
	}
	
	
}
