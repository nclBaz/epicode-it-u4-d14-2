package u4d14.dao;

import java.util.UUID;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import lombok.extern.slf4j.Slf4j;
import u4d14.entities.Animal;

@Slf4j
public class AnimalsDAO {
	private final EntityManager em;

	public AnimalsDAO(EntityManager em) {
		this.em = em;
	}

	public void saveAnimal(Animal a) {
		EntityTransaction t = em.getTransaction();
		t.begin();
		em.persist(a);
		t.commit();
		log.info(a.getName() + " salvato!");
	}

	public Animal findById(String id) {
		Animal found = em.find(Animal.class, UUID.fromString(id));
		return found;
	}


}
