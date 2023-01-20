package game24.util;

import java.util.ArrayList;

import game24.struct.Operator;

public class Perm{
    static ArrayList<float[]> cards = new ArrayList<>(24);
    static Operator[][] ops;

    static float[][] temp = new float[24][];

    public static ArrayList<float[]> permCard4(float[] vals){
        cards.clear();
        for(int i = 1; i <= 4; i++){
            for(int j = 1; j <= 4; j++){
                if(i == j)continue;
                for(int k = 1; k <= 4; k++){
                    if(i == k || j == k)continue;

                    float temp4[] = new float[]{vals[i-1], vals[j-1], vals[k-1], vals[24/(i*j*k)-1]};
                    
                    boolean unique = true;
                    for(float[] curr : cards){
                        if(curr[0] == temp4[0] && curr[1] == temp4[1] && curr[2] == temp4[2] && curr[3] == temp4[3]){
                            unique = false;
                            break;
                        }
                    }

                    if(unique)cards.add(temp4);
                }
            }
        }
        return cards;
    }

    public static Operator[][] permOp3(){
        if(ops == null){
            ops = new Operator[64][];

            int i = 0;
            for(Operator op1 : Operator.all)
                for(Operator op2 : Operator.all)
                    for(Operator op3 : Operator.all)
                        ops[i++] = new Operator[]{op1, op2, op3};
        }
        return ops;
    }
}
