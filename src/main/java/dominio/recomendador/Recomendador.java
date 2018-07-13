package dominio.recomendador;

import java.util.List;

import dominio.dispositivo.DispositivoInteligente;

public interface Recomendador {
	public Recomendacion obtenerRecomendacion(List<DispositivoInteligente> dispositivos);
}
