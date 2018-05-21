package dominio.dispositivo;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class DispositivoInteligente {
	
	protected String nombreGenerico;
	protected Double consumo;
	protected EstadoDispositivo estadoDispositivo;
	
		public DispositivoInteligente(String nombreGenerico, Double consumo, EstadoDispositivo estadoDispositivo) {
		this.nombreGenerico = nombreGenerico;
		this.consumo = consumo;
		this.estadoDispositivo = estadoDispositivo;
	}

	public DispositivoInteligente(DispositivoEstandar dispositivo) {}

	public enum EstadoDispositivo{
		ON, OFF, MODO_AHORRO;
	}
	
	public double consumoEnElPeriodo(LocalDate fechaInicio, LocalDate fechaFin) {
		
		double horasConsumindas = ChronoUnit.HOURS.between(fechaInicio, fechaFin);
		return this.consumoEnUltimasHoras(horasConsumindas);
	}
	
	public double consumoEnUltimasHoras(double horas) {
		return horas * consumo;
	}
	
	public void apagarse() {
		if (!this.estaApagado()) {
			this.estadoDispositivo = EstadoDispositivo.OFF;
		}
		
	}
	
	public void encenderse() {
		if (this.estaApagado() || this.estaEnModoAhorro()) {
			this.estadoDispositivo = EstadoDispositivo.ON;
		}
	}

	public boolean estaEncendido() {
		return estadoDispositivo.equals(EstadoDispositivo.ON);
		
	}
	
	public boolean estaApagado() {
		return estadoDispositivo.equals(EstadoDispositivo.OFF);
	}
	
	public boolean estaEnModoAhorro() {
		return estadoDispositivo.equals(EstadoDispositivo.MODO_AHORRO);
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
