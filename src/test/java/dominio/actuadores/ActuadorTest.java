package dominio.actuadores;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import dominio.actuadores.comandos.ComandoApagar;
import dominio.actuadores.comandos.ComandoEncender;
import dominio.dispositivo.DispositivoInteligente;
import dominio.dispositivo.DispositivoInteligente.EstadoDispositivo;
import dominio.dispositivo.fisicos.Lampara;
import fixture.Dispositivos;

public class ActuadorTest {

	private DispositivoInteligente dispositivoGenerico;
	
	@Before
	public void before() {
		dispositivoGenerico = new Dispositivos().dispositivoGenerico();
	}
	
	@Test
	public void ComandoApagarTest() {
		Actuador actuador = new Actuador(new ComandoApagar(new Lampara()), dispositivoGenerico);
		dispositivoGenerico.setEstadoDispositivo(EstadoDispositivo.ON);

		actuador.actuar();
		assertEquals("El dispositivo esta apagado despues de ejecutar el actuador", EstadoDispositivo.OFF, dispositivoGenerico.getEstadoDispositivo());
	}
	
	@Test
	public void ComandoEncenderTest() {
		Actuador actuador = new Actuador(new ComandoEncender(new Lampara()), dispositivoGenerico);
		dispositivoGenerico.setEstadoDispositivo(EstadoDispositivo.OFF);

		actuador.actuar();
		assertEquals("El dispositivo esta encendido despues de ejecutar el actuador", EstadoDispositivo.ON, dispositivoGenerico.getEstadoDispositivo());
	}
	
}
