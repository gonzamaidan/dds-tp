package dominio;

import dominio.actuadores.Actuador;
import dominio.actuadores.comandos.ComandoApagar;
import dominio.actuadores.comandos.ComandoEncender;
import dominio.dispositivo.DispositivoInteligente;

public class Actuadores {

	public Actuador actuadorApagar(DispositivoInteligente logico) {
		return new Actuador(new ComandoApagar(), logico);
	}

	public Actuador actuadorEncender(DispositivoInteligente logico) {
		return new Actuador(new ComandoEncender(), logico);
	}
}
