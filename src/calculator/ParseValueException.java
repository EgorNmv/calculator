package calculator;

@SuppressWarnings("serial")
public class ParseValueException extends Exception {
	public ParseValueException() {
		super("неверный формат строки");
	}
	public ParseValueException(String details) {
		super("неверный формат строки. " + details);
	}
}
