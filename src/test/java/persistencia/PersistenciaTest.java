package persistencia;

import static org.junit.Assert.assertNotNull;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.junit.Test;

public class PersistenciaTest {

	@Test
	public void TestDeSesion() {
		EntityManagerFactory emFactory = Persistence.createEntityManagerFactory("SGEdb");
		assertNotNull(emFactory.createEntityManager());
	}
}
