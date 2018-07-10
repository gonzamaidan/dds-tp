package dominio.actuadores;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import dominio.Magnitud;
import dominio.Regla;
import dominio.ReglasBuilder;
import dominio.dispositivo.DispositivoInteligente;
import dominio.dispositivo.DispositivoInteligente.EstadoDispositivo;
import fixture.Dispositivos;

public class ReglasTest {

	private ReglasBuilder reglas;
	private DispositivoInteligente dispositivo;
	private Regla regla;

	@Before
	public void before() {
		reglas = new ReglasBuilder();
		dispositivo = new Dispositivos().dispositivoReal();

		regla = reglas.conDispositivoLogico(dispositivo)
				.conCondicion((medicion,  magnitud) -> {
					return medicion > 1.0 && Magnitud.Luminusidad.equals(magnitud);
				})
				.crearApagar();
	}
	
	@Test
	public void ReglaDeberiaEjecutarseTest() {
		dispositivo.encenderse();

		regla.ejecutarSi(5.0, Magnitud.Luminusidad);
		assertEquals("Se ejecuta la regla de apagar", EstadoDispositivo.OFF, dispositivo.getEstadoDispositivo());
	}
	
	@Test
	public void ReglaNoDeberiaEjecutarsePorMagnitudTest() {
		dispositivo.encenderse();

		regla.ejecutarSi(5.0, Magnitud.Humedad);
		assertEquals("No se ejecuta la regla de apagar", EstadoDispositivo.ON, dispositivo.getEstadoDispositivo());
	}
	@Test
	public void ReglaNoDeberiaEjecutarsePorMedicionTest() {
		dispositivo.encenderse();

		regla.ejecutarSi(1.0, Magnitud.Luminusidad);
		assertEquals("No se ejecuta la regla de apagar", EstadoDispositivo.ON, dispositivo.getEstadoDispositivo());
	}
}
