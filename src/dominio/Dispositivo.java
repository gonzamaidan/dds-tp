package dominio;

public class Dispositivo {
	
	String nombreGenerico;
	Integer kWConsumePorHora;
	EstadoDispositivo estadoDispositivo;
	
	public Dispositivo(String nombreGenerico, Integer kWConsumePorHora, EstadoDispositivo estadoDispositivo) {
		this.nombreGenerico = nombreGenerico;
		this.kWConsumePorHora = kWConsumePorHora;
		this.estadoDispositivo = estadoDispositivo;
	}

	public enum EstadoDispositivo{
		ON, OFF
	}

	public boolean estaEncendido() {
		return estadoDispositivo.equals(EstadoDispositivo.ON);
		
	}
	
	public boolean estaApagado() {
		return estadoDispositivo.equals(EstadoDispositivo.OFF);
	}
	
	
	// SETTERS Y GETTERS
	
	public String getNombreGenerico() {
		return nombreGenerico;
	}

	public void setNombreGenerico(String nombreGenerico) {
		this.nombreGenerico = nombreGenerico;
	}

	public Integer getkWConsumePorHora() {
		return kWConsumePorHora;
	}

	public void setkWConsumePorHora(Integer kWConsumePorHora) {
		this.kWConsumePorHora = kWConsumePorHora;
	}

	public EstadoDispositivo getEstadoDispositivo() {
		return estadoDispositivo;
	}

	public void setEstadoDispositivo(EstadoDispositivo estadoDispositivo) {
		this.estadoDispositivo = estadoDispositivo;
	}
	
	

}
