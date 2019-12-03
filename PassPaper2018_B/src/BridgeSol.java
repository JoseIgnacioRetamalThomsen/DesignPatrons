interface ImageFormat {

	int getPixels(int x, int y, int[][] pixels);
}

class RGB implements ImageFormat {

	@Override
	public int getPixels(int x, int y, int[][] pixels) {

		return pixels[x][y];
	}
}

class HSBI implements ImageFormat {

	@Override
	public int getPixels(int x, int y, int[][] pixels) {

		return pixels[x][y];
	}

}

class GreyScale implements ImageFormat {

	@Override
	public int getPixels(int x, int y, int[][] pixels) {
		return pixels[x][y];
	}

}

abstract class Image {
	int[][] pixels;

	abstract int getPixels(int x, int y);
}

class RGBImage extends Image {

	ImageFormat rgb = new RGB();

	public RGBImage(int[][] pixels) {
		this.pixels = pixels;
	}

	@Override
	int getPixels(int x, int y) {
		// TODO Auto-generated method stub
		return rgb.getPixels(x, y, pixels);
	}
}

class HSBImage extends Image {

	ImageFormat hsb = new HSBI();

	public HSBImage(int[][] pixels) {
		this.pixels = pixels;
	}

	@Override
	int getPixels(int x, int y) {
		// TODO Auto-generated method stub
		return hsb.getPixels(x, y, pixels);
	}

}

class GreyScaleImage extends Image {

	ImageFormat gs = new GreyScale();

	@Override
	int getPixels(int x, int y) {
		// TODO Auto-generated method stub
		return gs.getPixels(x, y, pixels);
	}

}

interface Command {
	int execute(int x, int y);
}

class PixelFlipperCommand implements Command {

	private Image image;

	public PixelFlipperCommand(Image image) {
		super();
		this.image = image;
	}

	@Override
	public int execute(int x, int y) {
		return flip(x, y);

	}

	private int flip(int x, int y) {
		System.out.println("pixels fliped");
		return image.getPixels(y, x);

	}
}

class PixelReverseCommand implements Command {
	private Image image;

	public PixelReverseCommand(Image image) {
		super();
		this.image = image;
	}

	@Override
	public int execute(int x, int y) {
		// TODO Auto-generated method stub
		return pixelReverser(x,y);
	}
	private int pixelReverser(int x,int y) {
		System.out.println("Reverse");
		return image.getPixels(y, x);
	}

}

class ImageControl {
	Command c;

	public void setCommand(Command c) {
		this.c = c;
	}

	public void action(int x, int y) {
		c.execute(x, y);
	}
}

public class BridgeSol {

	public static void main(String[] args) {
		int[][] p = { { 1, 2 }, { 2, 3 } };
		Image hsb = new HSBImage(p);

		ImageControl control = new ImageControl();
		control.setCommand(new PixelFlipperCommand(hsb));
		control.action(1, 0);
		control.setCommand(new PixelReverseCommand(hsb));
		
		control.action(1, 0);
	}
}
