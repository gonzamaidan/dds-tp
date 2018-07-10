package dominio.dispositivo;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import dominio.dispositivo.fisicos.DispositivoFisico;
import dominio.dispositivo.fisicos.TipoGenerico;

public class DispositivoInteligente {

	DispositivoFisico dispositivoFisico;
	EstadoDispositivo estadoDispositivo;
	UsoDeDispositivo usoDispositivoActual;
	List<UsoDeDispositivo> todosLosUsos;

	public DispositivoInteligente(DispositivoFisico dispositivo) {
		this.dispositivoFisico = dispositivo;
		this.estadoDispositivo = EstadoDispositivo.OFF;
		this.todosLosUsos = new ArrayList<UsoDeDispositivo>();
	}

	/**
	 * Existe para garantizar compatibilidad con el DispositivoInteligenteAdaptado
	 */
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
		Double horasDeConsumo = this.cantidadHorasTotalesDeUsoEntre(fechaInicio, fechaFin);
		return horasDeConsumo * this.getConsumo();
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
			ejecutarUsoDeDispositivo();
			dispositivoFisico.encender();
		}
	}
	
	public void apagarse() {
		if (!this.estaApagado()) {
			this.estadoDispositivo = EstadoDispositivo.OFF;
			terminarUsoDeDispositivo();
			dispositivoFisico.apagar();
		}
	}

	public void ejecutarUsoDeDispositivo() {
		this.usoDispositivoActual = new UsoDeDispositivo();
		usoDispositivoActual.setFechaHoraEncendido(LocalDateTime.now());
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

	public TipoGenerico getNombreGenerico() {
		return dispositivoFisico.getNombreGenerico();
	}

	public Double getConsumo() {
		return dispositivoFisico.getConsumo();
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
