package dominio.clientes;

import java.util.ArrayList;

import dominio.Dispositivo;

/**
 * Representa un usuario cliente del sistema
 *
 */
public class UsuarioCliente {

	Documento documento;
	String contrasenia;
	String categoria; // Despues vemos si hacemos clases, por ahora lo pongo como String
	ArrayList<Dispositivo> dispositivos = new ArrayList<>();

	public UsuarioCliente(Documento documento, String contrasenia, String categoria) {
		super();
		this.documento = documento;
		this.contrasenia = contrasenia;
		this.categoria = categoria;
	}

	public void agregarDispositivo(Dispositivo dispositivo) {
		dispositivos.add(dispositivo);
	}

	public boolean tieneAlgunDispositivoEncendido() {
		return dispositivos.stream().anyMatch(disp -> disp.estaEncendido());
	}

	public long cantidadDeDispositivosEncendidos() {
		return dispositivos.stream().filter(disp -> disp.estaEncendido()).count();
	}

	public long cantidadDeDispositivosApagados() {
		return dispositivos.stream().filter(disp -> disp.estaApagado()).count();
	}

	public int cantidadTotalDeDispositivos() {
		return dispositivos.size();
	}

}
