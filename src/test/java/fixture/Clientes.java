package fixture;

import java.time.LocalDate;

import dominio.clientes.*;

public class Clientes {

	private Dispositivos dispositivos = new Dispositivos();
	
	public Cliente clienteGenerico() {
		return new Cliente(new Documento(TipoDocumento.DNI, 11222333), "X Y", 12345678, "z", LocalDate.now(), "x.y");
	}

	// TODO: la categoria tiene que actualizarse aca para el fixture.
	public Cliente clientePorConsumo(Double consumo) {
		Cliente cliente = clienteGenerico();
		cliente.agregarDispositivo(dispositivos.dipositivoConConsumo(consumo));
		return cliente;
	}

	public Cliente clienteConDispositivos(int n) {
		Cliente cliente = clienteGenerico();
		for (int i = 0; i < n; ++i) {
			cliente.agregarDispositivo(new Dispositivos().dispositivoGenerico());
		}
		return cliente;
	}
	
	public Cliente clienteCon1Dispositivo() {
		Cliente cliente = clienteGenerico();
		cliente.agregarDispositivo(new Dispositivos().dispoitivo1());
		return cliente;
	}
	
	public Cliente clienteCon5Dispositivos() {
		Cliente cliente = clienteGenerico();
		cliente.agregarDispositivo(new Dispositivos().dispoitivo1());
		cliente.agregarDispositivo(new Dispositivos().dispoitivo2());
		cliente.agregarDispositivo(new Dispositivos().dispoitivo3());
		cliente.agregarDispositivo(new Dispositivos().dispoitivo4());
		cliente.agregarDispositivo(new Dispositivos().dispoitivo5());
		return cliente;
	}
	
	public Cliente clienteCon2Dispositivos() {
		Cliente cliente = clienteGenerico();
		cliente.agregarDispositivo(new Dispositivos().dispoitivo1());
		cliente.agregarDispositivo(new Dispositivos().dispoitivo2());
		return cliente;
	}
	
	public Cliente clienteCon3Dispositivos() {
		Cliente cliente = clienteGenerico();
		cliente.agregarDispositivo(new Dispositivos().dispoitivo1());
		cliente.agregarDispositivo(new Dispositivos().dispoitivo2());
		cliente.agregarDispositivo(new Dispositivos().dispoitivo3());
		return cliente;
	}
	
	public Cliente clienteCon4Dispositivos() {
		Cliente cliente = clienteGenerico();
		cliente.agregarDispositivo(new Dispositivos().dispoitivo1());
		cliente.agregarDispositivo(new Dispositivos().dispoitivo2());
		cliente.agregarDispositivo(new Dispositivos().dispoitivo3());
		cliente.agregarDispositivo(new Dispositivos().dispoitivo4());
		return cliente;
	}
}
