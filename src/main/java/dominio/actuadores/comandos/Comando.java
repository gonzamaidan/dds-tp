package dominio.actuadores.comandos;

import dominio.dispositivo.DispositivoInteligente;

public interface Comando {
	public void ejecutarSobre(DispositivoInteligente dispositivo);
}
