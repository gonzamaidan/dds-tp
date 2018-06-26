package dominio.actuadores;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import dominio.Actuadores;
import dominio.Magnitud;
import dominio.Medicion;
import dominio.Regla;
import dominio.ReglasBuilder;
import dominio.actuadores.comandos.ComandoApagar;
import dominio.dispositivo.DispositivoInteligente;
import dominio.dispositivo.DispositivoInteligente.EstadoDispositivo;
import dominio.dispositivo.fisicos.DispositivoFisico;
import dominio.dispositivo.fisicos.Lampara;
import fixture.Dispositivos;
import funcional.MatrizHumedad;
import funcional.MatrizLuminosidad;
import funcional.MatrizTemperatura;

public class ReglasTest {

	private Actuadores actuadores = new Actuadores();
	private MatrizLuminosidad matrizLuminosidad = new MatrizLuminosidad();
	private MatrizHumedad matrizHumedad = new MatrizHumedad();
	private MatrizTemperatura matrizTemperatura = new MatrizTemperatura();
	private DispositivoInteligente logico;
	private DispositivoFisico fisico;
	private Regla regla;

	@Before
	public void before() {
		logico = new Dispositivos().dispositivoGenerico();
		logico.setEstadoDispositivo(EstadoDispositivo.ON);
		fisico = new Dispositivos().dispositivoFisico();
	
		regla = matrizLuminosidad.crearRegla(valor -> {return valor > 1.0;}, actuadores.actuadorApagar(fisico, logico));
	}
	
	@Test
	public void ReglaDeberiaEjecutarseTest() {		

		regla.ejecutarSi(new Medicion(Magnitud.Luminusidad, 5.0));
		
		assertEquals("Se ejecuta la regla de apagar", EstadoDispositivo.OFF, logico.getEstadoDispositivo());
	}
	
	@Test
	public void ReglaNoDeberiaEjecutarsePorMagnitudTest() {

		regla.ejecutarSi(new Medicion(Magnitud.Humedad, 5.0));
		assertEquals("No se ejecuta la regla de apagar", EstadoDispositivo.ON, logico.getEstadoDispositivo());
	}
	@Test
	public void ReglaNoDeberiaEjecutarsePorMedicionTest() {

		regla.ejecutarSi(new Medicion(Magnitud.Luminusidad, 1.0));
		assertEquals("No se ejecuta la regla de apagar", EstadoDispositivo.ON, logico.getEstadoDispositivo());
	}
}
