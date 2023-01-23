package game24.struct;

import game24.util.*;

public class Solution{
    float a, b, c, d;
    Operator op1, op2, op3;
    byte parentheses;
    /*
     * Makna parentheses:
     * 1 -> (a op b) op (c op d)
     * 2 -> ((a op b) op c) op d
     * 3 -> (a op (b op c)) op d
     * 4 -> a op ((b op c) op d)
     * 5 -> a op (b op (c op d))
    */

    /* *** KONSTRUKTOR *** */
    public Solution(float[] vals, Operator[] ops, byte p){
        if(p < 1 || 5 < p)throw new IllegalArgumentException("Konfigurasi kurung invalid");

        a = vals[0];
        b = vals[1];
        c = vals[2];
        d = vals[3];
        op1 = ops[0];
        op2 = ops[1];
        op3 = ops[2];
        parentheses = p;
    }

    public float eval(){
        switch(parentheses){
            case 1: return op2.eval(op1.eval(a, b), op3.eval(c, d));
            case 2: return op3.eval(op2.eval(op1.eval(a, b), c), d);
            case 3: return op3.eval(op1.eval(a, op2.eval(b, c)), d);
            case 4: return op1.eval(a, op3.eval(op2.eval(b, c), d));
            case 5: return op1.eval(a, op2.eval(b, op3.eval(c, d)));
            default: throw new IllegalArgumentException("Konfigurasi kurung invalid");
        }
    }

    @Override
    public String toString(){
        String fmt = null;
        switch(parentheses){
            case 1: fmt = "(%s %s %s) %s (%s %s %s)"; break;
            case 2: fmt = "((%s %s %s) %s %s) %s %s"; break;
            case 3: fmt = "(%s %s (%s %s %s)) %s %s"; break;
            case 4: fmt = "%s %s ((%s %s %s) %s %s)"; break;
            case 5: fmt = "%s %s (%s %s (%s %s %s))"; break;
            default: throw new IllegalArgumentException("Konfigurasi kurung invalid");
        }

        return String.format(fmt,
            Convert.valueToCard((int)a), op1.toString(),
            Convert.valueToCard((int)b), op2.toString(),
            Convert.valueToCard((int)c), op3.toString(),
            Convert.valueToCard((int)d));
    }
}
