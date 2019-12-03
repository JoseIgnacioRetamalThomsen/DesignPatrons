
public class RunnerCompany {

	public static void main(String[] args) {
		Developer d1 = new Developer("Mark");
		Developer d2 = new Developer("Gary");
		
		Composite cD = new Composite();
		cD.addEmployee(d1);
		cD.addEmployee(d2);
		
		Manager m1 = new Manager("Mauro");
		Manager m2 = new Manager("Paz");
		
		Composite cM = new Composite();
		
		cM.addEmployee(m1);
		cM.addEmployee(m2);
		
		Composite director = new Composite();
		
		director.addEmployee(cD);
		director.addEmployee(cM);
		
		director.showDetails();
	}

}