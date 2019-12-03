interface Prototype {
	/** getClone() is used to seperate from Object's clone() method */
	public Prototype getClone();

	public void operation();
}

class ConcretePrototype1 implements Prototype {
	public ConcretePrototype1() {
		System.out.println("constructing ConcretePrototype1");
	}

	public Prototype getClone() {
		return new ConcretePrototype1();
	}

	public void operation() {
		System.out.println("ConcretePrototype1.operation() executing");
	}
}

class ConcretePrototype2 implements Prototype {
	public ConcretePrototype2() {
		System.out.println("constructing ConcretePrototype2");
	}

	public Prototype getClone() {
		// perform 'deep copy' if required
		return new ConcretePrototype1();
	}

	public void operation() {
		System.out.println("ConcretePrototype2.operation() executing");
	}
}

public class InClassImp {
	public static void main(String[] args) {
		// create prototypical objects
		Prototype p1 = new ConcretePrototype1();
		Prototype p2 = new ConcretePrototype2();
		// generate objects from prototypical objects
		Prototype gp1 = p1.getClone();
		Prototype gp2 = p2.getClone();
		// call 'cloned' object's methods
		gp1.operation();
		gp2.operation();
	}
}
