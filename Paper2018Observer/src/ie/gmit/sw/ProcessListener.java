package ie.gmit.sw;

import java.util.ArrayList;
import java.util.List;

public class ProcessListener implements Observer{

	@Override
	public void update() {
		
		updatedList(new ArrayList<Number>());
	}

	public void updatedList(List<Number> newList) {
		System.out.println("List Updated");
	}
}
