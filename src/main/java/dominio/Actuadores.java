package dominio;

import dominio.actuadores.Actuador;
import dominio.actuadores.comandos.ComandoApagar;
import dominio.actuadores.comandos.ComandoEncender;
import dominio.dispositivo.DispositivoInteligente;
import dominio.dispositivo.fisicos.DispositivoFisico;

public class Actuadores {

	public Actuador actuadorApagar(DispositivoFisico fisico, DispositivoInteligente logico) {
		return new Actuador(new ComandoApagar(fisico), logico);
	}

	public Actuador actuadorEncender(DispositivoFisico fisico, DispositivoInteligente logico) {
		return new Actuador(new ComandoEncender(fisico), logico);
	}
}
