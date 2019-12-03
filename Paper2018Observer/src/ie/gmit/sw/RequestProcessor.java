package ie.gmit.sw;

import java.util.ArrayList;
import java.util.List;

public class RequestProcessor extends Subject {

	
	public void flipPixel(int rgb) {
		notifyStateChange();
	}
	
	public void applyMask(int mask) {
		notifyStateChange();
	}
	
	public void reverse(String str) {
		notifyStateChange();
	}
	
	public List<Number> process(List<Number> list, int interval){
		notifyStateChange();
		return new ArrayList<Number>();
	}
}
