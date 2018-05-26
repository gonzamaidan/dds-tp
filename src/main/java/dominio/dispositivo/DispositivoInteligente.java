package dominio.dispositivo;

import java.time.LocalDateTime;
import java.util.List;

public class DispositivoInteligente {

	String nombreGenerico;
	Double consumo;
	EstadoDispositivo estadoDispositivo;
	//UsoDeDispositivo usoDeDispositivo; crear la lista de usos
	UsoDeDispositivo usoDispositivoActual;
	List<UsoDeDispositivo> todosLosUsos;

	public DispositivoInteligente(String nombreGenerico, Double consumo, EstadoDispositivo estadoDispositivo) {
		this.nombreGenerico = nombreGenerico;
		this.consumo = consumo;
		this.estadoDispositivo = estadoDispositivo;
		
	}

	public DispositivoInteligente(DispositivoEstandar dispositivo) {
	}

	public enum EstadoDispositivo {
		ON, OFF, MODO_AHORRO;
	}
	
	/*
	public void crearUsoDeDispositivo(EstadoDispositivo estadoDispositivo) {
		this.usoDeDispositivo = new UsoDeDispositivo();
		this.usoDeDispositivo.agregarCambioDeEstado(estadoDispositivo);
	}
*/
	public Double consumoEnElPeriodo(LocalDateTime fechaInicio, LocalDateTime fechaFin) {

		double horasDeConsumo = this.cantidadHorasTotalesDeUsoEntre(fechaInicio, fechaFin);
		return horasDeConsumo * consumo;
	}
	
	public Double cantidadHorasTotalesDeUsoEntre(LocalDateTime fechaInicio, LocalDateTime fechaFin) {
		
		return todosLosUsos.stream().mapToDouble(uso -> uso.horasDeUsoEntre(fechaInicio, fechaFin)).sum();
	}

	public Double consumoEnUltimasHoras(Long horas) {
		LocalDateTime horaActual = LocalDateTime.now();
		LocalDateTime horaInicial = horaActual.minusHours(horas); 
		return consumoEnElPeriodo(horaInicial, horaActual);
		
	}

	

	public void encenderse() {
		if (this.estaApagado() || this.estaEnModoAhorro()) {
			this.estadoDispositivo = EstadoDispositivo.ON;
			this.ejecutarUsoDeDispositivo();
		}
	}
	
	public void ejecutarUsoDeDispositivo() {
		this.usoDispositivoActual = new UsoDeDispositivo();
		usoDispositivoActual.setFechaHoraEncendido(LocalDateTime.now());
	}
	
	
	
	
	public void apagarse() {
		if (!this.estaApagado()) {
			this.estadoDispositivo = EstadoDispositivo.OFF;
			this.terminarUsoDeDispositivo();
		}
	}
	
	public void terminarUsoDeDispositivo() {
		usoDispositivoActual.setFechaHoraApagado(LocalDateTime.now());
		todosLosUsos.add(usoDispositivoActual);
	}
	
	
	

	public Boolean estaEncendido() {
		return estadoDispositivo.equals(EstadoDispositivo.ON);

	}

	public Boolean estaApagado() {
		return estadoDispositivo.equals(EstadoDispositivo.OFF);
	}

	public Boolean estaEnModoAhorro() {
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
