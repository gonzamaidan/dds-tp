package dominio;

import java.util.List;

public class SensorTemperatura implements Sensor {
	String id_fabricante; 
	Magnitud magnitud;
	double medicion;
	List<Actuador> actuadores; // son los observadores
	@Override	
	public void medirMagnitud(int segundos) {
		System.out.println("Midiendo");
}
	public void enviarMedicion() {
		actuadores.forEach(actuador -> actuador.actuar(medicion, magnitud));
		System.out.println("Enviando medición");
	};
 
}
