package dominio.zonaGeografica;


import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import dominio.clientes.Cliente;
import dominio.dispositivo.DispositivoInteligente.EstadoDispositivo;
import fixture.Transformadores;

public class zonaGeogafricaTest {

	private Transformadores transformadores = new Transformadores();
	
	@Test
	public void transformadorTiene4ClientesConectados() {
	
		int cantidadUsuarios = transformadores.transformadorCon4Clientes().cantidadDeUsuariosConectados();

		assertEquals(4, cantidadUsuarios);
	}
	
	@Test
	public void transformadorTiene1ClienteConectado() {
	
		int cantidadUsuarios = transformadores.transformadorCon1Cliente().cantidadDeUsuariosConectados();

		assertEquals(1, cantidadUsuarios);
	}
	

	
	@Test
	public void transformadorCon1ClienteConsume12con3Kw() {
	
		double consumoTotal = transformadores.transformadorCon1Cliente().calcularConsumoTotal();
		
		assertEquals(12.3, consumoTotal, 0);
	}
	
	@Test
	public void transformadorCon4ClientesConsume73con4Kw() {
	
		double consumoTotal = transformadores.transformadorCon4Clientes().calcularConsumoTotal();
		
		assertEquals(73.4, consumoTotal, 0);
	}
	
	
}
