package game24.util;

import java.util.ArrayList;
import game24.struct.*;

public class Solver{
    static ArrayList<Solution> solutions = new ArrayList<>();

    public static ArrayList<Solution> solve(float[] inps){
        solutions.clear();

        for(float[] vals : Perm.permCard4(inps)){
            for(Operator[] ops : Perm.permOp3()){
                for(byte p = 1; p <= 5; p++){
                    Solution current = new Solution(vals, ops, p);
                    if(current.eval() == 24f)solutions.add(current);
                }
            }
        }

        return solutions;
    }
}
