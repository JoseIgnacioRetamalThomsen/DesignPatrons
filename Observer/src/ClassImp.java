import java.util.*;

interface Observer{
	void update();
}



class ConcreteSubject extends Subject{
	
	private static boolean subjectState;
	
	public static boolean getState() {
		return subjectState;
	}
	
	public static void setState(boolean state) {
		subjectState = state;
	}
}

class ConcreteObserver implements Observer{

	private boolean observerState;
	private ConcreteSubject subject;
	
	public void update() {
		if(subject == null) {
			subject = new ConcreteSubject();
		}
		observerState = subject.getState();
		System.out.println("state " +observerState);
	}

	
}
public class ClassImp {

	public static void main(String[] args) {
		Observer o1 = new ConcreteObserver();
		Observer o2 =  new ConcreteObserver();
		
		ConcreteSubject s = new ConcreteSubject();
		
		s.attach(o1);
		s.attach(o2);
		
		//set state and notify change
		s.setState(true);
		s.notifyStateChange();
		
		s.detach(o1);
		
		s.setState(false);
		s.notifyStateChange();
	}
}
