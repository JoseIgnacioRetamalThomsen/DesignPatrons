import java.util.*;

interface Iterator{
	Object next();
	boolean hasNext();
}

interface Aggregate{
	Iterator createIterator();
	Collection elements();
}

class ConcreteIterator implements Iterator{

	private List elements;
	private int index;
	
	public ConcreteIterator(Aggregate a) {
		elements = (List)a.elements();
		index = 0;
	}
	
	@Override
	public Object next() throws RuntimeException {
		try {
			return elements.get(index++);
		}catch(Exception e) {
			throw new RuntimeException("No Such Element");
		}
		
	}

	@Override
	public boolean hasNext() {
		// TODO Auto-generated method stub
		return (index < elements.size()? true:false);
	}
	
}

class ConcreteAggregate implements Aggregate{

	private List elements;
	public ConcreteAggregate(Object[] oa) {
		elements = new ArrayList();
		for(int i =0;i< oa.length;i++) {
			elements.add(oa[i]);
		}
	}
	@Override
	public Iterator createIterator() {
		return new ConcreteIterator(this);
	}

	@Override
	public Collection elements() {
		// TODO Auto-generated method stub
		return Collections.unmodifiableList(elements);
	}
	
}
public class ClassImpl {

	public static void main(String[] args) {
		String[] list =  {"a","b","c","d"};
		
		Aggregate ag = new ConcreteAggregate(list);

		Iterator i = ag.createIterator();
		
		while(i.hasNext()) {
			System.out.println(i.next());
		}
	}
}
