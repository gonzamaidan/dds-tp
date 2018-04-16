package dominio;

import dominio.Cliente;
import dominio.Dispositivo;
import dominio.Dispositivo.EstadoDispositivo;

public class Main {

	public static void main(String[] args) {
		
		Dispositivo disp1 = new Dispositivo("Heladera", new Integer(50), EstadoDispositivo.OFF);
		Dispositivo disp2 = new Dispositivo("Heladera", new Integer(50), EstadoDispositivo.ON);
		Dispositivo disp3 = new Dispositivo("Heladera", new Integer(50), EstadoDispositivo.ON);
		Dispositivo disp4 = new Dispositivo("Heladera", new Integer(50), EstadoDispositivo.ON);
		Dispositivo disp5 = new Dispositivo("Heladera", new Integer(50), EstadoDispositivo.ON);
		
		Cliente cliente = new Cliente();
		
		cliente.agregarDispositivo(disp1);
		cliente.agregarDispositivo(disp2);
		cliente.agregarDispositivo(disp3);
		cliente.agregarDispositivo(disp4);
		cliente.agregarDispositivo(disp5);
		
		System.out.println("Estado = " + disp1.getEstadoDispositivo());
		
		System.out.println("Dispositivos encendidos: " + cliente.cantidadDeDispositivosEncendidos());
		System.out.println("Dispositivos apagados: " + cliente.cantidadDeDispositivosApagados());
		System.out.println("Tiene algun dispositivo encendido?: " + cliente.tieneAlgunDispositivoEncendido());
		System.out.println("Cantidad total de dispositivos: " + cliente.cantidadTotalDeDispositivos());
		
		
		

	}

}
