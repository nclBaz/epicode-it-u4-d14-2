package u4d14.app;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

import lombok.extern.slf4j.Slf4j;
import u4d14.dao.AnimalsDAO;
import u4d14.entities.Cat;
import u4d14.entities.Dog;
import u4d14.util.JpaUtil;

@Slf4j
public class Application {
	private static EntityManagerFactory emf = JpaUtil.getEntityManagerFactory();
//	private static Logger log = LoggerFactory.getLogger(Application.class);

	public static void main(String[] args) {
		EntityManager em = emf.createEntityManager();
		AnimalsDAO ad = new AnimalsDAO(em);

		Cat tom = new Cat("Tom", 5, 7.0);
		Dog fido = new Dog("Fido", 10, 20.0);

//		ad.saveAnimal(fido);
//		ad.saveAnimal(tom);

		ad.findDogByIdAndUpdateName(19, "Bruno");
		ad.findByIdAndDelete(20);

		ad.findAllCats().forEach(c -> System.out.println(c));
		
		ad.findDogByName("Fido").forEach(d -> System.out.println(d));

		em.close();
		emf.close();

	}

}
