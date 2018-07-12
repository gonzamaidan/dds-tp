package dominio.dispositivo.fisicos;

import dominio.dispositivo.DispositivoInteligente.EstadoDispositivo;

public class AireAcondicionado extends DispositivoFisico {

	public AireAcondicionado(TipoConcreto subTipo) {
		super(TipoGenerico.AireAcondicionado, subTipo);
	}

	public Double getConsumo() {
		return this.tipoConcreto.getConsumo();
	}

	public void apagar() {
		estado = EstadoDispositivo.OFF;
	}

	public void encender() {
		estado = EstadoDispositivo.ON;
	}
}
