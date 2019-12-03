
public class Manager implements Employee{

	private String name;
	
	public Manager(String name) {
		super();
		this.name = name;
	}

	@Override
	public void showDetails() {
		System.out.println("Man " + name);
		
	}

}
