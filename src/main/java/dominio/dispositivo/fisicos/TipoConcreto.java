package dominio.dispositivo.fisicos;

public enum TipoConcreto {

	// Aires Acondicionados
	De3500Frigorias(TipoGenerico.AireAcondicionado, Boolean.TRUE, Boolean.FALSE, 1.613),
	De2200Frigorias(TipoGenerico.AireAcondicionado, Boolean.TRUE, Boolean.TRUE, 1.013),
	
	// Televisores
	TuboDe21(TipoGenerico.Televisor, Boolean.FALSE, Boolean.FALSE, 0.075),
	TuboDe29a34(TipoGenerico.Televisor, Boolean.FALSE, Boolean.FALSE, 0.175),
	LCDde40(TipoGenerico.Televisor, Boolean.FALSE, Boolean.FALSE, 0.18),
	LEDde32(TipoGenerico.Televisor, Boolean.TRUE, Boolean.TRUE, 0.055),
	LEDde40(TipoGenerico.Televisor, Boolean.TRUE, Boolean.TRUE, 0.08),
	
	// Heladeras
	ConFreezer(TipoGenerico.Heladera, Boolean.TRUE, Boolean.TRUE, 0.09),
	SinFreezer(TipoGenerico.Heladera, Boolean.TRUE, Boolean.TRUE, 0.075),
	
	// Lavarropas
	Automatico5kgConCalentamiento(TipoGenerico.Lavarropa, Boolean.FALSE, Boolean.FALSE, 0.875),
	Automatico5kg(TipoGenerico.Lavarropa, Boolean.TRUE, Boolean.TRUE, 0.175),
	SemiAutomatico5kg(TipoGenerico.Lavarropa, Boolean.FALSE, Boolean.TRUE, 0.1275),
	
	// Ventiladores
	DePie(TipoGenerico.Ventilador, Boolean.FALSE, Boolean.TRUE, 0.09),
	DeTecho(TipoGenerico.Ventilador, Boolean.TRUE, Boolean.TRUE, 0.06),
	
	// Lamparas
	Halogena40W(TipoGenerico.Lampara, Boolean.TRUE, Boolean.FALSE, 0.04),
	Halogena60W(TipoGenerico.Lampara, Boolean.TRUE, Boolean.FALSE, 0.06),
	Halogena100W(TipoGenerico.Lampara, Boolean.TRUE, Boolean.FALSE, 0.015),
	De11W(TipoGenerico.Lampara, Boolean.TRUE, Boolean.TRUE, 0.011),
	De12W(TipoGenerico.Lampara, Boolean.TRUE, Boolean.TRUE, 0.015),
	De20W(TipoGenerico.Lampara, Boolean.TRUE, Boolean.TRUE, 0.02),

	// PCs
	DeEscritorio(TipoGenerico.PC, Boolean.TRUE, Boolean.TRUE, 0.4),

	// Microondas
	Convencional(TipoGenerico.Microondas, Boolean.FALSE, Boolean.TRUE, 0.64),
	
	// Planchas
	AVapor(TipoGenerico.Plancha, Boolean.FALSE, Boolean.TRUE, 0.75);
	
	private Boolean esInteligente;
	private Boolean esBajoConsumo;
	private TipoGenerico tipoGenerico;
	private Double consumo;

	TipoConcreto(TipoGenerico tipoGenerico, Boolean esInteligente, Boolean esBajoConsumo, Double consumo) {
		this.tipoGenerico = tipoGenerico;
		this.esInteligente = esInteligente;
		this.esBajoConsumo = esBajoConsumo;
		this.consumo = consumo;
	}

	public Double getConsumo() {
		return this.consumo;
	}

	public Boolean esInteligente() {
		return this.esInteligente;
	}

	public Boolean esBajoConsumo() {
		return this.esBajoConsumo;
	}

}
