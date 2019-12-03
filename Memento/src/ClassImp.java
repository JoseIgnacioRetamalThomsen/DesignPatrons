
class Memento {
	private boolean mementoState;

	Memento(boolean state) {
		this.mementoState = state;
	}

	boolean getState() {
		return this.mementoState;
	}
}

class Originator {
	private boolean state;

	/** Restore memento state */
	public void setMemento(Memento m) {
		/* use direct package-private access to method */
		this.state = m.getState();
	}

	public Memento createMemento() {
		return new Memento(state);
	}

	/** Arbitrary state machine. Toggles between true/false */
	public void changeState() {
		state = state ? false : true;
	}

	public void printStatus() {
		System.out.println("Originator.printStatus() reports; state is currently [" + state + "]");
	}
}

class Caretaker {
	private static Memento state;

	public static void perform() {// create originator
		Originator orig = new Originator();
		// use originator to
		// create amemento
		
		Memento memento = orig.createMemento();
		
		orig.printStatus();
		// change memento state
		orig.changeState();
		orig.printStatus();
		// undo by restoring memento state
		orig.setMemento(memento);
		orig.printStatus();
	}
}

public class ClassImp {
	public static void main(String[] args) {
		// run the Caretaker
		Caretaker.perform();
		}
	
}
