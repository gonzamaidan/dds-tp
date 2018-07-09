package dominio;

import java.util.function.BiFunction;

import dominio.actuadores.Actuador;
import dominio.actuadores.comandos.ComandoApagar;
import dominio.actuadores.comandos.ComandoEncender;
import dominio.dispositivo.DispositivoInteligente;

public class ReglasBuilder {

	private BiFunction<Double, Magnitud, Boolean>  condicion;
	private DispositivoInteligente logico;

	public ReglasBuilder conDispositivoLogico(DispositivoInteligente logico) {
		this.logico = logico;
		return this;
	}
	
	public ReglasBuilder conCondicion(BiFunction<Double, Magnitud, Boolean>  condicion) {
		this.condicion = condicion;
		return this;
	}
	
	public Regla crearApagar() {
		Actuador act = new Actuador(new ComandoApagar(), logico);
		return new Regla(condicion, act);
	}

	public Regla crearEncender() {
		Actuador act = new Actuador(new ComandoEncender(), logico);
		return new Regla(condicion, act);
	}
}
