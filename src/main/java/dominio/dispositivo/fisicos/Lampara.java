package dominio.dispositivo.fisicos;

import dominio.dispositivo.DispositivoInteligente.EstadoDispositivo;

/**
 * Esta clase representa la conexion con una lampara real, deberia existir una
 * libreria para manejar esta lampara con la cual tenemos que interactuar.
 *
 */
public class Lampara extends DispositivoFisico {

	private EstadoDispositivo estado;

	public Lampara(TipoConcreto subtipo) {
		super(TipoGenerico.Lampara, subtipo);
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

	public EstadoDispositivo getEstado() {
		return estado;
	}
}
