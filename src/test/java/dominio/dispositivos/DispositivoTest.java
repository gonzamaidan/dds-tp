package dominio.dispositivos;

import static org.junit.Assert.assertEquals;

import java.time.LocalDateTime;

import org.junit.Before;
import org.junit.Test;

import dominio.dispositivo.DispositivoInteligente;
import dominio.dispositivo.UsoDeDispositivo;
import fixture.Dispositivos;

public class DispositivoTest {
	private UsoDeDispositivo uso;
	private LocalDateTime fechaHoraEncendido;
	private LocalDateTime fechaHoraApagado;
	
	@Before
	public void inicializar() {
		uso = new UsoDeDispositivo();
		fechaHoraEncendido = LocalDateTime.of(2000, 5, 5, 1, 0);
		fechaHoraApagado = LocalDateTime.of(2000, 5, 5, 5, 0);
		uso.setFechaHoraEncendido(fechaHoraEncendido);
		uso.setFechaHoraApagado(fechaHoraApagado);
	}
	
	@Test
	public void calculoLasHorasDeUsoCuandoElRangoEstaDentroDelRangoDelConsumo() {
		LocalDateTime fechaInicio = LocalDateTime.of(2000, 5, 5, 2, 0);
		LocalDateTime fechaFin = LocalDateTime.of(2000, 5, 5, 3, 0);
		
		assertEquals(1, uso.horasDeUsoEntre(fechaInicio, fechaFin), 0.00000000001);
	}
	
	@Test
	public void calculoLasHorasDeUsoCuandoElRangoNoEstaDentroDelRangoDelConsumo() {
		LocalDateTime fechaInicio = LocalDateTime.of(2000, 5, 5, 0, 0);
		LocalDateTime fechaFin = LocalDateTime.of(2000, 5, 5, 6, 0);
		
		assertEquals(4, uso.horasDeUsoEntre(fechaInicio, fechaFin), 0.00000000001);
	}
	
	@Test
	public void consumoEnLasUltimasNHorasDentroDelRangoDeConsumo() {
		DispositivoInteligente dispositivo = Dispositivos.dispositivoGenerico();
		dispositivo.encenderse();
		dispositivo.apagarse();
		
		assertEquals(0, dispositivo.consumoEnUltimasHoras(3L), 0.0000001);
		
	}
}
