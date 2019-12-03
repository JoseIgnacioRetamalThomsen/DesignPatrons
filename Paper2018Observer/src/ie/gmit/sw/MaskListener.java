package ie.gmit.sw;

public class MaskListener implements Observer{

	@Override
	public void update() {
		mask(5);
		
		
	}

	public void mask(int number) {
		System.out.println("Mask change " + number);
	}
}
