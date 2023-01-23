package game24.struct;

public enum Operator{
    plus, min, mult, div;

    public static Operator[] all = {plus, min, mult, div};

    public float eval(float a, float b){
        switch(this){
            case plus: return a + b;
            case min: return a - b;
            case mult: return a * b;
            default: return a / b;
        }
    }

    @Override
    public String toString(){
        switch(this){
            case plus: return "+";
            case min: return "-";
            case mult: return "*";
            default: return "/";
        }
    }
}
