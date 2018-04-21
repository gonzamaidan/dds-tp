package dominio.usuarios;

import java.time.LocalDate;

public class DatosUsuario {
	String nombreYApellido;
	Integer telefono;
	String domicilio;
	LocalDate fechaDeAlta;
	String usuario;

	public DatosUsuario(String nombreYApellido, Integer telefono, String domicilio, LocalDate fechaDeAlta, String usuario) {
		super();
		this.nombreYApellido = nombreYApellido;
		this.telefono = telefono;
		this.domicilio = domicilio;
		this.fechaDeAlta = fechaDeAlta;
		this.usuario = usuario;
	}

	public String getNombreYApellido() {
		return nombreYApellido;
	}

	public Integer getTelefono() {
		return telefono;
	}

	public String getDomicilio() {
		return domicilio;
	}

	public LocalDate getFechaDeAlta() {
		return fechaDeAlta;
	}

	public String getUsuario() {
		return usuario;
	}

}
