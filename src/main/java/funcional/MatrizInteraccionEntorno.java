package funcional;

import java.util.function.Predicate;

import dominio.Medicion;
import dominio.Regla;
import dominio.actuadores.Actuador;
import dominio.sensores.Sensor;

public abstract class MatrizInteraccionEntorno {

	protected Sensor tipoSensor;
	
	public abstract Sensor crearSensor();

	public Regla crearRegla(Predicate<Double> condicion, Actuador actuador) {
		Predicate<Medicion> condicionRegla = this.crearCondicionRegla(condicion);
		return new Regla(condicionRegla, actuador);
	}
	
	private Predicate<Medicion> crearCondicionRegla(Predicate<Double> condicion) {
		return (medicion -> {return medicion.esDeMagnitud(tipoSensor.getMagnitud()) && medicion.verificar(condicion);} );
	}
}
