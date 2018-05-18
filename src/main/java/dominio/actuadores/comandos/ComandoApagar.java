package dominio.actuadores.comandos;

import dominio.dispositivo.DispositivoInteligente;
import dominio.dispositivo.DispositivoInteligente.EstadoDispositivo;

public class ComandoApagar implements Comando {

	@Override
	public void ejecutarSobre(DispositivoInteligente dispositivo) {
		dispositivo.setEstadoDispositivo(EstadoDispositivo.OFF);
	}
	
}
