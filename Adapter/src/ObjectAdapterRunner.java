
public class ObjectAdapterRunner {

	public static void main(String[] args) {
		Television t = new Television();
		SoundPlayer sp =  new Radio();
		
		SoundPlayer televisionAdapter = new TelevisionAdapter(t);
		
		// television acting like a radio
		televisionAdapter.playSound();

	}

}
