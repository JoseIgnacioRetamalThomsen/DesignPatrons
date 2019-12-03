abstract class Pizza {
	String des = "Unknown pizza";

	public String getDescription() {
		return des;
	}

	public abstract int getCost();
}

abstract class ToppingDecorator extends Pizza {
	public abstract String getDescription();
}

class PizzaA extends Pizza {

	public PizzaA() {
		des = "A";
	}

	@Override
	public int getCost() {
		// TODO Auto-generated method stub
		return 10;
	}

}

//concrete decorators
class Tomato extends ToppingDecorator {

	Pizza pizza;

	public Tomato(Pizza pizza) {
		super();
		this.pizza = pizza;
	}

	@Override
	public String getDescription() {
		// TODO Auto-generated method stub
		return pizza.getDescription() + ",  fresh tomato";
	}

	@Override
	public int getCost() {
		// TODO Auto-generated method stub
		return 10 + pizza.getCost();
	}

}

class Chess extends ToppingDecorator {

	Pizza pizza;

	public Chess(Pizza pizza) {
		super();
		this.pizza = pizza;
	}

	@Override
	public String getDescription() {

		return pizza.getDescription() + ", Chess";
	}

	@Override
	public int getCost() {
		// TODO Auto-generated method stub
		return 5 + pizza.getCost();
	}

}

class PizzaB extends Pizza {

	public PizzaB() {
		des = "B";
	}

	@Override
	public int getCost() {
		// TODO Auto-generated method stub
		return 20;
	}

}

public class PizzaDecorator {

	public static void main(String[] args) {
		Pizza pizza = new PizzaA();
		System.out.println("w + " + pizza.getDescription() + " "  +pizza.getCost());
		
		//Decorate pizza with tomato
		pizza = new Tomato(pizza);
		
		// decorate with chess
		pizza = new Chess(pizza);
		
		System.out.println("w + " + pizza.getDescription() + " "  +pizza.getCost());
	}
}
