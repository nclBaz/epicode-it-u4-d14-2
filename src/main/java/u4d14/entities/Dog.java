package u4d14.entities;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.NamedQuery;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@Entity
@NoArgsConstructor
@DiscriminatorValue("Cane")
@NamedQuery(name = "findByName", query = "SELECT d FROM Dog d WHERE d.name = :name")
public class Dog extends Animal {
	private double maxSpeed;

	public Dog(String name, int age, double maxSpeed) {
		super(name, age);
		this.maxSpeed = maxSpeed;
	}

	@Override
	public String toString() {
		return "Dog [maxSpeed=" + maxSpeed + ", getId()=" + getId() + ", getName()=" + getName() + ", getAge()="
				+ getAge() + "]";
	}

}
