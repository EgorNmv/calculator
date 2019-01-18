package calculator.datatypes.vector;

import calculator.AbstractValue;
import calculator.DivisionByZeroException;
import calculator.ExceptionVarNum;
import calculator.ExceptionVectors;
import calculator.datatypes.integer.IntegerValue;

import java.util.ArrayList;

import javax.swing.*;
import java.util.Scanner;

import java.lang.reflect.Array;
import java.util.Scanner;

public class VectorValue extends AbstractValue {
    private final String value;


    public VectorValue(String value) {
        super();
        this.value = value;
    }
    public int VectorAsk(AbstractValue operand) throws ExceptionVectors
    {
        String[] vectors = new String[] {value,((VectorValue) operand).value};
        int count = 0;
        int count2 = 0;
        boolean bol = true;
        for (int i = 0; i < vectors.length; i++) {
            while (bol) {
                vectors[i] = vectors[i].substring(vectors[i].indexOf(",") + 1);
                if (i == 0){
                    count++;
                }
                else {
                    count2++;
                }
                if (vectors[i].indexOf(",") == -1) {
                    bol = false;
                }
            }
        }
        count++; count2++;
        if (count != count2){
            throw new ExceptionVectors();
            }
        else return count;
        }


    public int [] Parsings(AbstractValue operand,int mera)
    {
        String str=value;
        String str2= ((VectorValue) operand).value;
        int [] Arrays=new int[mera*2];
        int x=0;
        int y=0;
        for (int i=0;i<mera - 1;i++)
        {
            Arrays[i]=Integer.parseInt(str.substring(0,str.indexOf(",")));
            str=str.substring(str.indexOf(",")+1);
            x=i;
        }
        Arrays[x + 1] = Integer.parseInt(str);
        x +=2;
        for (int i=0;i<mera - 1;i++)
        {
            Arrays[x+i]=Integer.parseInt(str2.substring(0,(str2.indexOf(","))));
            str2=(str2.substring(str2.indexOf(",")+1));
            y=i;
        }
        Arrays[x+y+1]=Integer.parseInt(str2.substring(0));

        return Arrays;
    }
    /*public int[] Parsing(AbstractValue operand, int mera){
        String str= value;
        int [] Array= new int[mera];
        int x = 0;
        for(int i=0;i<mera - 1;i++)
        {
           Array[i]= Integer.parseInt(str.substring(0,str.indexOf(",")));
           str= str.substring(str.indexOf(",")+1);
           x = i;
        }
        Array[x + 1] = Integer.parseInt(str.substring(0));

        return Array;
    }
    public  int [] Parsing1(AbstractValue operand, int mera){
       String str2= ((VectorValue) operand).value;
        int [] Array2= new int[mera];
        int x = 0;
        for (int i=0;i<mera - 1;i++)
        {
            Array2[i]=Integer.parseInt(str2.substring(0,(str2.indexOf(","))));
            str2= (str2.substring(str2.indexOf(",")+1));
            x = i;
        }
        Array2[x+1] = Integer.parseInt(str2.substring(0));
        return Array2;

    }*/
    public String toString() {
        return(value);
    }

    public AbstractValue add(AbstractValue operand) throws ExceptionVectors {
        int mera = VectorAsk(operand);
        int [] Array= new int[mera * 2];
        Array=Parsings(operand,mera);
        int [] ArrayAdd= new  int[mera];
        String result = "";
        for(int i=0;i<mera;i++)
        {
            ArrayAdd[i]=Array[i]+Array[i + mera];
        }

        for(int i=0;i<mera;i++)
        {

            result= result +","+String.valueOf(ArrayAdd[i]);
        }
        result = result.substring(1);
        return new VectorValue(result);
    }

    public AbstractValue sub(AbstractValue operand) throws ExceptionVectors {
        int mera= VectorAsk(operand);
        int [] Array= new int[mera * 2];
        Array=Parsings(operand,mera);

        int [] ArrayAdd= new  int[mera];
        String result = "";
        for(int i=0;i<mera;i++)
        {
            ArrayAdd[i]=Array[i]-Array[i + mera];
        }

        for(int i=0;i<mera;i++)
        {
            result=result+","+String.valueOf(ArrayAdd[i]);
        }
        result=result.substring(1);
        return new VectorValue(result);
    }

    public AbstractValue mul(AbstractValue operand) throws ExceptionVectors {
        int mera= VectorAsk(operand);
        int [] Array= new int[mera * 2];
        Array=Parsings(operand,mera);
        String result= "";
        int tur=0;
        for(int i=0;i<mera;i++)
        {
            tur=tur+Array[i]*Array[i + mera];
        }
        result=Integer.toString(tur);
        return new VectorValue(result);
    }

    public AbstractValue div(AbstractValue operand)
            throws ExceptionVarNum{
     return null;
    }
}
