package dominio.actuadores.comandos;

import dominio.dispositivo.DispositivoInteligente;

public class ComandoApagar implements Comando {
	
	@Override
	public void ejecutarSobre(DispositivoInteligente dispositivo) {
		dispositivo.apagarse();
	}	
}
