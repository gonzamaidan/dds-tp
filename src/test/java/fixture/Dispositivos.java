package fixture;

import dominio.dispositivo.DispositivoEstandar;
import dominio.dispositivo.DispositivoInteligente;
import dominio.dispositivo.DispositivoInteligente.EstadoDispositivo;
import dominio.dispositivo.fisicos.AireAcondicionado;
import dominio.dispositivo.fisicos.DispositivoFisico;
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

	public DispositivoFisico dispositivoFisico() {
		return new Lampara(TipoConcreto.De11W);
	}

	public DispositivoInteligente dispoitivo1() {
		return new DispositivoInteligente(new Lampara(TipoConcreto.De11W));
	}

	public DispositivoInteligente dispoitivo2() {
		return new DispositivoInteligente(new Lampara(TipoConcreto.De12W));
	}

	public DispositivoInteligente dispoitivo3() {
		return new DispositivoInteligente(new Lampara(TipoConcreto.De20W));
	}

	public DispositivoInteligente dispoitivo4() {
		return new DispositivoInteligente(new AireAcondicionado(TipoConcreto.De2200Frigorias));
	}

	public DispositivoInteligente dispoitivo5() {
		return new DispositivoInteligente(new AireAcondicionado(TipoConcreto.De2200Frigorias));
	}

	public DispositivoInteligente dispoitivo6() {
		return new DispositivoInteligente(new AireAcondicionado(TipoConcreto.De2200Frigorias));
	}
}
