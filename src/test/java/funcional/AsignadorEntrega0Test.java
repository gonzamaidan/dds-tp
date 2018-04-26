package funcional;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import dominio.Categoria;

public class AsignadorEntrega0Test {

	private Categoria resultadoR1 ;
	private Categoria resultadoR2 ;
	private Categoria resultadoR3 ;
	private Categoria resultadoR4 ;
	private Categoria resultadoR5 ;
	private Categoria resultadoR6 ;
	private Categoria resultadoR7 ;
	private Categoria resultadoR8 ;
	private Categoria resultadoR9 ;	
	private AsignadorCategoria asignadorTeasteado;
	@Before
	public void antesDeProbarAsignadorCategoria(){
			asignadorTeasteado = new AsignadorCategoria();
					
 }
			
	@Test
	public void AsignadorRetornaCategoriaR1Test() {
		resultadoR1= asignadorTeasteado.categoriaCorrespondiente(135.00);
		assertEquals("Testeando categoria R1", Categoria.R1, resultadoR1);
	}
	
	@Test
	public void AsignadorRetornaCategoriaR2Test() {
		resultadoR2= asignadorTeasteado.categoriaCorrespondiente(325.00);
		assertEquals("Testeando categoria R2", Categoria.R2, resultadoR2);
	}
	
	@Test
	public void AsignadorRetornaCategoriaR3Test() {
		resultadoR3= asignadorTeasteado.categoriaCorrespondiente(325.01);
		assertEquals("Testeando categoria R3", Categoria.R3, resultadoR3);
	}
	
	@Test
	public void AsignadorRetornaCategoriaR4Test() {
		resultadoR4= asignadorTeasteado.categoriaCorrespondiente(430.00);
		assertEquals("Testeando categoria R4", Categoria.R4, resultadoR4);
	}
	
	@Test
	public void AsignadorRetornaCategoriaR5Test() {
		resultadoR5= asignadorTeasteado.categoriaCorrespondiente(465.00);
		assertEquals("Testeando categoria R5", Categoria.R5, resultadoR5);
	}
	
	@Test
	public void AsignadorRetornaCategoriaR6Test() {
		resultadoR6= asignadorTeasteado.categoriaCorrespondiente(501.00);
		assertEquals("Testeando categoria R6", Categoria.R6, resultadoR6);
	}
	
	@Test
	public void AsignadorRetornaCategoriaR7Test() {
		resultadoR7= asignadorTeasteado.categoriaCorrespondiente(699.99);
		assertEquals("Testeando categoria R7", Categoria.R7, resultadoR7);
	}
	
	@Test
	public void AsignadorRetornaCategoriaR8Test() {
		resultadoR8= asignadorTeasteado.categoriaCorrespondiente(700.01);
		assertEquals("Testeando categoria R8", Categoria.R8, resultadoR8);
	}

	@Test
	public void AsignadorRetornaCategoriaR9Test() {
		resultadoR9= asignadorTeasteado.categoriaCorrespondiente(2001.59);
		assertEquals("Testeando categoria R9", Categoria.R9, resultadoR9);
	}
	
}
