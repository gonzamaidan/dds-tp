package dominio.actuadores.comandos;

import dominio.dispositivo.DispositivoInteligente;
import dominio.dispositivo.DispositivoInteligente.EstadoDispositivo;
import dominio.dispositivo.fisicos.DispositivoFisico;

public class ComandoApagar implements Comando {
	
	private DispositivoFisico dispositivoFisico;
	
	public ComandoApagar(DispositivoFisico dispositivoFisico) {
		super();
		this.dispositivoFisico = dispositivoFisico;
	}

	@Override
	public void ejecutarSobre(DispositivoInteligente dispositivoLogico) {
		dispositivoLogico.setEstadoDispositivo(EstadoDispositivo.OFF);
		dispositivoFisico.apagar();
	}
	
}
