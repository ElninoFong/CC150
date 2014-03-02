// 3.7 An animal shelter holds only dogs and cats, and operates on a strictly "first in, 
// first out" basis. People must adopt either the "oldest" (based on arrival time) of all
// animals at the shelter, or they can select whether they would prefer a dog or a cat 
// (and will receive the oldest animal of that type). They cannot select which specific
// animal they would like. Create the data structures to maintain this system and 
// implement operations such as enqueue, dequeueAny, dequeueDog and dequeueCat. 
// You may use the built-in LinkedList data structure.

public abstract class Animal {
	private int order;
	String name;

	public Animal(Stirng n) {
		name = n;
	}

	public void setOrder(int ord) {
		order = ord;
	}

	public int getOrder() {
		return order;
	}

	public boolean isOlderThan(Animal a) {
		return this.order < a.getOrder();
	}
}

public class Cat extends Animal {
	public Cat(String n) {
		super(n);
	}
}

public class Dog extends Animal {
	public Dog(String n) {
		super(n);
	}
}

public class shelter {
	private int order;
	LinkedList<Cat> cat;
	LinkedList<Dog> dog;

	public shelter() {
		order = 0;
		catList = new LinkedList<Cat>();
		dogList = new LinkedList<Dog>();
	}

	public void enqueue(Animal a) {
		a.setOrder(order++);
		if (a isSubstanceOf Cat) {
			catList.addLast((Cat) a);
		} else if (a isSubstanceOf Dog) {
			dogList.addLast((Dog) a);
		}
	}

	public Animal dequeueAny() {
		if (dogList.size() == 0) return dequeueCat();
		if (catList.size() == 0) return dequeueDog();
		Dog dog = dogList.peekFirst();
		Cat cat = catList.peekFirst();
		if (cat.isOlderThan(dog)) {
			return dequeueCat();
		} else {
			return dequeueDog();
		}
	}

	public Dog dequeueDog() {
		return dogList.poll();
	}

	public Cat dequeueCat() {
		return catList.poll();
	}
}
