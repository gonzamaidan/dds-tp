package dominio.recomendador;

import java.util.ArrayList;
import java.util.Collection;
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

import dominio.dispositivo.fisicos.DispositivoFisico;
import dominio.dispositivo.fisicos.TipoConcreto;

/**
 * Este seria el adapter contra el SimplexSolver de apache. Hay ciertos
 * parametros que no se necesitan pedir. Optimizamos para una lista de
 * dispositivos. Podriamos retornar el valor maximo de horas y en otro metodo
 * retornar las horas para cada dispositivo
 */
public class OptimizadorSimplex {

	private Integer cantDispositivos = 8;
	private Double maximoConsumo = 612.0;

	public PointValuePair optimizar(List<DispositivoFisico> dispositivos) {
		SimplexSolver solver = new SimplexSolver(0.0001);
		OptimizationData linearConstraints = this.getRestricciones(dispositivos);
		OptimizationData objectiveFunction = this.getFuncion(dispositivos);
		OptimizationData criterio = GoalType.MAXIMIZE;
		OptimizationData sinNegativas = new NonNegativeConstraint(Boolean.FALSE);
		OptimizationData maxIteraciones = new MaxIter(1000);
		return solver.optimize(objectiveFunction, linearConstraints, criterio, sinNegativas, maxIteraciones);
	}

	public LinearObjectiveFunction getFuncion(List<DispositivoFisico> dispositivos) {

		double[] coeficientes = new double[cantDispositivos];
		for (DispositivoFisico d : dispositivos) {
			int posicion = MapaDispositivos.mapa.get(d.getNombreGenerico()).ordinal();
			TipoConcreto conc = TipoConcreto.tiposConcretos.get(d.getNombreGenerico());

			coeficientes[posicion] += conc.getConsumo();
		}

		LinearObjectiveFunction function = new LinearObjectiveFunction(coeficientes, 0.0);
		return function;
	}

	public LinearConstraintSet getRestricciones(List<DispositivoFisico> dispositivos) {

		Collection<LinearConstraint> restricciones = new ArrayList<LinearConstraint>();
		for (DispositivoFisico d : dispositivos) {
			
			double[] coefRestriccion = new double[cantDispositivos];
			MapaDispositivos reg = MapaDispositivos.mapa.get(d.getNombreGenerico());
			coefRestriccion[reg.ordinal()] = 1;

			restricciones.add(new LinearConstraint(coefRestriccion, Relationship.GEQ, reg.getMin()));
			restricciones.add(new LinearConstraint(coefRestriccion, Relationship.LEQ, reg.getMax()));
		}
		
		restricciones.add(this.obtenerRestriccionBasica(dispositivos));

		return new LinearConstraintSet(restricciones);
	}

	private LinearConstraint obtenerRestriccionBasica(List<DispositivoFisico> dispositivos) {
		
		double[] coefRestriccion = new double[cantDispositivos];
		for (DispositivoFisico disp : dispositivos) {

			int posicion = MapaDispositivos.mapa.get(disp.getNombreGenerico()).ordinal();
			coefRestriccion[posicion] += disp.getConsumo();
		}
		
		return new LinearConstraint(coefRestriccion, Relationship.LEQ, maximoConsumo);
	}
}
