package dominio.dispositivo.fisicos;

import dominio.dispositivo.DispositivoInteligente.EstadoDispositivo;
/**
 * Esta clase representa la conexion con una lampara real, deberia existir una
 * libreria para manejar esta lampara con la cual tenemos que interactuar.
 *
 */
public class Lampara implements DispositivoFisico {

	private EstadoDispositivo estado;

	public Lampara() {
		encender();
	}
	@Override
	public void apagar() {
		estado = EstadoDispositivo.OFF;
	}
	
	@Override
	public void encender() {
		estado = EstadoDispositivo.ON;
	}
	
	public EstadoDispositivo getEstado() {
		return estado;
	}
}
