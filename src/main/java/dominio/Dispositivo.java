package dominio;

public class Dispositivo {
	
	String nombreGenerico;
	Double consumo;
	EstadoDispositivo estadoDispositivo;
	
	public Dispositivo(String nombreGenerico, Double consumo, EstadoDispositivo estadoDispositivo) {
		this.nombreGenerico = nombreGenerico;
		this.consumo = consumo;
		this.estadoDispositivo = estadoDispositivo;
	}

	public enum EstadoDispositivo{
		ON, OFF
	}

	public boolean estaEncendido() {
		return estadoDispositivo.equals(EstadoDispositivo.ON);
		
	}
	
	public boolean estaApagado() {
		return !this.estaEncendido();
	}
	
	
	// SETTERS Y GETTERS (Accessors ;D)
	
	public String getNombreGenerico() {
		return nombreGenerico;
	}

	public void setNombreGenerico(String nombreGenerico) {
		this.nombreGenerico = nombreGenerico;
	}

	public Double getConsumo() {
		return consumo;
	}

	public void setConsumo(Double consumo) {
		this.consumo = consumo;
	}

	public EstadoDispositivo getEstadoDispositivo() {
		return estadoDispositivo;
	}

	public void setEstadoDispositivo(EstadoDispositivo estadoDispositivo) {
		this.estadoDispositivo = estadoDispositivo;
	}
	
	

}
