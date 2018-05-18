package dominio.dispositivo;

public class DispositivoInteligenteAdaptado extends DispositivoInteligente {
	
	DispositivoEstandar dispositivoConvertido;
	
	
	public DispositivoInteligenteAdaptado(DispositivoEstandar dispositivo) {
		super(dispositivo);
		this.dispositivoConvertido = dispositivo;
		this.consumo = dispositivo.getConsumo();
		this.nombreGenerico = dispositivo.getNombreGenerico();
		this.estadoDispositivo = EstadoDispositivo.ON;
	}
	
	@Override
	public DispositivoEstandar getDispositivoAdaptado() {
		return this.dispositivoConvertido;
	}
}