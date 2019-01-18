package calculator;

@SuppressWarnings("serial")
public class DivisionByZeroException extends Exception {
	public DivisionByZeroException()
	{
		super("деление на ноль");
	}
}
