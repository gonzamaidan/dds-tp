package dominio.sensores;

import dominio.Magnitud;

/**
 * Esta clase representa la conexion con un sensor de temperatura. .
 *
 */
public class SensorTemperatura extends Sensor {
	public SensorTemperatura() {
		super(Magnitud.Temperatura);
	}
}
