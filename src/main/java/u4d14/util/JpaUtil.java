package u4d14.util;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class JpaUtil {
	private static final EntityManagerFactory emf = Persistence.createEntityManagerFactory("u4d14");
	// occhio a u4d12 che deve essere il nome della persistence-unit settato in
	// persistence.xml

	public static EntityManagerFactory getEntityManagerFactory() {
		return emf;
	}

}
