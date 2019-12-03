interface State {
	void handle();
}

class State1 implements State {

	@Override
	public void handle() {
		System.out.println("State 1");

	}

}

class State2 implements State {

	@Override
	public void handle() {
		System.out.println("State 2");

	}

}

class Context {
	public final static int STATE_ONE = 0;
	public final static int STATE_TWO = 1;
	private State currentState = new State1();

	public void request() {
		currentState.handle();
	}

	public void changeState(int state) {
		switch (state) {
		case STATE_ONE:
			currentState = new State1();
			break;
		case STATE_TWO:
			currentState = new State2();
			break;
		}
	}
}



public class ClassImp {

	public static void main(String[] args) {
		Context ctx = new Context();
		ctx.request();
		ctx.changeState(Context.STATE_TWO);
		
		ctx.request();

	}

}
