package calculator.datatypes.ration;

import calculator.AbstractValue;
import calculator.DivisionByZeroException;

import java.lang.reflect.Array;

public class RationValue extends AbstractValue {
    private final String value;

    public RationValue(String value) {
        super();
        this.value = value;
    }
    public int[] Parsing(AbstractValue operand){
        int [] Array= new int[4];
        int z = value.indexOf("/"); // Находим индекс
        String x = value.substring(0,z); // Забираем всё до индекса
        String y = value.substring(z+1); // После индекса
        int n = Integer.parseInt(x);
        int n1 = Integer.parseInt(y);


        int z1 = ((RationValue) operand).value.indexOf("/"); // Находим индекс
        String x1 = ((RationValue) operand).value.substring(0,z1); // Забираем всё до индекса
        String y1 = ((RationValue) operand).value.substring(z1+1); // После индекса
        int n2 = Integer.parseInt(x1);
        int n3 = Integer.parseInt(y1);

        Array[0]=n;
        Array[1]=n1;
        Array[2]=n2;
        Array[3]=n3;

        return Array;
    }

    public static int gcd(int n1, int n3) {//NOD
        if (n3 == 0)
            return Math.abs(n1);
        return gcd(n3, n1 % n3);
    }
    public static int lcm(int n1,int n3){//NOK
        return n1 / gcd(n1,n3) * n3;
    }

    public String toString() {
        return(value);
    }

    public AbstractValue add(AbstractValue operand) {
        int [] ArrayS=new int[] {};
        ArrayS=Parsing(operand);
        if(ArrayS[1]!=ArrayS[3]){
            int del1=lcm(ArrayS[1],ArrayS[3])/ArrayS[1];
            int del2=lcm(ArrayS[1],ArrayS[3]/ArrayS[3]);
            ArrayS[0]*=del1;
            ArrayS[2]*=del2;
            int newdiv=ArrayS[0]+ArrayS[2];
            String.valueOf(newdiv);
            String.valueOf(lcm(ArrayS[1],ArrayS[3]));
            return new RationValue (newdiv+"/"+lcm(ArrayS[1],ArrayS[3]));
        }
        else {
            int num=ArrayS[0] + ArrayS[2];
            String.valueOf(num);
            return new RationValue(num+""+ArrayS[1]);

        }
    }

    public AbstractValue sub(AbstractValue operand) {
        int [] ArrayR=new int[] {};
        ArrayR=Parsing(operand);
        if(ArrayR[1]!=ArrayR[3]) {
            int del1 = lcm(ArrayR[1], ArrayR[3]) / ArrayR[1];
            int del2 = lcm(ArrayR[1], ArrayR[3] / ArrayR[3]);
            ArrayR[0] *= del1;
            ArrayR[2] *= del2;
            int newdiv = ArrayR[0] - ArrayR[2];
            String.valueOf(newdiv);
            String.valueOf(lcm(ArrayR[1], ArrayR[3]));
            return new RationValue(newdiv + "/" + lcm(ArrayR[1], ArrayR[3]));
        }
        else
        {int num=ArrayR[0] - ArrayR[2];
            String.valueOf(num);
            return new RationValue(num+""+ArrayR[1]);
}}

    public AbstractValue mul(AbstractValue operand) {
        int [] Array1= new int[]{};
        Array1=Parsing(operand);
        int num= Array1[0]*Array1[2];
        int den= Array1[1]*Array1[3];
        String.valueOf(num);
        String.valueOf(den);
        String fin=num +"/"+den;
        return new RationValue(fin);//Обращаемся к методу или выводим через метод ратионвалуе
    }

    public AbstractValue div(AbstractValue operand)
            throws DivisionByZeroException {
        int[] Array2 = new int[]{};
        Array2 = Parsing(operand);
        if ((Array2[2] == 0) || (Array2[3] == 0)) {
            throw new DivisionByZeroException();
        }
        int num= Array2[0]*Array2[3];
        int den= Array2[1]*Array2[2];
        String.valueOf(num);
        String.valueOf(den);
        String fin=num +"/"+den;
        return new RationValue(fin);//Обращаемся к методу или выводим через метод ратионвалуе
    }
}
