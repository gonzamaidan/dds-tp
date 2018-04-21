package dominio.clientes;

import java.time.LocalDate;
import java.util.ArrayList;

import dominio.Categoria;
import dominio.Dispositivo;
import dominio.usuarios.DatosUsuario;

/**
 * Representa un usuario cliente del sistema
 *
 */
public class Cliente {

	private Documento documento;
	private DatosUsuario datosDeUsuario;
	private ArrayList<Dispositivo> dispositivos;
	private Categoria categoria;

	public Cliente(Documento documento, String nombreYApellido, Integer telefono, String domicilio, LocalDate fechaDeAlta, String usuario, Categoria categoria) {
		this.documento = documento;
		this.datosDeUsuario = new DatosUsuario(nombreYApellido, telefono, domicilio, fechaDeAlta, usuario);
		this.dispositivos = new ArrayList<>();
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

	public double calcularFactura(double consumo) {
		return this.categoria.calcularMontoMensual(consumo);
	}
}
