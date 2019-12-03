interface Staff{
	boolean isOwner();
	void setReport(ReportGeneratorProxy rg);
}

interface ReportGeneratorProxy{
	String generateDayReport();
}

class Employee implements Staff{
	private ReportGeneratorProxy p;
	

	

	@Override
	public boolean isOwner() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void setReport(ReportGeneratorProxy p) {
		this.p = p;
		
	}
	 public String generateDayReport() {
		return  p.generateDayReport();
	 }
	
}


class Owner implements Staff{

	private ReportGeneratorProxy p;
	@Override
	public boolean isOwner() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public void setReport(ReportGeneratorProxy p) {
		this.p = p;
	}
	
	 public String generateDayReport() {
			return  p.generateDayReport();
		 }
	
}

class ProProxy implements ReportGeneratorProxy{
	private ReportGeneratorProxy p;
	Staff s;

	
	public ProProxy(Staff s) {
		super();
		this.s = s;
	}


	@Override
	public String generateDayReport() {
		if(s.isOwner()) {
			return "report2";
		}
		return "Not ahutorized";
	}
	
}
public class ProtectionProxyRun {
	public static void main(String[] args) {
		Owner o = new Owner();
		ReportGeneratorProxy p = new ProProxy(o);
		o.setReport(p);
		
		Employee e = new Employee();
		ReportGeneratorProxy p1 = new ProProxy(e);
		
		System.out.println(p.generateDayReport());
		System.out.println(p1.generateDayReport());
		
	}

}
