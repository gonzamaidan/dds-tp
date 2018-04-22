package dominio.usuarios;

import static org.junit.Assert.assertTrue;

import java.time.LocalDate;
import java.util.ArrayList;

import org.junit.Assert;
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
		ArrayList<Dispositivo> dispositivos = new ArrayList<>();
		Categoria categoria = Categoria.R3;
		cliente = new Cliente(documento, nombreYApellido, domicilio, fechaDeAlta, dispositivos, categoria);
	}
	
	@Test
	public void clienteSabeSiAlgunoDeSusDispositivosEstaEncendido() {
		cliente.agregarDispositivo(dispositivo1);
		cliente.agregarDispositivo(dispositivo2);
		assertTrue(cliente.tieneAlgunDispositivoEncendido());
	}
	
	
	
	
	
	
	
	
	
	
	
	
}
