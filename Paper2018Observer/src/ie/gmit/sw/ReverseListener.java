package ie.gmit.sw;

public class ReverseListener implements Observer{

	@Override
	public void update() {
		updated("Reversed");
		
	}

	public void updated(String string) {
		System.out.println("reversed");
	}
}
