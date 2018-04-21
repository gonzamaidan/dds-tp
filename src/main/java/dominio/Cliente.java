package dominio;


import java.sql.Date;
import java.util.ArrayList;

public class Cliente {
	
	String nombreYApellido;
	String tipoDocumento; //Implementar con enum
	Integer numeroDocumento;
	Integer telefono;
	String domicilioServicio;
	Date fechaDeAlta;
	Categoria categoria; //Despues vemos si hacemos clases, por ahora lo pongo como String
	String usuario;
	String contrasenia;
	ArrayList<Dispositivo> dispositivos = new ArrayList<>();
	
	public void agregarDispositivo(Dispositivo dispositivo) {
		dispositivos.add(dispositivo);
	}
	
	
	public boolean tieneAlgunDispositivoEncendido() {
		return dispositivos.stream().anyMatch(disp -> disp.estaEncendido());
	}
	
	public long cantidadDeDispositivosEncendidos() {
		return dispositivos.stream().filter(disp -> disp.estaEncendido()).count();
	}
	
	public long cantidadDeDispositivosApagados() {
		return dispositivos.stream().filter(disp -> disp.estaApagado()).count();
	}
	
	public int cantidadTotalDeDispositivos() {
		return dispositivos.size();
	}
	
	public Categoria getCategoria() {
		return categoria;
	}
	public double  calcularFactura(double consumo) {
		return (this.getCategoria().calcularMontoMensual(consumo));
	}


	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}


	
}
