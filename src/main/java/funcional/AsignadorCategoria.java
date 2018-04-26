package funcional;

import java.util.Arrays;
import java.util.List;

import dominio.Categoria;

public class AsignadorCategoria {
	private List<Categoria> categorias;

	public AsignadorCategoria() {
		this.categorias = Arrays.asList(Categoria.values());
	}

	public Categoria asignarCategoriaSegun(Double consumo) {
		// Categoria categoriaAsignada;
		// List<Categoria> categoriaFiltrada;
		// ;
		return categorias.stream().filter(cat -> cat.dentroDeCategoria(consumo)).findAny().get();
	}

	public void agregarCategoria(Categoria cat) {
		categorias.add(cat);
	}
}
