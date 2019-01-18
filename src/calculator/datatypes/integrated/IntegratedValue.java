package calculator.datatypes.integrated;

import calculator.AbstractValue;
import calculator.DivisionByZeroException;
import calculator.datatypes.integer.IntegerValue;

public class IntegratedValue extends AbstractValue {
    private final String value;

    public IntegratedValue(String value) {
        super();
        this.value = value;
    }

    public int[] Parsing(AbstractValue operand){
        int [] Array= new int[4];
         if (value.lastIndexOf("-")!=0&&value.lastIndexOf("-")!=-1) {
             Array[0] = Integer.parseInt(value.substring(0, value.lastIndexOf("-")));
             Array[1] = Integer.parseInt(value.substring(value.lastIndexOf("-"), value.indexOf("i")));

         }
         else{
             Array[0] = Integer.parseInt(value.substring(0, value.indexOf("+")));
             Array[1] = Integer.parseInt(value.substring(value.indexOf("+"), value.indexOf("i")));

         }
         if(((IntegratedValue) operand).value.lastIndexOf("-")!=0&&((IntegratedValue) operand).value.lastIndexOf("-")!=-1) {
             Array[2] = Integer.parseInt(((IntegratedValue) operand).value.substring(0, ((IntegratedValue) operand).value.lastIndexOf("-")));
             Array[3] = Integer.parseInt(((IntegratedValue) operand).value.substring(((IntegratedValue) operand).value.lastIndexOf("-"), ((IntegratedValue) operand).value.indexOf("i")));
         }

         else {
             Array[2] = Integer.parseInt(((IntegratedValue) operand).value.substring(0, ((IntegratedValue) operand).value.indexOf("+")));
             Array[3] = Integer.parseInt(((IntegratedValue) operand).value.substring(((IntegratedValue) operand).value.indexOf("+"), ((IntegratedValue) operand).value.indexOf("i")));
         }

        return Array;
    }


    public String toString() {
        return(value);
    }

    public AbstractValue add(AbstractValue operand) {
        int [] ArrayAdd= new int [4];
        ArrayAdd=Parsing(operand);
        int firstnum=ArrayAdd[0]+ArrayAdd[2];
        int secondnum=ArrayAdd[1]+ArrayAdd[3];
        if(secondnum<0){
            return new IntegratedValue(Integer.toString(firstnum)+Integer.toString(secondnum)+"i");
        }
        else {
            return new IntegratedValue(Integer.toString(firstnum)+"+"+Integer.toString(secondnum)+"i");
        }

    }

    public AbstractValue sub(AbstractValue operand) {
        int [] ArraySub= new int [4];
        ArraySub=Parsing(operand);
        int firstnum=ArraySub[0]-ArraySub[2];
        int secondnum=ArraySub[1]-ArraySub[3];
        if(secondnum<0){
            return new IntegratedValue(Integer.toString(firstnum)+Integer.toString(secondnum)+"i");
        }
        else {
            return new IntegratedValue(Integer.toString(firstnum)+"+"+Integer.toString(secondnum)+"i");
        }
    }

    public AbstractValue mul(AbstractValue operand) {
        int [] ArrayMul= new int[4];
        ArrayMul=Parsing(operand);
        int firstnum=((ArrayMul[0]*ArrayMul[2])+(ArrayMul[1]*ArrayMul[3])*(-1));
        int secondnum=((ArrayMul[0]*ArrayMul[3])+(ArrayMul[1]*ArrayMul[2]));
        if(secondnum<0)
        {
            return new IntegratedValue(firstnum+secondnum+"i");
        }
        else {
            return new IntegratedValue(firstnum+"+"+secondnum+"i");
        }
    }

    public AbstractValue div(AbstractValue operand)
            throws DivisionByZeroException
    {
        int [] ArrayDiv= new int[4];
        ArrayDiv=Parsing(operand);
        int sopr=ArrayDiv[3]*(-1);
        int chislitel=((ArrayDiv[0]+ArrayDiv[1])*(ArrayDiv[2]+sopr));
        int znamenatyel=((ArrayDiv[2]+ArrayDiv[3])*(ArrayDiv[2])+sopr);
        int chisletelpart=((ArrayDiv[0]*ArrayDiv[2])+((ArrayDiv[1]*sopr)*(-1)));
        int chislitelpartsI=(ArrayDiv[0]*sopr)+(ArrayDiv[1]*ArrayDiv[2]);
        int znamenatyelpart=((ArrayDiv[2]*ArrayDiv[2])+((ArrayDiv[3]*sopr)*(-1)));
        int znamenatyelpartsI=(ArrayDiv[2]*sopr)+(ArrayDiv[3]*ArrayDiv[2]);
        if((ArrayDiv[2]==0 )&&(ArrayDiv[3]==0))
            throw new DivisionByZeroException();
        if(chislitelpartsI<0)
        {
            return new IntegratedValue("("+chisletelpart+chislitelpartsI+"i"+")"+"/"+"("+znamenatyelpart+znamenatyelpartsI+")");
        }
        else {
            return new IntegratedValue("("+chisletelpart+"+"+chislitelpartsI+"i"+")"+"/"+"("+znamenatyelpart+")");
        }
    }
}
