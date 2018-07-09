package dominio.actuadores;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import dominio.actuadores.comandos.ComandoApagar;
import dominio.actuadores.comandos.ComandoEncender;
import dominio.dispositivo.DispositivoInteligente;
import dominio.dispositivo.DispositivoInteligente.EstadoDispositivo;
import dominio.dispositivo.fisicos.Lampara;
import dominio.dispositivo.fisicos.TipoConcreto;

public class ActuadorTest {

	private DispositivoInteligente dispositivo;
	
	@Before
	public void before() {
		dispositivo = new DispositivoInteligente(new Lampara(TipoConcreto.De11W));
	}
	
	@Test
	public void ComandoApagarTest() {
		Actuador actuador = new Actuador(new ComandoApagar(), dispositivo);
		dispositivo.encenderse();

		actuador.actuar();
		assertEquals("El dispositivo esta apagado despues de ejecutar el actuador", EstadoDispositivo.OFF, dispositivo.getEstadoDispositivo());
	}
	
	@Test
	public void ComandoEncenderTest() {
		Actuador actuador = new Actuador(new ComandoEncender(), dispositivo);
		dispositivo.apagarse();

		actuador.actuar();
		assertEquals("El dispositivo esta encendido despues de ejecutar el actuador", EstadoDispositivo.ON, dispositivo.getEstadoDispositivo());
	}
	
}
