package dominio.dispositivo;

public class DispositivoInteligente {
	
	String nombreGenerico;
	Double consumo;
	EstadoDispositivo estadoDispositivo;
	
	public DispositivoInteligente() {
		this.nombreGenerico = nombreGenerico;
		this.consumo = consumo;
		this.estadoDispositivo = estadoDispositivo;
	}

	public enum EstadoDispositivo{
		ON, OFF, MODO_AHORRO;
	}
	
	public double consumoEnUltimasHoras(int horas) {
		return horas * consumo;
	}

	public boolean estaEncendido() {
		return estadoDispositivo.equals(EstadoDispositivo.ON);
		
	}
	
	public boolean estaApagado() {
		return estadoDispositivo.equals(EstadoDispositivo.OFF);
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

	public DispositivoEstandar getDispositivoAdaptado() {
		return null;
	}
	
	

}
