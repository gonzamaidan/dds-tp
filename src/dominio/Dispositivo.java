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
		if(estadoDispositivo.equals(EstadoDispositivo.ON)) {
			return true;
		}else {
			return false;
		}
	}
	
	public boolean estaApagado() {
		if(estadoDispositivo.equals(EstadoDispositivo.OFF)) {
			return true;
		}else {
			return false;
		}
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
