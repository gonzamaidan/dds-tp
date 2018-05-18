package dominio.dispositivo;

import dominio.clientes.Cliente;

public class ConversorDeDispositivos {
	
	public void convertir(DispositivoEstandar dispositivoAConvertir, Cliente cliente) {
		cliente.sacarDispositivoEstandar(dispositivoAConvertir);
		cliente.agregarDispositivo(new DispositivoInteligenteAdaptado(dispositivoAConvertir));
		cliente.sumarPuntos(10);
	}
}
