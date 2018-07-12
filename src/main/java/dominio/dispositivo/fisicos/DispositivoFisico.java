package dominio.dispositivo.fisicos;

import dominio.dispositivo.DispositivoInteligente.EstadoDispositivo;

/**
 * 
 * Esta clase representa a un elemento fisico concreto y la conexion con este dispositivo,
 * ya que como minimo debe poder encenderse y apagarse.
 * Si llegan a existir otros dispositivos con mas funciones se debera extender esta interfaz.
 * Ejemplo:
 * 	Un aire acondicionado puede subir o bajar la temperatura, cuando tengamos esto se extiende
 *  una interfaz que agregue estos metodos y luego cada implementacion depende de como se conecta
 *  con ese aire acondicionado.
 *
 */
public abstract class DispositivoFisico {

	protected TipoGenerico tipoGenerico;
	protected TipoConcreto tipoConcreto;
	protected EstadoDispositivo estado;
	
	public DispositivoFisico(TipoGenerico tipoGenerico, TipoConcreto tipoConcreto) {
		this.tipoGenerico = tipoGenerico;
		this.tipoConcreto = tipoConcreto;
	}
	
	public TipoGenerico getNombreGenerico() {
		return this.tipoGenerico;
	}
	
	public TipoConcreto getSubtipo() {
		return this.tipoConcreto;
	}
	
	public Boolean esInteligente() {
		return this.tipoConcreto.esInteligente();
	}

	public Double getConsumo() {
		return this.tipoConcreto.getConsumo();
	}

	public EstadoDispositivo getEstado() {
		return estado;
	}

	public abstract void apagar();

	public abstract void encender();
}
