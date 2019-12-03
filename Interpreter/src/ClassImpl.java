import java.util.*;

class Context{
	private Map nontermianlExpressions = new HashMap();
	
	public boolean lookup(String name) {
		return ((Boolean)nontermianlExpressions.get(name)).booleanValue();
	}
	
	public void assign(NonTerminalExpression exp, boolean val) {
		nontermianlExpressions.put(exp.getName(), new Boolean(val));
	}
}

interface AbstractExpression{
	boolean interpret(Context ctx);
}

class NonTerminalExpression implements AbstractExpression{
	private String name;
	
	
	public NonTerminalExpression(String name) {
		super();
		this.name = name;
	}


	@Override
	public boolean interpret(Context ctx) {
		// TODO Auto-generated method stub
		return ctx.lookup(name);
	}
	
	public String getName() {
		return name;
	}
}

class TerminalExpression implements AbstractExpression{

	AbstractExpression operand1;
	AbstractExpression operand2;
	
	
	public TerminalExpression(AbstractExpression operand1, AbstractExpression operand2) {
		super();
		this.operand1 = operand1;
		this.operand2 = operand2;
	}


	@Override
	public boolean interpret(Context ctx) {
		// TODO Auto-generated method stub
		return operand1.interpret(ctx) && operand2.interpret(ctx);
	}
	
}

public class ClassImpl {
	public static void main(String[] args) {
		AbstractExpression x = new NonTerminalExpression("X");
		AbstractExpression y = new NonTerminalExpression("Y");
		AbstractExpression exp = new TerminalExpression(x,y);
		
		Context ctx = new Context();
		
		ctx.assign(((NonTerminalExpression)x), true);
		ctx.assign(((NonTerminalExpression)y), true);
		
		boolean result = exp.interpret(ctx);
		
		System.out.println("value " + result);
		
					
		
		
	}

}
