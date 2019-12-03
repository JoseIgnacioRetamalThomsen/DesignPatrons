
interface Strategy {
	public void algorithmInterface();
}

class Context {
	Strategy strategy;

	public Context(Strategy s) {
		this.strategy = s;
	}

	public void contextInterface() {
		strategy.algorithmInterface();
	}
}

class ConcreteStrategy1 implements Strategy {
	public void algorithmInterface() {
		System.out.println("ConcreteStrategy1.algorithmInterface() executed");
	}
}

class ConcreteStrategy2 implements Strategy {
	public void algorithmInterface() {
		System.out.println("ConcreteStrategy2.algorithmInterface() executed");
	}
}

class ConcreteStrategy3 implements Strategy {
	public void algorithmInterface() {
		System.out.println("ConcreteStrategy3.algorithmInterface() executed");
	}
}

public class StrategyInClasRun {
	public static void main(String[] args) {// construct strategies
		Strategy strategy1 = new ConcreteStrategy1();
		Strategy strategy2 = new ConcreteStrategy2();
		Strategy strategy3 = new ConcreteStrategy3();// execute contexts one by one
		new Context(strategy1).contextInterface();
		new Context(strategy2).contextInterface();
		new Context(strategy3).contextInterface();
	}

}
