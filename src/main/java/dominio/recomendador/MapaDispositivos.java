package dominio.recomendador;

import java.util.EnumMap;

import dominio.dispositivo.fisicos.TipoGenerico;

public enum MapaDispositivos {

	x1(TipoGenerico.AireAcondicionado, 90.0, 360.0),
	x2(TipoGenerico.Televisor, 90.0, 360.0),
	x3(TipoGenerico.Lavarropa, 6.0, 30.0),
	x4(TipoGenerico.Ventilador, 120.0, 360.0),
	x5(TipoGenerico.Lampara, 90.0, 360.0),
	x6(TipoGenerico.PC, 60.0, 360.0),
	x7(TipoGenerico.Microondas, 3.0, 15.0),
	x8(TipoGenerico.Plancha, 3.0, 30.0);
	
	
	private TipoGenerico tipo;
	private Double min;
	private Double max;

	MapaDispositivos(TipoGenerico tipo, Double min, Double max) {
		this.tipo = tipo;
		this.min = min;
		this.max = max;
	}
	
	static public EnumMap<TipoGenerico, MapaDispositivos> mapa = new EnumMap<>(TipoGenerico.class);
	static {
		for (MapaDispositivos registro : MapaDispositivos.values()) {
			mapa.put(registro.getTipo(), registro);
		}
	}
	
	static public Double consumoMaximoDe(TipoGenerico tipo) {
		return mapa.get(tipo).getMax();
	}

	static public Double consumoMinimoDe(TipoGenerico tipo) {
		return mapa.get(tipo).getMin();
	}
	
	public TipoGenerico getTipo() {
		return tipo;
	}
	
	public Double getMin() {
		return min;
	}
	
	public Double getMax() {
		return max;
	}
}
