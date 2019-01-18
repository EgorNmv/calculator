package calculator.datatypes.vector;

import calculator.AbstractValue;
import calculator.AbstractValueParser;
import calculator.ParseValueException;
import calculator.datatypes.integer.IntegerValue;

public class VectorValueParser implements AbstractValueParser {
    public AbstractValue parse(String value) throws ParseValueException {
        try {
            return new VectorValue(value);
        } catch (NumberFormatException exception) {
            throw new ParseValueException();
        }
    }
    public String getDatatypeName() {
        return "работа с векторами";
    }
}
