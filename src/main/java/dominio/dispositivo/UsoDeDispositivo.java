package dominio.dispositivo;

import java.time.LocalDateTime;

import java.time.temporal.ChronoUnit;

public class UsoDeDispositivo {

	LocalDateTime fechaHoraEncendido;
	LocalDateTime fechaHoraApagado;

	/*
	 * public double cantidadDehorasUsado() { return
	 * ChronoUnit.HOURS.between(fechaHoraEncendido, fechaHoraApagado); }
	 */
	
	public UsoDeDispositivo() {
		this.fechaHoraEncendido = LocalDateTime.now();
		this.fechaHoraApagado = LocalDateTime.now();
	}

	public double horasDeUsoEntre(LocalDateTime fechaInicio, LocalDateTime fechaFin) {
		LocalDateTime fechaMenor = this.maximoEntre(fechaInicio, fechaHoraEncendido);
		LocalDateTime fechaMayor = this.minimoEntre(fechaFin, fechaHoraApagado);

		return ChronoUnit.HOURS.between(fechaMenor, fechaMayor);

	}

	public LocalDateTime maximoEntre(LocalDateTime fecha1, LocalDateTime fecha2) {
		if (fecha1.isAfter(fecha2)) {
			return fecha1;
		} else {
			return fecha2;
		}
	}

	public LocalDateTime minimoEntre(LocalDateTime fecha1, LocalDateTime fecha2) {
		if (fecha1.isBefore(fecha2)) {
			return fecha1;
		} else {
			return fecha2;
		}
	}

	public void setFechaHoraEncendido(LocalDateTime fechaHoraEncendido) {
		this.fechaHoraEncendido = fechaHoraEncendido;
	}

	public void setFechaHoraApagado(LocalDateTime fechaHoraApagado) {
		this.fechaHoraApagado = fechaHoraApagado;
	}

}
