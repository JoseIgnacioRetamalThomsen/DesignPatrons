package ie.gmit.sw;

import java.util.ArrayList;

public class ProcessorRunner {

	public static void main(String[] args) {
		
		ConcreteCreator c = ConcreteCreator.getInstance();
		Subject  repro = new RequestProcessor();
		
		Observer rp = c.publicFactoryMethoc(Type.Pixel);
		Observer ml =c.publicFactoryMethoc(Type.Mask);
		Observer rv = c.publicFactoryMethoc(Type.Reverse);
		Observer prl = c.publicFactoryMethoc(Type.Process);
		
		repro.attach(rp);
		repro.attach(ml);
		repro.attach(rv);
		repro.attach(prl);
		
		
		((RequestProcessor) repro).flipPixel(5);
		System.out.println();
		((RequestProcessor) repro).applyMask(5);
		System.out.println();
		((RequestProcessor) repro).reverse("Reversed");
		System.out.println();
		((RequestProcessor) repro).process(new ArrayList<Number>(), 5);

	}

}
