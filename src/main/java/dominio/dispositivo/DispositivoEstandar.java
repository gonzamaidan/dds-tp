package dominio.dispositivo;

public class DispositivoEstandar {
	
	private String nombreGenerico;
	private Double consumo;
	private Integer horasDeUsoPromedio;

	public DispositivoEstandar(String nombreGenerico, Double consumo) {
		this.nombreGenerico = nombreGenerico;
		this.consumo = consumo;
	}
	
	/* Preguntar si esto esta bien, no se por que recibe un inteligente adaptado
	public Double darConsumo(DispositivoInteligenteAdaptado dispositivo) {
		return dispositivo.getConsumo();
	} */
	
	public Double darConsumo() {
		return this.getConsumo() * this.horasDeUsoPromedio;
	}

	public Double getConsumo() {
		return consumo;
	}
	
	public String getNombreGenerico() {
		return nombreGenerico;
	}
}
