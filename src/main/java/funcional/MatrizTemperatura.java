package funcional;

import dominio.sensores.Sensor;
import dominio.sensores.SensorTemperatura;

public class MatrizTemperatura extends MatrizInteraccionEntorno {

	public MatrizTemperatura() {
		this.tipoSensor = new SensorTemperatura();
	}

	@Override
	public Sensor crearSensor() {
		return new SensorTemperatura();
	}
}
