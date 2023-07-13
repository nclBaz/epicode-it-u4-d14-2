package u4d14.dao;

import java.util.List;
import java.util.UUID;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import lombok.extern.slf4j.Slf4j;
import u4d14.entities.Animal;
import u4d14.entities.Cat;
import u4d14.entities.Dog;

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

	public List<Animal> findAll() {
		TypedQuery<Animal> getAllQuery = em.createQuery("SELECT a FROM Animal a", Animal.class);
		// SELECT * FROM animals
		return getAllQuery.getResultList();
	}

	public List<Cat> findAllCats() {
		TypedQuery<Cat> getAllQuery = em.createQuery("SELECT c FROM Cat c", Cat.class);
		// SELECT * FROM animals WHERE tipo_animale='Gatto'
		return getAllQuery.getResultList();
	}

	public List<Dog> findAllDogs() {
		TypedQuery<Dog> getAllQuery = em.createQuery("SELECT d FROM Dog d", Dog.class);
		// SELECT * FROM animals WHERE tipo_animale='Cane'
		return getAllQuery.getResultList();
	}

	public void findDogByIdAndUpdateName(long id, String name) {
		EntityTransaction t = em.getTransaction();
		t.begin();
		Query q = em.createQuery("UPDATE Dog d SET name = :name WHERE id = :id");
		q.setParameter("name", name);
		q.setParameter("id", id);

		int numeroModificati = q.executeUpdate();

		t.commit();
		if (numeroModificati > 0) {
			log.info("Cane modificato");
		} else {
			log.info("Cane con id " + id + " non trovato");
		}
	}

	public void findByIdAndDelete(long id) {
		EntityTransaction t = em.getTransaction();
		t.begin();
		Query q = em.createQuery("DELETE FROM Animal WHERE id = :id");
		q.setParameter("id", id);

		int numeroCancellati = q.executeUpdate();

		t.commit();
		if (numeroCancellati > 0) {
			log.info("Animale cancellato");
		} else {
			log.info("Animale con id " + id + " non trovato");
		}
	}

	public List<Dog> findDogByName(String name) {
		TypedQuery<Dog> getAllQuery = em.createNamedQuery("findByName", Dog.class);
		getAllQuery.setParameter("name", name);
		return getAllQuery.getResultList();
	}

}
