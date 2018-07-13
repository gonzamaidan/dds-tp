package dominio.actuadores.comandos;

import dominio.dispositivo.DispositivoInteligente;

public class ComandoEncender implements Comando {
	
	@Override
	public void ejecutarSobre(DispositivoInteligente dispositivo) {
		dispositivo.encenderse();
	}
}
