package dominio.dispositivo;

public class DispositivoEstandar {
	
	String nombreGenerico;
	Double consumo;
	int horasDeUsoPromedio;

	public Double darConsumo(DispositivoInteligenteAdaptado dispositivo) {
		return dispositivo.getConsumo();
	}

	public Double getConsumo() {
		return consumo;
	}
	
	public String getNombreGenerico() {
		return nombreGenerico;
	}
}
