package dominio;

import java.util.function.DoublePredicate;
import java.util.function.Predicate;

public class Medicion {

	private Magnitud magnitud;
	private Double valor;

	public Medicion(Magnitud magnitud, Double valor) {
		this.magnitud = magnitud;
		this.valor = valor;
	}

	public Boolean verificar(Predicate<Double> condicion) {
		return condicion.test(this.valor);
	}
	
	public Boolean comparar(Predicate<Medicion> condicion) {
		return condicion.test(this);
	}

	public Double getValor() {
		return this.valor;
	}
	
	public Magnitud getMagnitud() {
		return this.magnitud;
	}

	public boolean esDeMagnitud(Magnitud otraMagnitud) {
		return this.magnitud.equals(otraMagnitud);
	}
}
