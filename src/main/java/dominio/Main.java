package dominio;

import dominio.Cliente;
import dominio.Dispositivo;
import dominio.Dispositivo.EstadoDispositivo;
import funcional.asignadorCategoria;

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
		
		cliente.setCategoria(Categoria.R1);
	
		System.out.println("MontoFactura = " + cliente.calcularFactura(1));
		System.out.println("Estado = " + disp1.getEstadoDispositivo());
		
		System.out.println("Dispositivos encendidos: " + cliente.cantidadDeDispositivosEncendidos());
		System.out.println("Dispositivos apagados: " + cliente.cantidadDeDispositivosApagados());
		System.out.println("Tiene algun dispositivo encendido?: " + cliente.tieneAlgunDispositivoEncendido());
		System.out.println("Cantidad total de dispositivos: " + cliente.cantidadTotalDeDispositivos());
		
		
		// comprobando el validador de categorias
		asignadorCategoria v1 = new asignadorCategoria();
		v1.agregarCategoria(Categoria.R1);
		v1.agregarCategoria(Categoria.R2);
		v1.agregarCategoria(Categoria.R3);
		v1.agregarCategoria(Categoria.R4);
		v1.agregarCategoria(Categoria.R5);
		v1.agregarCategoria(Categoria.R6);
		v1.agregarCategoria(Categoria.R7);
		v1.agregarCategoria(Categoria.R8);
		v1.agregarCategoria(Categoria.R9);
		v1.categoriaCorrespondiente(120.90);
		
		System.out.println("De que categoria sos? = " + v1.categoriaCorrespondiente(456.90));
		

	}

}
