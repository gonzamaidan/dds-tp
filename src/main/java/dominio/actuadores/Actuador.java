package dominio.actuadores;

import dominio.Dispositivo;
import dominio.actuadores.comandos.Comando;

public class Actuador {

	private Comando comando;
	private Dispositivo dispositivo;
	
	public Actuador(Comando comando, Dispositivo dispositivo) {
		this.comando = comando;
		this.dispositivo = dispositivo;
	}
	
	public void actuar() {
		this.comando.ejecutarSobre(dispositivo);
	}
	
}
