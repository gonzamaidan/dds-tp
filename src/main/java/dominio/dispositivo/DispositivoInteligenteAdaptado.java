package dominio.dispositivo;

public class DispositivoInteligenteAdaptado extends DispositivoInteligente {
	
	DispositivoEstandar dispositivoConvertido;
	
	public DispositivoInteligenteAdaptado(DispositivoEstandar dispositivo) {
		this.dispositivoConvertido = dispositivo;
	}
}