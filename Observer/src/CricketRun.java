import java.util.*;

abstract class Subject{
	List observers = new ArrayList();
	
	//attach and observer
	public void attach(Observer o) {
		observers.add(o);
	}
	
	//detach a particular observer
	public void detach(Observer o) {
		observers.remove(o);
	}
	
	// notify all
	public void notifyStateChange() {
		for(Iterator it = observers.iterator();it.hasNext();) {
			((Observer)it.next()).update();
		}
	}
}

class CricketData extends Subject {
	int runs;
	ArrayList<Observer> oList;

	private int getLastRun() {
		return 2;
		
	}

	public void dataChange() {
		runs = getLastRun();
		notifyStateChange();
	}
}

class AverageScoreDisplay implements Observer {

	private float runRate;

	@Override
	public void update() {
		this.runRate = 1;
		display();

	}

	public void display() {
		System.out.println("Average = " + runRate);
	}

}

class CurrentScoreDisplay implements Observer {

	private int runs;

	@Override
	public void update() {
		runs = 0;
		display();
	}

	public void display() {
		System.out.println("current = " + runs);
	}

}



public class CricketRun {
	public static void main(String[] args) {
		Observer averageScoreDisplay = new AverageScoreDisplay();
		Observer currentScoreDisplay = new CurrentScoreDisplay();
		
		 // pass the displays to Cricket data 
        CricketData c = new CricketData(); 
        
        // register display elements 
       c.attach(averageScoreDisplay); 
        c.attach(currentScoreDisplay); 
        c.dataChange();
        
        c.detach(averageScoreDisplay);
        
        c.dataChange();
	}
}
