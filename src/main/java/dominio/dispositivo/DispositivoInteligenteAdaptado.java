package dominio.dispositivo;


public class DispositivoInteligenteAdaptado {
	
	String nombre;
	Double consumo;
	
	public DispositivoInteligenteAdaptado(String nombre, Double consumo) {
		this.nombre = nombre;
		this.consumo = consumo;
	}

	public Double getConsumo() {
		return consumo;
	}

}
