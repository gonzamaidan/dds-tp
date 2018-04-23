package dominio.usuarios;

import static org.junit.Assert.assertEquals;

import java.time.LocalDate;

import org.junit.Before;
import org.junit.Test;

import dominio.administradores.Administrador;

public class AdministradorTest {
	private static final Long MESES_ANTES = 4L;
	private Administrador admin;
	
	@Before
	public void init() {
		String nombreYApellido = "";
		Integer telefono = 1;
		String domicilio = "";
		LocalDate fechaDeAlta = LocalDate.now().minusMonths(MESES_ANTES);
		String usuario = "";
		Integer idSistema = 1;
		admin = new Administrador(nombreYApellido, telefono, domicilio, fechaDeAlta, usuario, idSistema);
	}
	
	@Test
	public void mesesDeAntiguedadTest() {
		Long mesesComoAdministrador = admin.mesesComoAdministrador();
		assertEquals("El admin tiene " + MESES_ANTES + " de antiguedad", MESES_ANTES, mesesComoAdministrador);
	}
	
}
