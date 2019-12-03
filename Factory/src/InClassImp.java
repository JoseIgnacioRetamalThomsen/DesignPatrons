
interface Product {
	public void operation();
}

class ConcreteProduct implements Product {
	public void operation() {
		System.out.println("Product.operation() executed");
	}
}

abstract class Creator {
	public abstract Product factoryMethod();
}

class ConcreteCreator extends Creator {
	public Product factoryMethod() {
		return new ConcreteProduct();
	}
}

public class InClassImp {
	public static void main(String[] args) {
		// create creator (strange ;) )
		Creator c = new ConcreteCreator();
		Product p = c.factoryMethod();
		// use factory method to create product
		p.operation();// use product

	}
}
