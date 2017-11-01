
public class OperationsFactory {

	public Operations getOperations(String op) {
		if (op.equals(null))
			return null;
		
		if (op.equalsIgnoreCase("add"))
			return new Plus();
		if (op.equalsIgnoreCase("sub"))
			return new Minus();
		if (op.equalsIgnoreCase("mult"))
			return new Multiply();
		
		return new Divide();
	}
}
