package dominio.scheduler;

import dominio.clientes.Cliente;
import dominio.recomendador.Recomendacion;
import dominio.recomendador.Recomendador;

public class TareaRecomendador implements Tarea {

	private Recomendador recomendador;
	private Cliente cliente;

	public TareaRecomendador(Recomendador recomendador, Cliente cliente) {
		this.recomendador = recomendador;
		this.cliente = cliente;
	}


	@Override
	public void ejecutar() {
		Recomendacion recomendacion = recomendador.obtenerRecomendacion(cliente.getDispositivosInteligentes());
		cliente.setRecomendacion(recomendacion);
	}

}
