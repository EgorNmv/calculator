package calculator;

import calculator.datatypes.integrated.IntegratedValueParser;
import calculator.datatypes.integer.IntegerValueParser;
import calculator.datatypes.ration.RationValueParser;
import calculator.datatypes.real.RealValueParser;
import calculator.datatypes.vector.VectorValueParser;

import javax.swing.*;
import java.awt.event.*;

public class Window extends JDialog {
    private JPanel contentPane;
    private JButton buttonOK;
    private JButton buttonCancel;
    private JRadioButton ЦелыеЧислаRadioButton;
    private JRadioButton КомплексныеЧислаRadioButton;
    private JRadioButton РациональныеЧислаRadioButton;
    private JRadioButton ВещественныеЧислаRadioButton;
    private JRadioButton ВекторыRadioButton;
    private JTextField textField1;
    private JTextField textField2;
    private JTextField textField3;
    private JTextField textField4;
    private JLabel firstNumberTextField;
    private JLabel ОперацияTextField;
    private JLabel secondNumberTextField;
    private JLabel resultTextField;

    private ButtonGroup button=new ButtonGroup();


    public Window() throws ExceptionVectors {
        setContentPane(contentPane);
        setModal(true);
        getRootPane().setDefaultButton(buttonOK);
        button.add(ЦелыеЧислаRadioButton);
        button.add(КомплексныеЧислаRadioButton);
        button.add(РациональныеЧислаRadioButton);
        button.add(ВещественныеЧислаRadioButton);
        button.add(ВекторыRadioButton);
        buttonOK.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {
                    onOK();
                } catch (OperationNotSupportedException e1) {
                    e1.printStackTrace();
                } catch (ExceptionVectors exceptionVectors) {
                    exceptionVectors.printStackTrace();
                }
            }
        });

        buttonCancel.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                onCancel();
            }
        });

        // call onCancel() when cross is clicked
        setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                onCancel();
            }
        });

        // call onCancel() on ESCAPE
        contentPane.registerKeyboardAction(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                onCancel();
            }
        }, KeyStroke.getKeyStroke(KeyEvent.VK_ESCAPE, 0), JComponent.WHEN_ANCESTOR_OF_FOCUSED_COMPONENT);
    }

    private void onOK() throws OperationNotSupportedException, ExceptionVectors {
        AbstractValueParser parser;
        if (ВещественныеЧислаRadioButton.isSelected())parser=new RealValueParser();
        else if (ЦелыеЧислаRadioButton.isSelected())parser=new IntegerValueParser();
        else if (РациональныеЧислаRadioButton.isSelected())parser=new RationValueParser();
        else if (ВекторыRadioButton.isSelected())parser=new VectorValueParser();
        else if (КомплексныеЧислаRadioButton.isSelected()) parser=new IntegratedValueParser();
        else throw new OperationNotSupportedException("Выберите тип");
        Calculator soqer = new Calculator(parser);
        try{
            textField4.setText(soqer.calculate(textField1.getText(),textField2.getText(),textField3.getText()));
        } catch (OperationNotSupportedException e) {
            JOptionPane.showMessageDialog(null,"Операция не поддерживается","Ошибка",JOptionPane.PLAIN_MESSAGE);
        } catch (DivisionByZeroException e) {
            JOptionPane.showMessageDialog(null,"Деление на 0","Ошибка",JOptionPane.PLAIN_MESSAGE);
        } catch (ParseValueException e) {
            JOptionPane.showMessageDialog(null,"Неверный формат строки","Ошибка",JOptionPane.PLAIN_MESSAGE);
        } catch (ExceptionVarNum exceptionVarNum) {
            JOptionPane.showMessageDialog(null,"Деление векторов исключено","Ошибка",JOptionPane.PLAIN_MESSAGE);
        } catch (ExceptionVectors e){
            JOptionPane.showMessageDialog(null,"Разная мерность векторов","Ошибка",JOptionPane.PLAIN_MESSAGE);
        }
    }

    private void onCancel() {
        dispose();
    }


    public static void main(String[] args) throws ExceptionVectors {
        Window dialog = new Window();
        dialog.pack();
        dialog.setVisible(true);
        System.exit(0);
    }
}
