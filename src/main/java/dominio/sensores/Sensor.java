package dominio.sensores;

import java.util.ArrayList;
import java.util.List;

import dominio.Magnitud;
import dominio.Medicion;
import dominio.Regla;

public abstract class Sensor {

	private Magnitud magnitud;
	private List<Regla> reglas;

	public Sensor(Magnitud magnitud) {
		this.magnitud = magnitud;
		reglas = new ArrayList<Regla>();
	}

	public void registrarRegla(Regla regla) {
		reglas.add(regla);
	}

	public Magnitud getMagnitud() {
		return this.magnitud;
	}
	
	/*
	 * Se ejecuta cada cierto tiempo y hace de alguna manera una medicion. 
	 */
	public Medicion medir(Double segundos) {
		return new Medicion(this.magnitud, segundos);
	}

	public void enviarMedicion(Medicion medicion) {
		reglas.forEach(regla -> regla.ejecutarSi(medicion));
	}
}
