package dominio.excepciones;

public class FalloTraduccionException extends Exception {

	public FalloTraduccionException(String mensaje) {
		super(mensaje);
	}
	
	public FalloTraduccionException(String mensaje, Throwable excepcion) {
		super(mensaje, excepcion);
	}
}
