package funcional;

import static org.junit.Assert.assertEquals;

import java.time.LocalDate;

import org.junit.Before;
import org.junit.Test;

import dominio.clientes.Cliente;
import dominio.clientes.Documento;
import dominio.clientes.TipoDocumento;
import dominio.dispositivo.ConversorDeDispositivos;
import dominio.dispositivo.DispositivoEstandar;
import dominio.dispositivo.DispositivoInteligente;

public class ConversorDeDispositivosTest {
	
	private ConversorDeDispositivos conversor;
	private DispositivoEstandar dispositivoEstandar;
	private DispositivoInteligente dispositivoInteligente;
	private Cliente cliente;
	
	@Before
	public void init() {
		conversor = new ConversorDeDispositivos();
		dispositivoEstandar = new DispositivoEstandar();
		dispositivoInteligente = new DispositivoInteligente();
		Documento documento = new Documento(TipoDocumento.DNI, 12345678);
		String nombreYApellido = "Nuevo Usuario";
		Integer telefono = 0303456;
		String domicilio = "donde vive";
		LocalDate fechaDeAlta = LocalDate.now();
		String usuario = "usuario";
		cliente = new Cliente(documento, nombreYApellido, telefono, domicilio, fechaDeAlta, usuario);
	}
	
	@Test
	public void conviertoUnDispositivoEstandarSuma10PuntosAlCliente() {
		cliente.agregarDispositivo(dispositivoInteligente);
		cliente.agregarDispositivoEstandar(dispositivoEstandar);
		conversor.convertir(dispositivoEstandar, cliente);
		
		assertEquals(10, cliente.getPuntaje());
	}
	
	@Test
	public void cuandoConviertoUnDispositivoSeBorraDeLaListaDeEstandar() {
		cliente.agregarDispositivo(dispositivoInteligente);
		cliente.agregarDispositivoEstandar(dispositivoEstandar);
		conversor.convertir(dispositivoEstandar, cliente);
		
		assertEquals(0, cliente.cantidadDeDispositivosEstandar());
	}
	
	@Test
	public void cuandoConviertoUnDispositivoSeAgregaALaListaDeInteligentes() {
		cliente.agregarDispositivo(dispositivoInteligente);
		cliente.agregarDispositivoEstandar(dispositivoEstandar);
		conversor.convertir(dispositivoEstandar, cliente);
		
		assertEquals(2, cliente.cantidadDeDispositivosInteligentes());
	}
	
	@Test
	public void elDispositivoEstandarConvertidoSeGuardaComoReferenciaEnElNuevoDispositivo() {
		cliente.agregarDispositivoEstandar(dispositivoEstandar);
		conversor.convertir(dispositivoEstandar, cliente);
		
		assertEquals(cliente.getDispositivosInteligentes().stream().findAny().get().getDispositivoAdaptado(), 
				dispositivoEstandar);
	}
	
}
