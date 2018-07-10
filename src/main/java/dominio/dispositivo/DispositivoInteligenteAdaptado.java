package dominio.dispositivo;

public class DispositivoInteligenteAdaptado extends DispositivoInteligente {
	
	private DispositivoEstandar dispositivoConvertido;

	public DispositivoInteligenteAdaptado(DispositivoEstandar dispositivo) {
		super(dispositivo);
		this.dispositivoConvertido = dispositivo;
	}
	
	@Override
	public DispositivoEstandar getDispositivoAdaptado() {
		return this.dispositivoConvertido;
	}
}