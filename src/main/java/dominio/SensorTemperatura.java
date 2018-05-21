package dominio;

import java.util.List;

public class SensorTemperatura implements Sensor {
	private String idFabricante; 
	private Magnitud magnitud;
	private Double medicion;
	private List<Regla> reglas; // son los observadores
	@Override	
	public void medirMagnitud(int segundos) {
		System.out.println("Midiendo");
}
	public void enviarMedicion() {
		reglas.forEach(regla -> regla.ejecutarSi(medicion, magnitud));
		System.out.println("Enviando medición");
	};
 
}
