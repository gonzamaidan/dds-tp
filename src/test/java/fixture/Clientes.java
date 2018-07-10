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
}
