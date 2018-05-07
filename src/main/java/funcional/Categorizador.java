package funcional;

import java.util.Arrays;
import java.util.List;

import dominio.Categoria;

public class Categorizador {
	private List<Categoria> categorias;

	public Categorizador() {
		this.categorias = Arrays.asList(Categoria.values());
	}

	public Categoria calcularCategoriaSegun(Double consumo) {
			return categorias.stream().filter(cat -> cat.dentroDeCategoria(consumo)).findAny().get();
	}

	public void agregarCategoria(Categoria cat) {
		categorias.add(cat);
	}
}
