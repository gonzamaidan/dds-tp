package dominio.clientes;
/**
 * Representa el documento de un usuario cliente
 *
 */
public class Documento {
	private TipoDocumento tipoDocumento;
	private Integer numeroDocumento;

<<<<<<< HEAD
	public Documento(TipoDocumento tipo, Integer numeroDocumento) {
		this.tipoDocumento = tipo;
=======
	public Documento(TipoDocumento tipoDocumento, Integer numeroDocumento) {
		super();
		this.tipoDocumento = tipoDocumento;
>>>>>>> master
		this.numeroDocumento = numeroDocumento;
	}

	public TipoDocumento getTipoDocumento() {
		return tipoDocumento;
	}

	public void setTipoDocumento(TipoDocumento tipoDocumento) {
		this.tipoDocumento = tipoDocumento;
	}

	public Integer getNumeroDocumento() {
		return numeroDocumento;
	}

	public void setNumeroDocumento(Integer numeroDocumento) {
		this.numeroDocumento = numeroDocumento;
	}
}