
import java.util.*;

interface Element {
	public void accept(Visitor v);
}

interface Visitor {
	public void visitConcreteElement1(ConcreteElement1 element1);

	public void visitConcreteElement2(ConcreteElement2 element2);
}

class ConcreteElement1 implements Element {
	public void accept(Visitor v) {
		v.visitConcreteElement1(this);
	}

	public void operationA() {
		System.out.println("ConcreteElement1.operationA() executing");
	}
}

class ConcreteElement2 implements Element {
	public void accept(Visitor v) {
		v.visitConcreteElement2(this);
	}

	public void operationB() {
		System.out.println("ConcreteElement2.operationB() executing");
	}
}

class ConcreteVisitor implements Visitor {
	public void visitConcreteElement1(ConcreteElement1 element1) {
		element1.operationA();
	}

	public void visitConcreteElement2(ConcreteElement2 element2) {
		element2.operationB();
	}
}

class ObjectStructure {
	private List objectStruct;
	private Visitor visitor;

	public ObjectStructure(Element[] elements) {
		objectStruct = Arrays.asList(elements);
	}

	public void visitElements() {
		// lazy construction
		if (visitor == null) {
			visitor = new ConcreteVisitor();
		}
		for (Iterator iter = objectStruct.iterator(); iter.hasNext();) {
			((Element) iter.next()).accept(visitor);
		}
	}
}

public class InClassImp {
	public static void main(String[] args) {
		// construct array of Elements
		Element[] elements = new Element[2];
		elements[0] = new ConcreteElement1();
		elements[1] = new ConcreteElement2();
		new ObjectStructure(elements).visitElements();
	}
}
