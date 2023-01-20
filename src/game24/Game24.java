package game24;

import java.util.ArrayList;
import java.util.Scanner;
import game24.struct.*;
import game24.util.*;

public class Game24{
    static Scanner in;

    /* *** MAIN *** */
    public static void main(String[] args){
        in = new Scanner(System.in);

        System.out.println("====== PERMAINAN KARTU 24 ======");
        System.out.println("Masukkan input 4 kartu (format A B C D)");
        System.out.println("Kartu merupakan salah satu dari: A 2 3 4 5 6 7 8 9 10 J Q K");
        System.out.println("Atau masukkan input R untuk menggunakan input acak");
        
        ArrayList<Solution> solutions = null;
        boolean valid;
        do{
            valid = true;

            System.out.print("\nInput: ");
            String inpRaw = in.nextLine().trim().toUpperCase();

            String[] inps;
            float[] inpVal;
            if(!inpRaw.equals("R")){
                inps = inpRaw.split("\\s+");

                inpVal = Convert.card4ToValue4(inps);
                if(inpVal != null){
                    // Input valid, proses
                    solutions = Solver.solve(inpVal);
                }else{
                    // Input tidak valid
                    valid = false;
                    System.out.println("Masukan tidak valid!");
                }
            }else{
                // Input acak
                inps = Rand.generateCard4();
                System.out.print("Masukan acak: ");
                System.out.println(String.join(" ", inps));

                inpVal = Convert.card4ToValue4(inps);
                solutions = Solver.solve(inpVal);
            }
        }while(!valid);

        // Tampilkan solusi
        displaySolutions(solutions);

        // Simpan solusi yang ditemukan
        promptSaveResults();

        System.out.println(String.format("\nProgram selesai dengan waktu eksekusi %dms", 0));
        System.out.print("Tekan ENTER untuk menutup program...");
        in.nextLine();
        in.close();
    }

    static void displaySolutions(ArrayList<Solution> solutions){
        if(solutions.size() == 0){
            System.out.println("Tidak ada solusi");
        }else{
            System.out.println(String.format("Ditemukan %d solusi", solutions.size()));
            for(Solution sol : solutions){
                System.out.println(sol.toString());
            }
        }
    }

    static void promptSaveResults(){
        boolean valid = false;
        do{
            System.out.print("Simpan solusi? (Y/N) ");
            String inp = in.nextLine().trim().toUpperCase();
            switch(inp){
                case "Y":
                    // Simpan file
                    System.out.println(String.format("Solusi berhasil disimpan di %s", "PATHFILE"));
                case "N":
                    valid = true;
                default:
            }
        }while(!valid);
    }
}
