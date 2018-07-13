package dominio.recomendador;

import java.util.EnumMap;

import dominio.dispositivo.fisicos.TipoGenerico;

public class Recomendacion {

	private Double consumoOptimo;
	private EnumMap<TipoGenerico, Double> horasPorDispositivo;
	
	Recomendacion(Double consumoOptimo, EnumMap<TipoGenerico, Double> horasPorDispositivo) {
		this.consumoOptimo = consumoOptimo;
		this.horasPorDispositivo = horasPorDispositivo;
	}

	public Double getConsumoOptimo() {
		return consumoOptimo;
	}
	
	public EnumMap<TipoGenerico, Double> getHorasPorDispositivo() {
		return horasPorDispositivo;
	}
	
	public Double getHorasDeDispositivo(TipoGenerico tipo) {
		return horasPorDispositivo.get(tipo);
	}
	
}
