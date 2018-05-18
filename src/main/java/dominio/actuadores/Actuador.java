package dominio.actuadores;

import dominio.dispositivo.DispositivoInteligente;
import dominio.actuadores.comandos.Comando;

public class Actuador {

	private Comando comando;
	private DispositivoInteligente dispositivo;
	
	public Actuador(Comando comando, DispositivoInteligente dispositivo) {
		this.comando = comando;
		this.dispositivo = dispositivo;
	}
	
	public void actuar() {
		this.comando.ejecutarSobre(dispositivo);
	}
	
}
