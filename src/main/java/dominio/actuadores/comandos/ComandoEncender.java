package dominio.actuadores.comandos;

import dominio.dispositivo.DispositivoInteligente;
import dominio.dispositivo.DispositivoInteligente.EstadoDispositivo;
import dominio.dispositivo.fisicos.DispositivoFisico;

public class ComandoEncender implements Comando {

	private DispositivoFisico dispositivoFisico;
	
	public ComandoEncender(DispositivoFisico dispositivoFisico) {
		super();
		this.dispositivoFisico = dispositivoFisico;
	}
	
	@Override
	public void ejecutarSobre(DispositivoInteligente dispositivoLogico) {
		dispositivoLogico.setEstadoDispositivo(EstadoDispositivo.ON);
		dispositivoFisico.encender();
	}

}
