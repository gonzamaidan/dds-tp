package funcional;

import static org.junit.Assert.*;

import java.util.NoSuchElementException;

import org.junit.Before;
import org.junit.Test;

import dominio.Categoria;

public class CategorizadorEntrega0Test {

	private Categoria resultadoR1 ;
	private Categoria resultadoR2 ;
	private Categoria resultadoR3 ;
	private Categoria resultadoR4 ;
	private Categoria resultadoR5 ;
	private Categoria resultadoR6 ;
	private Categoria resultadoR7 ;
	private Categoria resultadoR8 ;
	private Categoria resultadoR9 ;	
	private Categorizador categorizadorTeasteado;
	@Before
	public void antesDeProbarAsignadorCategoria(){
			categorizadorTeasteado = new Categorizador();
					
 }
			
	@Test
	public void categorizadorRetornaCategoriaR1Test() {
		resultadoR1= categorizadorTeasteado.calcularCategoriaSegun(135.00);
		assertEquals("Testeando categoria R1", Categoria.R1, resultadoR1);
	}
	
	@Test
	public void categorizadorRetornaCategoriaR2Test() {
		resultadoR2= categorizadorTeasteado.calcularCategoriaSegun(325.00);
		assertEquals("Testeando categoria R2", Categoria.R2, resultadoR2);
	}
	
	@Test
	public void categorizadorRetornaCategoriaR3Test() {
		resultadoR3= categorizadorTeasteado.calcularCategoriaSegun(325.01);
		assertEquals("Testeando categoria R3", Categoria.R3, resultadoR3);
	}
	
	@Test
	public void categorizadorRetornaCategoriaR4Test() {
		resultadoR4= categorizadorTeasteado.calcularCategoriaSegun(430.00);
		assertEquals("Testeando categoria R4", Categoria.R4, resultadoR4);
	}
	
	@Test
	public void categorizadorRetornaCategoriaR5Test() {
		resultadoR5= categorizadorTeasteado.calcularCategoriaSegun(465.00);
		assertEquals("Testeando categoria R5", Categoria.R5, resultadoR5);
	}
	
	@Test
	public void categorizadorRetornaCategoriaR6Test() {
		resultadoR6= categorizadorTeasteado.calcularCategoriaSegun(501.00);
		assertEquals("Testeando categoria R6", Categoria.R6, resultadoR6);
	}
	
	@Test
	public void categorizadorRetornaCategoriaR7Test() {
		resultadoR7= categorizadorTeasteado.calcularCategoriaSegun(699.99);
		assertEquals("Testeando categoria R7", Categoria.R7, resultadoR7);
	}
	
	@Test
	public void categorizadorRetornaCategoriaR8Test() {
		resultadoR8= categorizadorTeasteado.calcularCategoriaSegun(700.01);
		assertEquals("Testeando categoria R8", Categoria.R8, resultadoR8);
	}

	@Test
	public void categorizadorRetornaCategoriaR9Test() {
		resultadoR9= categorizadorTeasteado.calcularCategoriaSegun(2001.59);
		assertEquals("Testeando categoria R9", Categoria.R9, resultadoR9);
	}
	
	@Test(expected = NoSuchElementException.class)
	public void testIndexOutOfBoundsException() {	    
	     categorizadorTeasteado.calcularCategoriaSegun(-1.59);
	}
}
