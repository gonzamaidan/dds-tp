package dominio.dispositivo.fisicos;
/**
 * 
 * Esta clase representa a un elemento fisico concreto y la conexion con este dispositivo,
 * ya que como minimo debe poder encenderse y apagarse.
 * Si llegan a existir otros dispositivos con mas funciones se debera extender esta interfaz.
 * Ejemplo:
 * 	Un aire acondicionado puede subir o bajar la temperatura, cuando tengamos esto se extiende
 *  una interfaz que agregue estos metodos y luego cada implementacion depende de como se conecta
 *  con ese aire acondicionado.
 *
 */
public interface DispositivoFisico {

	public void apagar();
	public void encender();
	
}
