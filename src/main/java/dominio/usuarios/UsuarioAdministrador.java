package dominio.usuarios;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

/**
 * Representa un usuario administrador del sistema
 *
 */
public class UsuarioAdministrador extends Usuario {

	private Integer idSistema;

	public UsuarioAdministrador(String nombreYApellido, Integer telefono, String domicilio, LocalDate fechaDeAlta,
			String usuario, Integer idSistema) {
		super(nombreYApellido, telefono, domicilio, fechaDeAlta, usuario);
		this.idSistema = idSistema;
	}

	public Integer getIdSistema() {
		return idSistema;
	}

	public Long mesesComoAdministrador() {
		return ChronoUnit.MONTHS.between(super.getFechaDeAlta(), LocalDate.now());
	}

}
