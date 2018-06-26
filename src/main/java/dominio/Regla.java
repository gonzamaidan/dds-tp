package dominio;

import java.util.function.Predicate;

import dominio.actuadores.Actuador;

public class Regla {

	private Predicate<Medicion> condicion;
	private Actuador actuador;
	
	public Regla(Predicate<Medicion> condicion, Actuador actuador) {
		super();
		this.condicion = condicion;
		this.actuador = actuador;
	}
	
	public void ejecutarSi(Medicion medicion) {
		if(medicion.comparar(condicion))
			actuador.actuar();
	}
}
