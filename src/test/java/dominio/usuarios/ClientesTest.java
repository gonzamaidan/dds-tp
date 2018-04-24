package dominio.usuarios;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.time.LocalDate;

import org.junit.Before;
import org.junit.Test;

import dominio.Categoria;
import dominio.Dispositivo;
import dominio.Dispositivo.EstadoDispositivo;
import dominio.clientes.Cliente;
import dominio.clientes.Documento;
import dominio.clientes.TipoDocumento;

public class ClientesTest {
	
	Cliente cliente;
	Dispositivo dispositivo1;
	Dispositivo dispositivo2;
	
	@Before
	public void init() {
		String nombre1 = "dispositivo 1";
		Integer kwPorHora1 = 1234;
		EstadoDispositivo estado1 = EstadoDispositivo.ON;
		dispositivo1 = new Dispositivo(nombre1, kwPorHora1, estado1);
		
		String nombre2 = "dispositivo 2";
		Integer kwPorHora2 = 123;
		EstadoDispositivo estado2 = EstadoDispositivo.OFF;
		dispositivo2 = new Dispositivo(nombre2, kwPorHora2, estado2);
		
		Documento documento = new Documento(TipoDocumento.DNI, 12345678);
		String nombreYApellido = "Cliente";
		String domicilio = "Calle falsa 123";
		LocalDate fechaDeAlta = LocalDate.of(1990, 5, 28);
		Categoria categoria = Categoria.R3;
		Integer telefono = 44444444;
		String usuario = "clienteUser";
		cliente = new Cliente(documento, nombreYApellido, telefono, domicilio, fechaDeAlta,  usuario, categoria);
	}
	
	@Test
	public void clienteSabeSiAlgunoDeSusDispositivosEstaEncendido() {
		cliente.agregarDispositivo(dispositivo1);
		cliente.agregarDispositivo(dispositivo2);
		assertTrue(cliente.tieneAlgunDispositivoEncendido());
	}
	
	@Test
	public void clienteSabeLaCantidadDeDispositivosEncendidos() {
		cliente.agregarDispositivo(dispositivo1);
		cliente.agregarDispositivo(dispositivo2);
		assertEquals(1, cliente.cantidadDeDispositivosEncendidos());
	}
	
	@Test
	public void clienteSabeLaCantidadDeDispositivosAgregados() {
		cliente.agregarDispositivo(dispositivo1);
		cliente.agregarDispositivo(dispositivo2);
		assertEquals(2, cliente.cantidadTotalDeDispositivos());
	}
	
	@Test
	public void clienteSabeLaCantidadDeDispositivosApagados() {
		cliente.agregarDispositivo(dispositivo1);
		cliente.agregarDispositivo(dispositivo2);
		assertEquals(1, cliente.cantidadDeDispositivosApagados());
	}
	
	
	
	
	
	
	
}
