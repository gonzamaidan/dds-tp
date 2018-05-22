package dominio.dispositivo;

import java.time.LocalDate;
import java.util.Map;
import java.util.TreeMap;

import dominio.dispositivo.DispositivoInteligente.EstadoDispositivo;

public class UsoDeDispositivo {
	//lista con fecha y estado
	Map<LocalDate, EstadoDispositivo> estados = new TreeMap<LocalDate, EstadoDispositivo>();
}
