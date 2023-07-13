package u4d14.entities;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@Entity
@NoArgsConstructor
@DiscriminatorValue("Gatto")
public class Cat extends Animal {
	private double maxJumpHeight;

	public Cat(String name, int age, double maxJumpHeight) {
		super(name, age);
		this.maxJumpHeight = maxJumpHeight;
	}

	@Override
	public String toString() {
		return "Cat [maxJumpHeight=" + maxJumpHeight + ", getId()=" + getId() + ", getName()=" + getName()
				+ ", getAge()=" + getAge() + "]";
	}

}
