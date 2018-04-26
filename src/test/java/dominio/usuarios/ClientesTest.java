package dominio.usuarios;

import fixture.*;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import dominio.Dispositivo.EstadoDispositivo;
import dominio.clientes.Cliente;

public class ClientesTest {

	@Test
	public void clienteSabeSiAlgunoDeSusDispositivosEstaEncendido() {
		Cliente cliente = Clientes.clienteConDispositivos(3);
		cliente.agregarDispositivo(Dispositivos.dipositivoConEstado(EstadoDispositivo.ON));

		assertTrue(cliente.tieneAlgunDispositivoEncendido());
	}

	@Test
	public void clienteSabeLaCantidadDeDispositivosEncendidos() {
		Cliente cliente = Clientes.clienteGenerico();
		cliente.agregarDispositivo(Dispositivos.dipositivoConEstado(EstadoDispositivo.ON));
		cliente.agregarDispositivo(Dispositivos.dipositivoConEstado(EstadoDispositivo.OFF));

		assertEquals(1, cliente.cantidadDeDispositivosEncendidos());
	}

	@Test
	public void clienteSabeLaCantidadDeDispositivosAgregados() {
		int cantidad = 5;
		Cliente cliente = Clientes.clienteConDispositivos(cantidad);

		assertEquals(cantidad, cliente.cantidadTotalDeDispositivos());
	}
	
	@Test
	public void clienteTieneDosDispositivos() {
		Cliente cliente = Clientes.clienteConDispositivos(2);

		assertEquals(2, cliente.cantidadTotalDeDispositivos());
	}

	@Test
	public void clienteSabeLaCantidadDeDispositivosApagados() {
		Cliente cliente = Clientes.clienteGenerico();
		cliente.agregarDispositivo(Dispositivos.dipositivoConEstado(EstadoDispositivo.ON));
		cliente.agregarDispositivo(Dispositivos.dipositivoConEstado(EstadoDispositivo.OFF));

		assertEquals(1, cliente.cantidadDeDispositivosApagados());
	}

}
