
public class Triangle implements Shape {

	private Color color;
	public Triangle(Color color) {
		super();
		this.color = color;
	}
	@Override
	public void print() {
		
		color.paint();
	}

}
