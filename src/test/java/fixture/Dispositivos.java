package fixture;

import dominio.Dispositivo;
import dominio.Dispositivo.EstadoDispositivo;

public class Dispositivos {

	public static Dispositivo dispositivoGenerico() {
		return new Dispositivo("X", new Double(1), EstadoDispositivo.ON);
	}
	
	public static Dispositivo dipositivoConConsumo(Double consumo) {
		Dispositivo dispositivo = dispositivoGenerico();
		dispositivo.setConsumo(consumo);
		return dispositivo;
	}
	
	public static Dispositivo dipositivoConEstado(EstadoDispositivo estado) {
		Dispositivo dispositivo = dispositivoGenerico();
		dispositivo.setEstadoDispositivo(estado);
		return dispositivo;
	}
}
