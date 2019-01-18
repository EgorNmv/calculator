package calculator.console;

import java.util.Scanner;

import calculator.AbstractValueParser;
import calculator.Calculator;
import calculator.datatypes.integer.IntegerValueParser;
import calculator.datatypes.integrated.IntegratedValueParser;
import calculator.datatypes.ration.RationValueParser;
import calculator.datatypes.real.RealValueParser;
import calculator.datatypes.vector.VectorValueParser;
import jdk.nashorn.internal.scripts.JO;

import javax.swing.JOptionPane;

public class Program {

	private final Calculator calc;

	private AbstractValueParser[] valueParsers;

	public Program() {

		valueParsers = new AbstractValueParser[] { new IntegerValueParser(),
				new RealValueParser(),new RationValueParser(),new IntegratedValueParser(),new VectorValueParser()};
		AbstractValueParser parser = inputValueParser();
		JOptionPane.showMessageDialog(null,"Работаем с типом" + parser.getDatatypeName() + "'","GraficForm",JOptionPane.PLAIN_MESSAGE);
		calc = new Calculator(parser);
	}

	private AbstractValueParser inputValueParser() {
		showChoises();
		int choise = Integer.parseInt(JOptionPane.showInputDialog("Выберите тип данных  для работы с ними"));
		if (choise >= 1 && choise <= valueParsers.length)
			return valueParsers[choise - 1];
		else {
			JOptionPane.showMessageDialog(null,"Неверный выбор!","GraficForm",JOptionPane.PLAIN_MESSAGE);
			return inputValueParser();
		}
	}

	private void showChoises() {
		JOptionPane.showMessageDialog(null,"Вам нужно выбрать тип данных. Возможные варианты:","GraficForm",JOptionPane.PLAIN_MESSAGE);
		JOptionPane.showMessageDialog(null, ("  " + ("1") + ". " + valueParsers[0].getDatatypeName() +
				"\n" + "  " + ("2") + ". " + valueParsers[1].getDatatypeName() +
				"\n" + "  " + ("3") + ". " + valueParsers[2].getDatatypeName() +
				"\n" + "  " + ("4") + ". " + valueParsers[3].getDatatypeName() +
				"\n" + "  " + ("5") + ". " + valueParsers[4].getDatatypeName()),
				"GraficForm", JOptionPane.PLAIN_MESSAGE);
	}

	public static void main(String args[]) {
		try {
			Program instance = new Program();
			instance.run(args);
		} catch (Exception e) {
			e.printStackTrace(System.out);
		}
	}

	private void run(String[] args) {
		while (true) {
			String arg1 =JOptionPane.showInputDialog("Введите первый аргумент:");
			if (arg1.equals("exit"))
				break;
			String op = JOptionPane.showInputDialog("Введите операнд:");
			String arg2 =JOptionPane.showInputDialog("Введите второый аргумент:");
			try {
				JOptionPane.showMessageDialog(null," = " + calc.calculate(arg1, op, arg2),"GraficForm",JOptionPane.PLAIN_MESSAGE);

			} catch (Exception exception) {
				JOptionPane.showMessageDialog(null,exception.getLocalizedMessage(),"GraficForm",JOptionPane.PLAIN_MESSAGE);
			}
		}
	}

}
