package dominio.excepciones;

import org.quartz.SchedulerException;

public class PlanificadorQuartzException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public PlanificadorQuartzException(SchedulerException e) {
		super(e);
	}

}
