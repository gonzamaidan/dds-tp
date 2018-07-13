package dominio.actuadores;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import org.junit.Test;

import fixture.Dispositivos;
import funcional.MatrizHumedad;
import funcional.MatrizInteraccionEntorno;
import funcional.MatrizTemperatura;
import dominio.Actuadores;
import dominio.Magnitud;
import dominio.Medicion;
import dominio.Regla;
import dominio.sensores.Sensor;

public class SensoresTest {

	private Dispositivos dispositivos = new Dispositivos();
	private Actuadores actuadores = new Actuadores();
	
	@Test
	public void unSensorPuedeMedir() {
		MatrizInteraccionEntorno matriz = new MatrizTemperatura();
		Sensor sensorTemperatura = matriz.crearSensor();

		assertNotNull(sensorTemperatura.medir(10.0));
	}
	
	@Test
	public void unSensorDeHumedadMideHumedad() {
		MatrizInteraccionEntorno matriz = new MatrizHumedad();
		Sensor sensorHumedad = matriz.crearSensor();
		Medicion unaMedicion = sensorHumedad.medir(60.0);
		
		assertEquals(Magnitud.Humedad, unaMedicion.getMagnitud());
	}

	@Test
	public void unSensorPuedeEnviarUnaMedicionASusReglas() {
		MatrizInteraccionEntorno matriz = new MatrizTemperatura();
		Sensor sensorTemperatura = matriz.crearSensor();
		Regla regla = matriz.crearRegla(valor -> { return valor > 1.5;}, actuadores.actuadorApagar(dispositivos.dispositivoReal()));
		
		sensorTemperatura.registrarRegla(regla);
		
		sensorTemperatura.enviarMedicion(new Medicion(Magnitud.Temperatura, 7.0));
	}
}
