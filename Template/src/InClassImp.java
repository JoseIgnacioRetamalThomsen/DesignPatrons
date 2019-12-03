
 abstract class AbstractClass {
	public void templateMethod() {
		/*
		 * call methods in extending classes would probablycontain some other processing
		 */System.out.println("AbstractClass.templateMethod() calling:");
		primitiveOperation1();
		primitiveOperation2();
	}

	public abstract void primitiveOperation1();

	public abstract void primitiveOperation2();
}

class ConcreteClass extends AbstractClass {
	public void primitiveOperation1() {
		System.out.println("ConcreteClass.primitiveOperation1()");
	}

	public void primitiveOperation2() {
		System.out.println("ConcreteClass.primitiveOperation2()");
	}
}




public class InClassImp {
	public static void main(String[] args) {
		AbstractClass ac = new ConcreteClass();
		// construct// call the template method -calls ConcreteClass' specific methods
		ac.templateMethod();
	}
}
