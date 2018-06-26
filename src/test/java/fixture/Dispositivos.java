package fixture;

import dominio.dispositivo.DispositivoInteligente;
import dominio.dispositivo.DispositivoInteligente.EstadoDispositivo;
import dominio.dispositivo.fisicos.DispositivoFisico;
import dominio.dispositivo.fisicos.Lampara;

public class Dispositivos {

	public static DispositivoInteligente dispositivoGenerico() {
		return new DispositivoInteligente("X", new Double(1), EstadoDispositivo.OFF);
	}
	
	public DispositivoInteligente dipositivoConConsumo(Double consumo) {
		DispositivoInteligente dispositivo = dispositivoGenerico();
		dispositivo.setConsumo(consumo);
		return dispositivo;
	}
	
	public DispositivoInteligente dipositivoConEstado(EstadoDispositivo estado) {
		DispositivoInteligente dispositivo = dispositivoGenerico();
		dispositivo.setEstadoDispositivo(estado);
		return dispositivo;
	}
	
	public DispositivoFisico dispositivoFisico() {
		return new Lampara();
	}
}
