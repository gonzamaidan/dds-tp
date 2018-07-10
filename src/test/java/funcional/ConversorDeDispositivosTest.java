package funcional;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import dominio.clientes.Cliente;
import dominio.dispositivo.ConversorDeDispositivos;
import dominio.dispositivo.DispositivoEstandar;
import fixture.Clientes;
import fixture.Dispositivos;

public class ConversorDeDispositivosTest {
	
	private ConversorDeDispositivos conversor;
	private Dispositivos dispositivos;
	private Cliente cliente;
	
	@Before
	public void init() {
		conversor = new ConversorDeDispositivos();
		dispositivos = new Dispositivos();
		cliente = new Clientes().clienteGenerico();
	}
	
	@Test
	public void conviertoUnDispositivoEstandarSuma10PuntosAlCliente() {
		DispositivoEstandar estandar = dispositivos.estandarGenerico();
		cliente.agregarDispositivoEstandar(estandar);
		
		conversor.convertir(estandar, cliente);
		
		assertEquals(10, cliente.getPuntaje());
	}
	
	@Test
	public void cuandoConviertoUnDispositivoSeBorraDeLaListaDeEstandar() {
		DispositivoEstandar estandar = dispositivos.estandarGenerico();
		cliente.agregarDispositivoEstandar(estandar);
		
		conversor.convertir(estandar, cliente);
		
		assertEquals(0, cliente.cantidadDeDispositivosEstandar());
	}
	
	@Test
	public void cuandoConviertoUnDispositivoSeAgregaALaListaDeInteligentes() {
		DispositivoEstandar estandar = dispositivos.estandarGenerico();
		cliente.agregarDispositivoEstandar(estandar);

		conversor.convertir(estandar, cliente);
		
		assertEquals(1, cliente.cantidadDeDispositivosInteligentes());
	}
	
	@Test
	public void elDispositivoEstandarConvertidoSeGuardaComoReferenciaEnElNuevoDispositivo() {
		DispositivoEstandar estandar = dispositivos.estandarGenerico();
		cliente.agregarDispositivoEstandar(estandar);
		
		conversor.convertir(estandar, cliente);
		
		assertEquals(cliente.getDispositivosInteligentes().stream().findAny().get().getDispositivoAdaptado(), 
				estandar);
	}
	
}
