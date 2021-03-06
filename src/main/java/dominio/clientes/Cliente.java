package dominio.clientes;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import dominio.Categoria;
import dominio.Posicion;
import dominio.ZonaGeografica;
import dominio.dispositivo.DispositivoEstandar;
import dominio.dispositivo.DispositivoInteligente;
import dominio.recomendador.Recomendacion;
import funcional.Categorizador;

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
	private List<DispositivoInteligente> dispositivos;
	// agrego la otra lista de dispositivos estandar
	private List<DispositivoEstandar> dispositivosEstandar;
	private Categorizador categorizador = new Categorizador();
	private Recomendacion recomendacion;
	// agrego atributo de puntaje
	private Integer puntaje;
	public ZonaGeografica zonaGeo;
	private Posicion posicion;

	public Cliente(Documento documento, String nombreYApellido, Integer telefono, String domicilio,
			LocalDate fechaDeAlta, String usuario) {
		this.documento = documento;
		this.nombreYApellido = nombreYApellido;
		this.telefono = telefono;
		this.fechaDeAlta = fechaDeAlta;
		this.usuario = usuario;
		this.dispositivos = new ArrayList<>();
		this.puntaje = 0;
		this.dispositivosEstandar = new ArrayList<>();

	}

	public Categoria consultarCategoria() {
		return categorizador.calcularCategoriaSegun(this.calcularConsumoTotal());
	}

	public List<DispositivoInteligente> getDispositivosInteligentes() {
		return this.dispositivos;
	}

	public void agregarDispositivo(DispositivoInteligente dispositivoInteligenteAdaptado) {
		dispositivos.add(dispositivoInteligenteAdaptado);
	}

	public void agregarDispositivoEstandar(DispositivoEstandar dispositivo) {
		dispositivosEstandar.add(dispositivo);
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
		return this.calcularConsumoDispositivosEstandar() + this.calcularConsumoDispositivosInteligentes();

	}

	public double calcularConsumoDispositivosEstandar() {
		return dispositivosEstandar.stream().mapToDouble(disp -> disp.getConsumo()).sum();

	}

	public double calcularConsumoDispositivosInteligentes() {
		return dispositivos.stream().filter(disp -> disp.estaEncendido()).mapToDouble(disp -> disp.getConsumo()).sum();
	}

	public double calcularFactura(double consumo) {
		return this.consultarCategoria().calcularMontoMensual(consumo);
	}

	public void sumarPuntos(Integer puntos) {
		this.puntaje += puntos;
	}

	public void sacarDispositivoEstandar(DispositivoEstandar dispositivo) {
		this.dispositivosEstandar.remove(dispositivo);
	}

	public int getPuntaje() {
		return this.puntaje;
	}

	public int cantidadDeDispositivosEstandar() {
		return this.dispositivosEstandar.size();
	}

	public int cantidadDeDispositivosInteligentes() {
		return this.dispositivos.size();
	}

	public Recomendacion getRecomendacion() {
		return recomendacion;
	}

	public void setRecomendacion(Recomendacion recomendacion) {
		this.recomendacion = recomendacion;
	}

	public Posicion getPosicion() {
		return posicion;
	}
}
