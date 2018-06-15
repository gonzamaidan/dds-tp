package dominio;

import java.util.function.DoublePredicate;

public class Medicion {

	private Magnitud magnitud;
	private Double valor;

	public Medicion(Magnitud magnitud, Double valor) {
		this.magnitud = magnitud;
		this.valor = valor;
	}

	public Boolean comparar(DoublePredicate condicion) {
		return condicion.test(valor);
	}

	public Double getValor() {
		return this.valor;
	}
	
	public Magnitud getMagnitud() {
		return this.magnitud;
	}
}
