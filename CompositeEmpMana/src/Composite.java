import java.util.*;

public class Composite implements Employee{
	
	private List<Employee> list = new ArrayList<>();

	@Override
	public void showDetails() {
		for(Employee e: list)
		{
			e.showDetails();
		}
		
	}
	
	public void addEmployee(Employee e) {
		list.add(e);
	}
	
	public void removeEmployee(Employee e) {
		list.remove(e);
	}

}
