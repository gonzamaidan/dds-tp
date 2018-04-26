package fixture;

import java.time.LocalDate;

import dominio.clientes.*;

public class Clientes {

	public static Cliente clienteGenerico() {
		return new Cliente(new Documento(TipoDocumento.DNI, 11222333), "X Y", 12345678, "z", LocalDate.now(), "x.y");
	}

	// TODO: la categoria tiene que actualizarse aca para el fixture.
	public static Cliente clientePorConsumo(Double consumo) {
		Cliente cliente = clienteGenerico();
		cliente.agregarDispositivo(Dispositivos.dipositivoConConsumo(consumo));
		return cliente;
	}

	public static Cliente clienteConDispositivos(int n) {
		Cliente cliente = clienteGenerico();
		for (int i = 0; i < n; ++i) {
			cliente.agregarDispositivo(Dispositivos.dispositivoGenerico());
		}
		return cliente;
	}
}
