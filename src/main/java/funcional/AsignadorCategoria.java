package funcional;

import java.util.Arrays;
import java.util.List;

import dominio.Categoria;

public class AsignadorCategoria {
	private List<Categoria> categorias;

	public AsignadorCategoria() {
		this.categorias = Arrays.asList(Categoria.values());
	}

	public Categoria categoriaCorrespondiente(Double monto) {
		// Categoria categoriaAsignada;
		// List<Categoria> categoriaFiltrada;
		// ;
		return categorias.stream().filter(cat -> cat.dentroDeCategoria(monto)).findAny().get();
	}

	public void agregarCategoria(Categoria cat) {
		categorias.add(cat);
	}
}
