
// object adapter
public class TelevisionAdapter implements SoundPlayer{

	Television television;
	
	
	public TelevisionAdapter(Television television) {
		super();
		this.television = television;
	}


	@Override
	public void playSound() {
		television.playMusic();
		
	}

}
