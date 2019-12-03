class Request {
	public final static int TYPE_ONE = 0;
	public final static int TYPE_TWO = 1;
	private int type;

	public Request(int type) throws Exception {
		super();
		this.type = type;

		if (type == TYPE_ONE || type == TYPE_TWO) {
			this.type = type;
		} else {
			throw new Exception();
		}
	}

	public int getType() {
		return type;
	}
}

interface Handler{
	void handleRequest(Request r);
}

class CH2 implements Handler{

	@Override
	public void handleRequest(Request r) {
		// TODO Auto-generated method stub
		doRequest();
		
	}
	
	private void doRequest() {
		System.out.println("CH2 Rquest executed");
	}
}

class CH1 implements Handler{

	@Override
	public void handleRequest(Request r) {
		switch(r.getType()) {
		case Request.TYPE_ONE:
			doRequest();
			break;
		case Request.TYPE_TWO:
			new CH2().handleRequest(r);
			break;
		}
		
	}
	
	private void doRequest() {
		System.out.println("CH1 Rquest executed");
	}
	
}

public class ClassImp {

	public static void main(String[] args) {
		try {
			Request r1 = new Request(Request.TYPE_ONE);
			Request r2 = new Request(Request.TYPE_TWO);
			
			Handler h = new CH1();
			
			h.handleRequest(r1);
			h.handleRequest(r2);
			
		}catch(Exception e) {
			
		}

	}

}


