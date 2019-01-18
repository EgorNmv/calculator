package calculator.datatypes.ration;

import calculator.AbstractValue;
import calculator.AbstractValueParser;
import calculator.ParseValueException;

public class RationValueParser implements AbstractValueParser {
    public AbstractValue parse(String value) throws ParseValueException {
        try {
            return new RationValue(value);
        } catch (NumberFormatException exception) {
            throw new ParseValueException();
        }
    }

    public String getDatatypeName() {
        return "рациональные числа";
    }
}

