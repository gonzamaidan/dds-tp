package fixture;

import dominio.Dispositivo;
import dominio.Dispositivo.EstadoDispositivo;

public class Dispositivos {

	public Dispositivo dispositivoGenerico() {
		return new Dispositivo("X", new Double(1), EstadoDispositivo.ON);
	}
	
	public Dispositivo dipositivoConConsumo(Double consumo) {
		Dispositivo dispositivo = this.dispositivoGenerico();
		dispositivo.setConsumo(consumo);
		return dispositivo;
	}
	
	public Dispositivo dipositivoConEstado(EstadoDispositivo estado) {
		Dispositivo dispositivo = this.dispositivoGenerico();
		dispositivo.setEstadoDispositivo(estado);
		return dispositivo;
	}
}
