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
	private Double horasMin;
	private Double horasMax;
	static public EnumMap<TipoGenerico, MapaDispositivos> mapa = new EnumMap<>(TipoGenerico.class);

	MapaDispositivos(TipoGenerico tipo, Double horasMin, Double horasMax) {
		this.tipo = tipo;
		this.horasMin = horasMin;
		this.horasMax = horasMax;
	}
	
	static {
		for (MapaDispositivos registro : MapaDispositivos.values()) {
			mapa.put(registro.getTipo(), registro);
		}
	}

	static public MapaDispositivos obtenerPorTipo(TipoGenerico tipoGenerico) {
		return mapa.get(tipoGenerico);
	}
	
	static public Integer getPosicionDe(TipoGenerico tipo) {
		return mapa.get(tipo).ordinal();
	}
	
	static public Double horasMaximasDe(TipoGenerico tipo) {
		return mapa.get(tipo).getHorasMax();
	}

	static public Double horasMinimasDe(TipoGenerico tipo) {
		return mapa.get(tipo).getHorasMin();
	}
	
	public TipoGenerico getTipo() {
		return tipo;
	}
	
	public Double getHorasMin() {
		return horasMin;
	}
	
	public Double getHorasMax() {
		return horasMax;
	}
}
