package funcional;

import dominio.sensores.Sensor;
import dominio.sensores.SensorHumedad;;

public class MatrizHumedad extends MatrizInteraccionEntorno {

	public MatrizHumedad() {
		this.tipoSensor = new SensorHumedad();
	}

	@Override
	public Sensor crearSensor() {
		return new SensorHumedad();
	}
}
