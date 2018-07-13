package dominio.actuadores;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import dominio.Actuadores;
import dominio.Magnitud;
import dominio.Medicion;
import dominio.Regla;
import dominio.dispositivo.DispositivoInteligente;
import dominio.dispositivo.DispositivoInteligente.EstadoDispositivo;
import fixture.Dispositivos;
import funcional.MatrizLuminosidad;

public class ReglasTest {

	private DispositivoInteligente dispositivo;
	private Actuadores actuadores = new Actuadores();
	private MatrizLuminosidad matrizLuminosidad = new MatrizLuminosidad();
	private Regla regla;

	@Before
	public void before() {
		dispositivo = new Dispositivos().dispositivoReal();
		dispositivo.encenderse();
	
		regla = matrizLuminosidad.crearRegla(valor -> {return valor > 1.0;}, actuadores.actuadorApagar(dispositivo));
	}
	
	@Test
	public void ReglaDeberiaEjecutarseTest() {		

		regla.ejecutarSi(new Medicion(Magnitud.Luminusidad, 5.0));
		
		assertEquals("Se ejecuta la regla de apagar", EstadoDispositivo.OFF, dispositivo.getEstadoDispositivo());
	}
	
	@Test
	public void ReglaNoDeberiaEjecutarsePorMagnitudTest() {
		regla.ejecutarSi(new Medicion(Magnitud.Humedad, 5.0));

		assertEquals("No se ejecuta la regla de apagar", EstadoDispositivo.ON, dispositivo.getEstadoDispositivo());
	}
	
	@Test
	public void ReglaNoDeberiaEjecutarsePorMedicionTest() {

		regla.ejecutarSi(new Medicion(Magnitud.Luminusidad, 1.0));
		assertEquals("No se ejecuta la regla de apagar", EstadoDispositivo.ON, dispositivo.getEstadoDispositivo());
	}
}
