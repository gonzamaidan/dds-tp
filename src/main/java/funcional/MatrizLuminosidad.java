package funcional;

import dominio.sensores.Sensor;
import dominio.sensores.SensorLuminosidad;

public class MatrizLuminosidad extends MatrizInteraccionEntorno {

	public MatrizLuminosidad() {
		this.tipoSensor = new SensorLuminosidad();
	}

	@Override
	public Sensor crearSensor() {
		return new SensorLuminosidad();
	}
}
