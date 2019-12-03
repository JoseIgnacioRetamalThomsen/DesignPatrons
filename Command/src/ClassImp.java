interface Command{
	void execute();
}

interface Receiver{
	void action();
}

class ConcreteCommand implements Command{

	private Receiver r;
	
	public ConcreteCommand(Receiver r) {
		super();
		this.r = r;
	}

	@Override
	public void execute() {
		r.action();
		
	}
	
}

class Invoker {
	private Command c;
	
	public void storeCommand(Command c) {
		this.c =c;
	}
	
	public void invoke() {
		c.execute();
	}
}

class ReceiverA implements Receiver{

	@Override
	public void action() {
		System.out.println("A in action");
		
	}
	
}

class ReceiverB implements Receiver{

	@Override
	public void action() {
		System.out.println("B in action");
		
	}
	
}
public class ClassImp {

	public static void main(String[] args) {
	Receiver ra = new ReceiverA();
	Receiver rb = new ReceiverB();
	
	Command c1 = new ConcreteCommand(ra);
	Command c2 = new ConcreteCommand(rb);
	
	Invoker inv1 = new Invoker();
	Invoker inv2 = new Invoker();
	
	inv1.storeCommand(c1);
	inv2.storeCommand(c2);
	
	inv1.invoke();
	inv2.invoke();
	}
}
