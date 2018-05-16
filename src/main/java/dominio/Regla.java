package dominio;

import java.util.function.BiFunction;

import dominio.actuadores.Actuador;

public class Regla {

	private BiFunction<Double, Magnitud, Boolean> condicion;
	private Actuador actuador;
	
	public Regla(BiFunction<Double, Magnitud, Boolean> condicion, Actuador actuador) {
		super();
		this.condicion = condicion;
		this.actuador = actuador;
	}

	public void ejecutarSi(Double medicion, Magnitud magnitud) {
		if(condicion.apply(medicion, magnitud))
			this.actuador.actuar();
	}
}
