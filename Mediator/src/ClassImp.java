interface Colleague{}

interface Mediator{
	void register(Colleague c);
	void stateChanged();
}


class ConcreteColleague1 implements Colleague{
	private Mediator med;
	private boolean state;
	
	public ConcreteColleague1(Mediator m) {
		this.med = m;
		med.register(this);
	}
	
	public void changeState() {
		state = state ?false:true;
		med.stateChanged();
	}
	
	public String toString() {
		return new Boolean(state).toString();
	}
}

class ConcreteColleague2 implements Colleague {
	private Mediator med;
	private String val = "false";
	public ConcreteColleague2(Mediator med) {
		super();
		this.med = med;
		med.register(this);
	}
	
	public void setValue(String value) {
		this.val = value;
	}
	
	public String toString() {
		return val;
	}

	
}

class ConcreteMediator implements Mediator{

	Colleague colleague1;
	Colleague colleague2;
	
	
	@Override
	public void register(Colleague c) {
		if(c instanceof ConcreteColleague1) {
			this.colleague1 = c;
		}else if(c instanceof ConcreteColleague2) {
			this.colleague2 = c;
		}
		
	}

	@Override
	public void stateChanged() {
		String s = (colleague2.toString()).contentEquals("false")?"true":"false";
		((ConcreteColleague2)colleague2).setValue(s);
		
	}
	
}

public class ClassImp {

	public static void main(String[] args) {
		Mediator med = new ConcreteMediator();
		
		Colleague c1 = new ConcreteColleague1(med);
		Colleague c2 = new ConcreteColleague2(med);
		
		System.out.println(c1);
		System.out.println(c2);
		
		((ConcreteColleague1)c1).changeState();
		
		System.out.println(c1);
		System.out.println(c2);
		
		

	}

}
