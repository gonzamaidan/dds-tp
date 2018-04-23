package dominio;

import java.time.LocalDate;

import dominio.Dispositivo.EstadoDispositivo;
import dominio.clientes.Cliente;
import dominio.clientes.Documento;
import dominio.clientes.TipoDocumento;
import funcional.AsignadorCategoria;

public class Main {

	public static void main(String[] args) {
		
		Dispositivo disp1 = new Dispositivo("Heladera", new Integer(50), EstadoDispositivo.OFF);
		Dispositivo disp2 = new Dispositivo("Heladera", new Integer(50), EstadoDispositivo.ON);
		Dispositivo disp3 = new Dispositivo("Heladera", new Integer(50), EstadoDispositivo.ON);
		Dispositivo disp4 = new Dispositivo("Heladera", new Integer(50), EstadoDispositivo.ON);
		Dispositivo disp5 = new Dispositivo("Heladera", new Integer(50), EstadoDispositivo.ON);
		
		String nombreYApellido = "";
		Integer telefono = 1;
		String domicilio = "";
		LocalDate fechaDeAlta = LocalDate.now();
		String usuario = "";
		Documento documento = new Documento(TipoDocumento.DNI,1);
		String contrasenia = "";
		String categoria = "";
		

		
		Cliente cliente = new Cliente(documento, nombreYApellido, telefono, domicilio, fechaDeAlta, usuario, Categoria.R1);
		cliente.agregarDispositivo(disp1);
		cliente.agregarDispositivo(disp2);
		cliente.agregarDispositivo(disp3);
		cliente.agregarDispositivo(disp4);
		cliente.agregarDispositivo(disp5);
		
	
		System.out.println("MontoFactura = " + cliente.calcularFactura(1));
		System.out.println("Estado = " + disp1.getEstadoDispositivo());
		
		System.out.println("Dispositivos encendidos: " + cliente.cantidadDeDispositivosEncendidos());
		System.out.println("Dispositivos apagados: " + cliente.cantidadDeDispositivosApagados());
		System.out.println("Tiene algun dispositivo encendido?: " + cliente.tieneAlgunDispositivoEncendido());
		System.out.println("Cantidad total de dispositivos: " + cliente.cantidadTotalDeDispositivos());
		
		
		// comprobando el validador de categorias
		AsignadorCategoria v1 = new AsignadorCategoria();
		
		System.out.println("De que categoria sos? = " + v1.categoriaCorrespondiente(456.90));
		

	}

}
