package dominio;

public class Posicion {

	private Double  longitud;
	private Double latitud;
	
	
	
public Posicion(Double longitud, Double latitud) {
		this.longitud = longitud;
		this.latitud = latitud;
	}

public  Double calcularKilometrosDesde(Posicion posicion) {
		
	Double radioTerrestre = 6371.00;
		
	Double latitudOrigen = posicion.getLatitud();
		
	Double latitudDestino = this.latitud;
		
	Double longitudOrigen = posicion.getLongitud();
		
	Double longitudDestino = this.longitud;
		
	Double dLat = Math.toRadians(latitudDestino - latitudOrigen);
		
	Double dLon = Math.toRadians(longitudDestino - longitudOrigen);
		
	Double a = Math.sin(dLat/2) * Math.sin(dLat/2) +
				Math.cos(Math.toRadians(latitudOrigen)) * Math.cos(Math.toRadians(latitudDestino)) *
				Math.sin(dLon/2) * Math.sin(dLon/2);
	Double c = 2 * Math.asin(Math.sqrt(a));
		
		return radioTerrestre * c;
	}

public Double getLongitud() {
	return longitud;
}

public Double getLatitud() {
	return latitud;
}
}
