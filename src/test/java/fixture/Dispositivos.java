package fixture;

import dominio.dispositivo.DispositivoEstandar;
import dominio.dispositivo.DispositivoInteligente;
import dominio.dispositivo.DispositivoInteligente.EstadoDispositivo;
import dominio.dispositivo.fisicos.AireAcondicionado;
import dominio.dispositivo.fisicos.Lampara;
import dominio.dispositivo.fisicos.TipoConcreto;

public class Dispositivos {
	
	public DispositivoInteligente inteligenteGenerico() {
		return new DispositivoInteligente(new DispositivoFisicoMockup());
	}
	
	public DispositivoEstandar estandarGenerico() {
		return new DispositivoEstandar(new DispositivoFisicoMockup());	
	}
	
	public DispositivoInteligente dipositivoConEstado(EstadoDispositivo estado) {
		DispositivoInteligente dispositivo = inteligenteGenerico();
		dispositivo.setEstadoDispositivo(estado);
		return dispositivo;
	}
	
	public DispositivoInteligente dispositivoReal() {
		return new DispositivoInteligente(new Lampara(TipoConcreto.De20W));
	}
	
	public DispositivoInteligente lampara(TipoConcreto subTipo) {
		return new DispositivoInteligente(new Lampara(subTipo));
	}
	public DispositivoInteligente aireAcondicionado(TipoConcreto subTipo) {
		return new DispositivoInteligente(new AireAcondicionado(subTipo));
	}
}
