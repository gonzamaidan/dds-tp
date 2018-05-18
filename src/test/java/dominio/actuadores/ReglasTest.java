package dominio.actuadores;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import dominio.Dispositivo;
import dominio.Magnitud;
import dominio.Regla;
import dominio.Dispositivo.EstadoDispositivo;
import dominio.actuadores.comandos.ComandoApagar;
import fixture.Dispositivos;

public class ReglasTest {

	private Dispositivo dispositivoGenerico;
	private Actuador apagar;
	private Regla regla;
	@Before
	public void before() {
		dispositivoGenerico = new Dispositivos().dispositivoGenerico();
		apagar = new Actuador(new ComandoApagar(), dispositivoGenerico);
		regla = new Regla((medicion,  magnitud) -> {
			return medicion > 1.0 && Magnitud.Luminusidad.equals(magnitud);
		}, apagar);
	}
	
	
	@Test
	public void ReglaDeberiaEjecutarseTest() {
		dispositivoGenerico.setEstadoDispositivo(EstadoDispositivo.ON);

		regla.ejecutarSi(5.0, Magnitud.Luminusidad);
		assertEquals("Se ejecuta la regla de apagar", EstadoDispositivo.OFF, dispositivoGenerico.getEstadoDispositivo());
	}
	
	@Test
	public void ReglaNoDeberiaEjecutarsePorMagnitudTest() {
		dispositivoGenerico.setEstadoDispositivo(EstadoDispositivo.ON);

		regla.ejecutarSi(5.0, Magnitud.Humedad);
		assertEquals("No se ejecuta la regla de apagar", EstadoDispositivo.ON, dispositivoGenerico.getEstadoDispositivo());
	}
	@Test
	public void ReglaNoDeberiaEjecutarsePorMedicionTest() {
		dispositivoGenerico.setEstadoDispositivo(EstadoDispositivo.ON);

		regla.ejecutarSi(1.0, Magnitud.Luminusidad);
		assertEquals("No se ejecuta la regla de apagar", EstadoDispositivo.ON, dispositivoGenerico.getEstadoDispositivo());
	}
}
