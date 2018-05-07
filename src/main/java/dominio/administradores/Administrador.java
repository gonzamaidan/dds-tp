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
	private Integer telefono;
	private String domicilio;
	private LocalDate fechaDeAlta;
	private String usuario;

	public Administrador(String nombreYApellido, Integer telefono, String domicilio, LocalDate fechaDeAlta, String usuario, Integer idSistema) {
		this.idSistema = idSistema;
		this.nombreYApellido = nombreYApellido;
		this.telefono = telefono;
		this.domicilio = domicilio;
		this.fechaDeAlta = fechaDeAlta;
		this.usuario = usuario;
	}

	public LocalDate getFechaDeAlta() {
		return fechaDeAlta;
	}

	public Long mesesComoAdministrador() {
		return ChronoUnit.MONTHS.between(this.getFechaDeAlta(), LocalDate.now());
	}
}
