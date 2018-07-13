package fixture;

import java.time.LocalDate;

import dominio.clientes.*;

public class Clientes {

	public Cliente clienteGenerico() {
		return new Cliente(new Documento(TipoDocumento.DNI, 11222333), "X Y", 12345678, "z", LocalDate.now(), "x.y");
	}

	public Cliente clienteConDispositivosInteligentes(int n) {
		Cliente cliente = clienteGenerico();
		for (int i = 0; i < n; ++i) {
			cliente.agregarDispositivo(new Dispositivos().inteligenteGenerico());
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
