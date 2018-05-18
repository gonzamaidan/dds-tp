package dominio.actuadores.comandos;

import dominio.Dispositivo;

public interface Comando {
	//TODO Cuando tenga los dispositivos inteligentes lo cambio
	public void ejecutarSobre(Dispositivo dispositivo);
}
