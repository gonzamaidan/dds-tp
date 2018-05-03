package dominio.clientes;

import java.time.LocalDate;
import java.util.ArrayList;

import dominio.Categoria;
import dominio.Dispositivo;
import funcional.AsignadorCategoria;

/*
 * Representa un usuario cliente del sistema
 *
 */
public class Cliente {

	private Documento documento;
	private String nombreYApellido;
	private Integer telefono;
	private String domicilio;
	private LocalDate fechaDeAlta;
	private String usuario;
	private ArrayList<Dispositivo> dispositivos;
	private Categoria categoria = Categoria.R1;
	private AsignadorCategoria asignador = new AsignadorCategoria();
	

	public Cliente(Documento documento, String nombreYApellido, Integer telefono, String domicilio, LocalDate fechaDeAlta, String usuario) {
		this.documento = documento;
		this.nombreYApellido = nombreYApellido;
		this.telefono = telefono;
		this.fechaDeAlta = fechaDeAlta;
		this.usuario = usuario;
		this.dispositivos = new ArrayList<>();
		
	}
	
	public void asignarCategoria() {
		this.categoria = asignador.asignarCategoriaSegun(this.calcularConsumoTotal());
	}
	

	public Categoria getCategoria() {
		return categoria;
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
	
	public double calcularConsumoTotal() {
		return dispositivos.stream()
				.filter(disp -> disp.estaEncendido())
				.mapToDouble(disp -> disp.getConsumo())
				.sum();
	}

	public double calcularFactura(double consumo) {
		return this.categoria.calcularMontoMensual(consumo);
	}
}
