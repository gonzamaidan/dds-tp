package dominio.clientes;

import java.time.LocalDate;
import java.util.ArrayList;

import dominio.Categoria;
import dominio.Dispositivo;

public class Cliente {

	private Documento documento;
	private String nombreYApellido;
	private String domicilio;
	private LocalDate fechaDeAlta;
	private ArrayList<Dispositivo> dispositivos;
	private Categoria categoria;

	public Cliente(Documento documento, String nombreYApellido, String domicilio, LocalDate fechaDeAlta, Categoria categoria) {
		this.documento = documento;
		this.nombreYApellido = nombreYApellido;
		this.domicilio = domicilio;
		this.fechaDeAlta = fechaDeAlta;
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
