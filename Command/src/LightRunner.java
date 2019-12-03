
/*rdy definied
 * interface Command{
	void execute();
}*/

class Light{
	public void on() {
		System.out.println("Light is on");
	}
	
	public void off() {
		System.out.println("Light is off");
	}
}

class LightOnCommand implements Command{

	Light light;
	
	public LightOnCommand(Light light) {
		super();
		this.light = light;
	}

	@Override
	public void execute() {
		light.on();
		
	}
	
}

class LightOffCommand implements Command{

	Light light;
	public LightOffCommand(Light light) {
		super();
		this.light = light;
	}
	@Override
	public void execute() {
		light.off();
		
	}
	
}

class SimpleRemoteControl{
	Command c;
	
	public void setCommand(Command c) {
		this.c =c;
	}
	
	public void pressButton() {
		c.execute();
	}
}

public class LightRunner {
	public static void main(String[] args) {
		SimpleRemoteControl control = new SimpleRemoteControl();
		
		Light l = new Light();
		control.setCommand(new LightOnCommand(l));
		
		control.pressButton();
		
		control.setCommand(new LightOffCommand(l));
		
		control.pressButton();
	}

}
