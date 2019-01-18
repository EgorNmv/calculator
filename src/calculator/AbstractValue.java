package calculator;

public abstract class AbstractValue {
	public abstract AbstractValue add(AbstractValue operand)
            throws OperationNotSupportedException, ExceptionVectors;

	public abstract AbstractValue sub(AbstractValue operand)
			throws OperationNotSupportedException, ExceptionVectors;

	public abstract AbstractValue mul(AbstractValue operand)
			throws OperationNotSupportedException, ExceptionVectors;

	public abstract AbstractValue div(AbstractValue operand)
			throws DivisionByZeroException,ExceptionVarNum, OperationNotSupportedException;

	public abstract String toString();
}
