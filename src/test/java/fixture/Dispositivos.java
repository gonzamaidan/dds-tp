package fixture;

import dominio.dispositivo.DispositivoInteligente;
import dominio.dispositivo.DispositivoInteligente.EstadoDispositivo;

public class Dispositivos {

	public static DispositivoInteligente dispositivoGenerico() {
		return new DispositivoInteligente();
	}
	
	public static DispositivoInteligente dipositivoConConsumo(Double consumo) {
		DispositivoInteligente dispositivo = dispositivoGenerico();
		dispositivo.setConsumo(consumo);
		return dispositivo;
	}
	
	public static DispositivoInteligente dipositivoConEstado(EstadoDispositivo estado) {
		DispositivoInteligente dispositivo = dispositivoGenerico();
		dispositivo.setEstadoDispositivo(estado);
		return dispositivo;
	}
}
