package funcional;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.math3.optim.PointValuePair;
import org.junit.Before;
import org.junit.Test;

import dominio.dispositivo.fisicos.DispositivoFisico;
import dominio.dispositivo.fisicos.TipoConcreto;
import dominio.dispositivo.fisicos.TipoGenerico;
import dominio.recomendador.MapaDispositivos;
import dominio.recomendador.OptimizadorSimplex;
import fixture.Dispositivos;

public class SimplexSolverTest {

	private OptimizadorSimplex opt = new OptimizadorSimplex();
	private Dispositivos disps = new Dispositivos();
	private List<DispositivoFisico> dispositivos = new ArrayList<DispositivoFisico>();;
	
	@Before
	public void testSetup() {
//		List<DispositivoFisico> dispositivos = 
	}
	
	@Test
	public void lasHorasOptimasParaUnUnicoDispositivoEsElMaximoDelDispositivo() {
		MapaDispositivos dispoTesteado = MapaDispositivos.mapa.get(TipoGenerico.Lampara);
		dispositivos.add(disps.fisicoL(TipoConcreto.Halogena100W));
		Double maximoEsperado = MapaDispositivos.consumoMaximoDe(dispoTesteado.getTipo());
		
		PointValuePair p = opt.optimizar(dispositivos);
		Double valorDelDispositivo = p.getPoint()[dispoTesteado.ordinal()];
				
		assertEquals(maximoEsperado, valorDelDispositivo);
	}
}
