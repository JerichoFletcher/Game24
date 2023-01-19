package game24.util;

import java.util.Random;

public class Rand{
    static Random rand = new Random();
    static String[] tempCard4 = new String[4];

    public static String[] generateCard4(){
        for(int i = 0; i < 4; i++){
            int val = rand.nextInt(13) + 1;
            tempCard4[i] = Convert.valueToCard(val);
        }
        return tempCard4;
    }
}
