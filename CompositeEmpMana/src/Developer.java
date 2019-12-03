
public class Developer  implements Employee{
	
	private String name;
	public Developer(String name) {
		super();
		this.name = name;
	}
	@Override
	public void showDetails() {
		System.out.println("emp" + name);
		
	}

}
