package dominio.usuarios;

import fixture.*;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import dominio.clientes.Cliente;
import dominio.dispositivo.DispositivoInteligente.EstadoDispositivo;

public class ClientesTest {

	private Clientes clientes = new Clientes();
	private Dispositivos dispositivos = new Dispositivos();
	
	@Test
	public void clienteSabeSiAlgunoDeSusDispositivosEstaEncendido() {
		Cliente cliente = clientes.clienteConDispositivos(3);
		cliente.agregarDispositivo(dispositivos.dipositivoConEstado(EstadoDispositivo.ON));

		assertTrue(cliente.tieneAlgunDispositivoEncendido());
	}

	@Test
	public void clienteSabeLaCantidadDeDispositivosEncendidos() {
		Cliente cliente = clientes.clienteGenerico();
		cliente.agregarDispositivo(dispositivos.dipositivoConEstado(EstadoDispositivo.ON));
		cliente.agregarDispositivo(dispositivos.dipositivoConEstado(EstadoDispositivo.OFF));

		assertEquals(1, cliente.cantidadDeDispositivosEncendidos());
	}

	@Test
	public void clienteSabeLaCantidadDeDispositivosAgregados() {
		int cantidad = 5;
		Cliente cliente = clientes.clienteConDispositivos(cantidad);

		assertEquals(cantidad, cliente.cantidadTotalDeDispositivos());
	}
	
	@Test
	public void clienteTieneDosDispositivos() {
		Cliente cliente = clientes.clienteConDispositivos(2);

		assertEquals(2, cliente.cantidadTotalDeDispositivos());
	}

	@Test
	public void clienteSabeLaCantidadDeDispositivosApagados() {
		Cliente cliente = clientes.clienteGenerico();
		cliente.agregarDispositivo(dispositivos.dipositivoConEstado(EstadoDispositivo.ON));
		cliente.agregarDispositivo(dispositivos.dipositivoConEstado(EstadoDispositivo.OFF));

		assertEquals(1, cliente.cantidadDeDispositivosApagados());
	}

}
