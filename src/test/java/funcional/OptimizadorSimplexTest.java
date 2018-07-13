package funcional;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import dominio.dispositivo.DispositivoInteligente;
import dominio.dispositivo.fisicos.TipoConcreto;
import dominio.recomendador.MapaDispositivos;
import dominio.recomendador.OptimizadorSimplex;
import dominio.recomendador.Recomendacion;
import dominio.recomendador.Recomendador;
import fixture.Dispositivos;

public class OptimizadorSimplexTest {

	private Double tolerRelativaTest = 0.00001;
	
	private Double consumoMaximoNegocio = 612.0;
	private Recomendador recomendador = new OptimizadorSimplex(consumoMaximoNegocio);
	private Dispositivos disps = new Dispositivos();
	private List<DispositivoInteligente> dispositivos;

	@Before
	public void testSetup() {
		 dispositivos = new ArrayList<DispositivoInteligente>();
	}

	@Test
	public void lasHorasOptimasParaUnUnicoDispositivoEsElMaximoDelDispositivo() {
		DispositivoInteligente dispositivo = disps.lampara(TipoConcreto.Halogena40W);
		dispositivos.add(dispositivo);
		Double horasEsperadas = MapaDispositivos.horasMaximasDe(dispositivo.getTipoGenerico());

		Recomendacion recomendacion = recomendador.obtenerRecomendacion(dispositivos);

		assertEquals(horasEsperadas, recomendacion.getHorasDeDispositivo(dispositivo.getTipoGenerico()), tolerRelativaTest);
	}

	@Test
	public void elConsumoOptimoParaUnUnicoDispositivoEsElProductoMaximoDelDispositivo() {
		DispositivoInteligente dispositivo = disps.lampara(TipoConcreto.Halogena100W);
		dispositivos.add(dispositivo);
		Double consumoEsperado = dispositivo.getConsumo() * MapaDispositivos.horasMaximasDe(dispositivo.getTipoGenerico()); 

		Recomendacion recomendacion = recomendador.obtenerRecomendacion(dispositivos);
	
		assertEquals(consumoEsperado, recomendacion.getConsumoOptimo(), tolerRelativaTest);
	}
	
	@Test
	public void elConsumoMaximoNoEsSuperado() {
		dispositivos.add(disps.aireAcondicionado(TipoConcreto.De3500Frigorias));
		dispositivos.add(disps.aireAcondicionado(TipoConcreto.De2200Frigorias));

		Recomendacion recomendacion = recomendador.obtenerRecomendacion(dispositivos);
		
		assertEquals(consumoMaximoNegocio, recomendacion.getConsumoOptimo(), tolerRelativaTest);
	}

	@Test
	public void elConsumoSeMultiplicaParaVariosDispositivosRepetidos() {
		Integer cantidad = 3;
		dispositivos.add(disps.lampara(TipoConcreto.De11W));
		Recomendacion primeraRecomendacion = recomendador.obtenerRecomendacion(dispositivos);
		
		for (Integer i = 1; i < cantidad; ++i)
			dispositivos.add(disps.lampara(TipoConcreto.De11W));
		
		
		Recomendacion recomendacionMultiple = recomendador.obtenerRecomendacion(dispositivos);
		
		assertEquals(primeraRecomendacion.getConsumoOptimo() * cantidad, recomendacionMultiple.getConsumoOptimo(), tolerRelativaTest);
	}
}
