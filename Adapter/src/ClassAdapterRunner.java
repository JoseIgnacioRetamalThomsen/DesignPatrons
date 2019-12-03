
public class ClassAdapterRunner {
	public static void main(String[] args) {
		
		SoundPlayer sp =  new TelevisionClassAdapter();
		 
		sp.playSound();

	}
}
