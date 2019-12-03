package ie.gmit.sw;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public abstract class Subject {

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
