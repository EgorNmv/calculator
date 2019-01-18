package calculator.datatypes.integrated;

import calculator.AbstractValue;
import calculator.AbstractValueParser;
import calculator.ParseValueException;
import calculator.datatypes.integer.IntegerValue;


public class IntegratedValueParser implements AbstractValueParser {
    public AbstractValue parse(String value) throws ParseValueException {
        try {
            return new IntegratedValue(value);
        } catch (NumberFormatException exception) {
            throw new ParseValueException();
        }
    }
    public String getDatatypeName() {
        return "комплексные числа";
    }
}

