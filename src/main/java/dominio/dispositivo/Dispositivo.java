package dominio.dispositivo;

import dominio.dispositivo.Modo;
import dominio.dispositivo.Modo.EstadoDispositivo;

public class Dispositivo {
	
	String nombre;
	Double consumo;
	EstadoDispositivo estadoDispositivo;
	Modo modo;
	
	public Dispositivo(String nombre, Double consumo, EstadoDispositivo estadoDispositivo, Modo modo) {
		this.nombre = nombre;
		this.consumo = consumo;
		this.estadoDispositivo = estadoDispositivo;
	}

	public Double getConsumo() {
		return consumo;
	}

	public void setEstado(EstadoDispositivo estado) {
		this.estadoDispositivo = estado;
	}
}
