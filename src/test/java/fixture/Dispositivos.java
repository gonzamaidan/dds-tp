package fixture;

import dominio.Dispositivo;
import dominio.Dispositivo.EstadoDispositivo;

public class Dispositivos {

	public static Dispositivo dispositivoGenerico() {
		return new Dispositivo("X", 1, EstadoDispositivo.ON);
	}
	
	public static Dispositivo dipositivoConConsumo(Integer consumo) {
		Dispositivo dispositivo = dispositivoGenerico();
		dispositivo.setkWConsumePorHora(consumo);
		return dispositivo;
	}
	
	public static Dispositivo dipositivoConEstado(EstadoDispositivo estado) {
		Dispositivo dispositivo = dispositivoGenerico();
		dispositivo.setEstadoDispositivo(estado);
		return dispositivo;
	}
}
