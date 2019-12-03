package ie.gmit.sw;

public class PixelListener implements Observer {

	@Override
	public void update() {
		changed(5);
		
	}
	public void changed(int pixel) {
		System.out.println("Pixel changed to " + pixel);
	}

}
