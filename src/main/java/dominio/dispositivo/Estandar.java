package dominio.dispositivo;

import java.util.Arrays;
import java.util.List;

public class Estandar implements Modo {

	public Double darConsumo(Dispositivo dispositivo) {
		return dispositivo.getConsumo();
	}

	public void cambiarAEstado(Dispositivo disp, EstadoDispositivo estado) {
		if (this.esEstadoValido(estado)){
			disp.setEstado(estado);
		}
	}

	private boolean esEstadoValido(EstadoDispositivo estado) {
		List<EstadoDispositivo> listaEstados = Arrays.asList(EstadoDispositivo.values());
		return listaEstados.stream().anyMatch(e -> e.equals(estado));
	}
}
