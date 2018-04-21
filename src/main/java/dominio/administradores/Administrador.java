package dominio.administradores;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
/**
 * Representa un usuario administrador del sistema
 *
 */
public class Administrador {

	private Integer idSistema;
	private String nombreYApellido;
	private String domicilio;
	private LocalDate fechaDeAlta;

	public Administrador(String nombreYApellido, String domicilio, LocalDate fechaDeAlta, Integer idSistema) {
		this.nombreYApellido = nombreYApellido;
		this.domicilio = domicilio;
		this.fechaDeAlta = fechaDeAlta;
		this.idSistema = idSistema;
	}

	public LocalDate getFechaDeAlta() {
		return fechaDeAlta;
	}

	public Long mesesComoAdministrador() {
		return ChronoUnit.MONTHS.between(this.fechaDeAlta, LocalDate.now());
	}
}
