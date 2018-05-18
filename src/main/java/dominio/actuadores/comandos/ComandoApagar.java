package dominio.actuadores.comandos;

import dominio.Dispositivo;
import dominio.Dispositivo.EstadoDispositivo;

public class ComandoApagar implements Comando {

	@Override
	public void ejecutarSobre(Dispositivo dispositivo) {
		dispositivo.setEstadoDispositivo(EstadoDispositivo.OFF);
	}
	
}
