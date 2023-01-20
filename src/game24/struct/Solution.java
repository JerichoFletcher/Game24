package game24.struct;

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
    public Solution(float val1, float val2, float val3, float val4, Operator op1, Operator op2, Operator op3, byte p){
        if(p < 1 || 5 < p)throw new IllegalArgumentException("Konfigurasi kurung invalid");

        a = val1;
        b = val2;
        c = val3;
        d = val4;
        this.op1 = op1;
        this.op2 = op2;
        this.op3 = op3;
        parentheses = p;
    }

    public float eval(){
        return switch(parentheses){
            case 1 -> op2.eval(op1.eval(a, b), op3.eval(c, d));
            case 2 -> op3.eval(op2.eval(op1.eval(a, b), c), d);
            case 3 -> op3.eval(op1.eval(a, op2.eval(b, c)), d);
            case 4 -> op1.eval(a, op3.eval(op2.eval(b, c), d));
            case 5 -> op1.eval(a, op2.eval(b, op3.eval(c, d)));
            default -> throw new IllegalArgumentException("Konfigurasi kurung invalid");
        };
    }

    @Override
    public String toString(){
        String fmt = switch(parentheses){
            case 1 -> "(%d %s %d) %s (%d %s %d)";
            case 2 -> "((%d %s %d) %s %d) %s %d";
            case 3 -> "(%d %s (%d %s %d)) %s %d";
            case 4 -> "%d %s ((%d %s %d) %s %d)";
            case 5 -> "%d %s (%d %s (%d %s %d))";
            default -> throw new IllegalArgumentException("Konfigurasi kurung invalid");
        };

        return String.format(fmt, a, op1.toString(), b, op2.toString(), c, op3.toString(), d);
    }
}
