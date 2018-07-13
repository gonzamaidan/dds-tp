package fixture;

import dominio.Posicion;
import dominio.Transformador;

public class Transformadores {
	
	Clientes clientes = new Clientes();
	
	
	public Transformador transformadorCon1Cliente() {
		Transformador transformador1 = new Transformador(new Posicion(22.3,62.1));
		transformador1.conectarCliente(clientes.clienteCon2Dispositivos());
		return transformador1;
		
	}
	
	public Transformador transformadorCon4Clientes() {
		Transformador transformador1 = new Transformador(new Posicion(20.1,80.1));
		transformador1.conectarCliente(clientes.clienteCon1Dispositivo());
		transformador1.conectarCliente(clientes.clienteCon4Dispositivos());
		transformador1.conectarCliente(clientes.clienteCon5Dispositivos());
		transformador1.conectarCliente(clientes.clienteCon2Dispositivos());
		return transformador1;
		
	}
	
	public Transformador transformadorCon3Clientes() {
		Transformador transformador1 = new Transformador(new Posicion(2.33,34.1));
		transformador1.conectarCliente(clientes.clienteCon2Dispositivos());
		transformador1.conectarCliente(clientes.clienteCon3Dispositivos());
		transformador1.conectarCliente(clientes.clienteCon5Dispositivos());
		return transformador1;
		
	}

}
