package dominio;

import java.util.function.BiFunction;

import dominio.actuadores.Actuador;
import dominio.actuadores.comandos.*;
import dominio.dispositivo.fisicos.*;
import dominio.dispositivo.*;

public class ReglasBuilder {

	private BiFunction<Double, Magnitud, Boolean>  condicion;
	private DispositivoFisico fisico;
	private DispositivoInteligente logico;

	public ReglasBuilder conDispositivoLogico(DispositivoInteligente logico) {
		this.logico = logico;
		return this;
	}
	
	public ReglasBuilder conDispositivoFisico(DispositivoFisico fisico) {
		this.fisico = fisico;
		return this;
	}
	
	public ReglasBuilder conCondicion(BiFunction<Double, Magnitud, Boolean>  condicion) {
		this.condicion = condicion;
		return this;
	}
	
	public Regla crearApagar() {
		Actuador act = new Actuador(new ComandoApagar(fisico), logico);
		return new Regla(condicion, act);
	}

	public Regla crearEncender() {
		Actuador act = new Actuador(new ComandoEncender(fisico), logico);
		return new Regla(condicion, act);
	}
}
