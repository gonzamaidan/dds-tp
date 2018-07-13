package dominio.recomendador;

import java.util.ArrayList;
import java.util.Collection;
import java.util.EnumMap;
import java.util.List;

import org.apache.commons.math3.optim.MaxIter;
import org.apache.commons.math3.optim.OptimizationData;
import org.apache.commons.math3.optim.PointValuePair;
import org.apache.commons.math3.optim.linear.LinearConstraint;
import org.apache.commons.math3.optim.linear.LinearConstraintSet;
import org.apache.commons.math3.optim.linear.LinearObjectiveFunction;
import org.apache.commons.math3.optim.linear.NonNegativeConstraint;
import org.apache.commons.math3.optim.linear.Relationship;
import org.apache.commons.math3.optim.linear.SimplexSolver;
import org.apache.commons.math3.optim.nonlinear.scalar.GoalType;

import dominio.dispositivo.DispositivoInteligente;
import dominio.dispositivo.fisicos.TipoGenerico;

/**
 * Este seria el adapter contra el SimplexSolver de apache. Hay ciertos
 * parametros que no se necesitan pedir. Optimizamos para una lista de
 * dispositivos. Podriamos retornar el valor maximo de horas y en otro metodo
 * retornar las horas para cada dispositivo
 */
public class OptimizadorSimplex implements Recomendador {

	private Integer cantDispositivos;
	private Double maximoConsumo;
	private Double cotaDeError;
	private Integer limiteIteraciones;

	public OptimizadorSimplex(Double maximoConsumo) {
		this.cantDispositivos = MapaDispositivos.values().length;
		this.maximoConsumo = maximoConsumo;
		this.cotaDeError = 0.0001;
		this.limiteIteraciones = 1000;
	}

	@Override
	public Recomendacion obtenerRecomendacion(List<DispositivoInteligente> dispositivos) {
		PointValuePair valorOptimo = this.optimizar(dispositivos);
		return new Recomendacion(valorOptimo.getValue(), this.consumosPorDispositivo(valorOptimo.getPoint()));
	}
	
	private EnumMap<TipoGenerico, Double> consumosPorDispositivo(double[] consumosOptimos) {
		EnumMap<TipoGenerico, Double> consumosDispositivo = new EnumMap<>(TipoGenerico.class);
		
		for (MapaDispositivos mdisp : MapaDispositivos.values()) {
			consumosDispositivo.put(mdisp.getTipo(), consumosOptimos[mdisp.ordinal()]);
		}
		
		return consumosDispositivo;
	}

	private PointValuePair optimizar(List<DispositivoInteligente> dispositivos) {
		SimplexSolver solver = new SimplexSolver(cotaDeError);

		OptimizationData objectiveFunction = this.getFuncion(dispositivos);
		OptimizationData linearConstraints = this.getRestricciones(dispositivos);
		OptimizationData criterio = GoalType.MAXIMIZE;
		OptimizationData sinNegativas = new NonNegativeConstraint(Boolean.FALSE);
		OptimizationData maxIteraciones = new MaxIter(limiteIteraciones);

		return solver.optimize(objectiveFunction, linearConstraints, criterio, sinNegativas, maxIteraciones);
	}

	private LinearObjectiveFunction getFuncion(List<DispositivoInteligente> dispositivos) {

		double[] coeficientes = new double[cantDispositivos];
		for (DispositivoInteligente d : dispositivos) {
			int posicion = MapaDispositivos.obtenerPorTipo(d.getTipoGenerico()).ordinal();

			coeficientes[posicion] += d.getConsumo();
		}

		LinearObjectiveFunction function = new LinearObjectiveFunction(coeficientes, 0.0);
		return function;
	}

	private LinearConstraintSet getRestricciones(List<DispositivoInteligente> dispositivos) {

		Collection<LinearConstraint> restricciones = new ArrayList<LinearConstraint>();
		for (DispositivoInteligente disp : dispositivos) {

			double[] coefRestriccion = new double[cantDispositivos];
			TipoGenerico tipoDispositivo = disp.getTipoGenerico();
			coefRestriccion[MapaDispositivos.getPosicionDe(tipoDispositivo)] += 1;

			restricciones.add(new LinearConstraint(coefRestriccion, Relationship.GEQ, MapaDispositivos.horasMinimasDe(tipoDispositivo)));
			restricciones.add(new LinearConstraint(coefRestriccion, Relationship.LEQ, MapaDispositivos.horasMaximasDe(tipoDispositivo)));
		}

		restricciones.add(this.obtenerRestriccionBasica(dispositivos));
		return new LinearConstraintSet(restricciones);
	}

	private LinearConstraint obtenerRestriccionBasica(List<DispositivoInteligente> dispositivos) {

		double[] coefRestriccion = new double[cantDispositivos];
		for (DispositivoInteligente disp : dispositivos) {

			int posicion = MapaDispositivos.getPosicionDe(disp.getTipoGenerico());
			coefRestriccion[posicion] += disp.getConsumo();
		}

		return new LinearConstraint(coefRestriccion, Relationship.LEQ, maximoConsumo);
	}

}
