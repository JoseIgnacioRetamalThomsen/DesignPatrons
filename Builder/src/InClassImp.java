interface Product {
	public void operation();
}

class ConcreteProduct implements Product {
	public ConcreteProduct() {
		System.out.println("constructing ConcreteProduct object");
	}

	public void operation() {
		System.out.println("ConcreteProduct.operation() executed");
	}
}

interface Builder {
	public void buildPart();

	public Product getPart();
}

class ConcreteBuilder implements Builder {
	Product p;

	public void buildPart() {
		p = new ConcreteProduct();// some more complex work with product
	}

	public Product getPart() {
		return p;
	}
}

class Director {
	Builder build;

	public Director(Builder builder) {
		this.build = builder;
	}

	public void construct() {
		build.buildPart();
	}
}

public class InClassImp {
	public static void main(String[] args) {
		// create builder
		Builder b = new ConcreteBuilder();
		// create director
		Director d = new Director(b);
		// construct, obtain and use
		d.construct();
		Product p = b.getPart();
		p.operation();
	}

}
