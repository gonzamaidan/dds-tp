package fixture;

import dominio.dispositivo.DispositivoInteligente;
import dominio.dispositivo.DispositivoInteligente.EstadoDispositivo;

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
	
	public DispositivoInteligente dispoitivo1() {
		return new DispositivoInteligente("Televisor", 12.3, EstadoDispositivo.ON);
	}
	
	public DispositivoInteligente dispoitivo2() {
		return new DispositivoInteligente("Cafetera", 1.1, EstadoDispositivo.OFF);
	}
		
	public DispositivoInteligente dispoitivo3() {
		return new DispositivoInteligente("Computadora", 4.2, EstadoDispositivo.ON);
	}
	public DispositivoInteligente dispoitivo4() {
		return new DispositivoInteligente("Plancha", 7.9, EstadoDispositivo.ON);
	}
	
	public DispositivoInteligente dispoitivo5() {
		return new DispositivoInteligente("Lavarropas", 18.4, EstadoDispositivo.OFF);
	}
	
	public DispositivoInteligente dispoitivo6() {
		return new DispositivoInteligente("Pava electrica", 11.4, EstadoDispositivo.ON);
	}
}
