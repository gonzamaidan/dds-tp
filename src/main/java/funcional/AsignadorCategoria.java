package funcional;

import java.util.ArrayList;
import java.util.List;

import dominio.Categoria;

public class AsignadorCategoria {
	List<Categoria> Categorias;

public AsignadorCategoria() {
	this.Categorias=  new ArrayList<Categoria>();
}
	
public Categoria categoriaCorrespondiente(Double monto) {
	// Categoria categoriaAsignada;
	 //List<Categoria> categoriaFiltrada;
	 //;
	 return Categorias.stream().filter(cat -> cat.dentroDeCategoria(monto)).findAny().get();
}
public void agregarCategoria(Categoria cat) {
	Categorias.add(cat);
}
}
