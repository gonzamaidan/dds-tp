package dominio.clientes;

import java.time.LocalDate;

public abstract class Usuario {
	String nombreYApellido;
	Integer telefono;
	String domicilio;
	LocalDate fechaDeAlta;
	String usuario;

	public Usuario(String nombreYApellido, Integer telefono, String domicilio, LocalDate fechaDeAlta, String usuario) {
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
