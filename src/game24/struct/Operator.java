package game24.struct;

public enum Operator{
    plus, min, mult, div;

    public static Operator[] all = {plus, min, mult, div};

    public float eval(float a, float b){
        return switch(this){
            case plus -> a + b;
            case min -> a - b;
            case mult -> a * b;
            case div -> a / b;
        };
    }

    @Override
    public String toString(){
        return switch(this){
            case plus -> "+";
            case min -> "-";
            case mult -> "*";
            case div -> "/";
        };
    }
}
