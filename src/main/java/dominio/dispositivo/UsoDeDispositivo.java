package dominio.dispositivo;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;


public class UsoDeDispositivo {

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
	
}
