package dominio.actuadores;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import dominio.Magnitud;
import dominio.Regla;
import dominio.ReglasBuilder;
import dominio.actuadores.comandos.ComandoApagar;
import dominio.dispositivo.DispositivoInteligente;
import dominio.dispositivo.DispositivoInteligente.EstadoDispositivo;
import dominio.dispositivo.fisicos.Lampara;
import fixture.Dispositivos;

public class ReglasTest {

	private ReglasBuilder reglas;
	private DispositivoInteligente dispositivoGenerico;
	private Regla regla;

	@Before
	public void before() {
		reglas = new ReglasBuilder();
		dispositivoGenerico = new Dispositivos().dispositivoGenerico();

		regla = reglas.conDispositivoLogico(dispositivoGenerico)
				.conDispositivoFisico(new Lampara())
				.conCondicion((medicion,  magnitud) -> {
					return medicion > 1.0 && Magnitud.Luminusidad.equals(magnitud);
				})
				.crearApagar();
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
