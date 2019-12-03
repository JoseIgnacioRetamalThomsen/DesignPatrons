package ie.gmit.sw;

public class ConcreteCreator extends Creator {

	private static ConcreteCreator creator = new ConcreteCreator();

	private ConcreteCreator() {
	}

	public static ConcreteCreator getInstance() {
		return creator;

	}

	@Override
	Observer publicFactoryMethoc(Type t) {
		Observer o = null;
		switch (t) {
		case Pixel:
			o = new PixelListener();
			break;
		case Process:
			o = new ProcessListener();
			break;
		case Reverse:
			o = new ReverseListener();
			break;
		case Mask:
			o = new MaskListener();
			break;
		}

		return o;

	}

}
