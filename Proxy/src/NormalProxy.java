interface Subject{
	public void request();
}


class RealSubject implements Subject{
	public void request() {
		System.out.println("Real subject request");
	}
	
}

class Proxy implements Subject{

	private RealSubject rs = new RealSubject();
	@Override
	public void request() {
	
		rs.request();
	}
	
}

public class NormalProxy {

	public static void main(String[] args) {
		Subject s = new Proxy();
		
		s.request();

	}

}
