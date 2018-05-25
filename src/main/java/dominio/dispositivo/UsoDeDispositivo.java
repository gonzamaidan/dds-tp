package dominio.dispositivo;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.Map;
import java.util.TreeMap;

import dominio.dispositivo.DispositivoInteligente.EstadoDispositivo;

public class UsoDeDispositivo {
	//lista con fecha y estado
	//Map<LocalDate, EstadoDispositivo> estados = new TreeMap<LocalDate, EstadoDispositivo>();

	LocalDateTime fechaHoraInicio;
	LocalDateTime fechaHoraFin;
	
	public double cantidadDehorasEntre() {
		return ChronoUnit.HOURS.between(fechaHoraInicio, fechaHoraFin);
	}

	public void setFechaHoraInicio(LocalDateTime fechaHoraInicio) {
		this.fechaHoraInicio = fechaHoraInicio;
	}

	public void setFechaHoraFin(LocalDateTime fechaHoraFin) {
		this.fechaHoraFin = fechaHoraFin;
	}
	
	
	
	/*
	public void agregarCambioDeEstado(EstadoDispositivo estadoDispositivo) {
		estados.put(LocalDate.now(), estadoDispositivo);
	}*/
}
