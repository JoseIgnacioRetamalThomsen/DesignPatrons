
public class Circle implements Shape {

	private Color color;
	public Circle(Color color) {
		super();
		this.color = color;
	}
	@Override
	public void print() {
		
		color.paint();
	}

}
