package dominio.dispositivo;

public interface Modo {

	public enum EstadoDispositivo {
		ON, OFF
	}
	
	public Double darConsumo(Dispositivo dispositivo);
	public void cambiarAEstado(Dispositivo dispositivo, EstadoDispositivo estado);
}
