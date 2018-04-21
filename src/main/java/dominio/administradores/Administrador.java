package dominio.administradores;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

import dominio.usuarios.DatosUsuario;
/**
 * Representa un usuario administrador del sistema
 *
 */
public class Administrador {

	private Integer idSistema;
	private DatosUsuario datosDeUsuario;

	public Administrador(String nombreYApellido, Integer telefono, String domicilio, LocalDate fechaDeAlta, String usuario, Integer idSistema) {
		this.datosDeUsuario = new DatosUsuario(nombreYApellido, telefono, domicilio, fechaDeAlta, usuario);
		this.idSistema = idSistema;
	}

	public LocalDate getFechaDeAlta() {
		return datosDeUsuario.getFechaDeAlta();
	}

	public Long mesesComoAdministrador() {
		return ChronoUnit.MONTHS.between(this.getFechaDeAlta(), LocalDate.now());
	}
}
