package game24.util;

public class Convert{
    static String[] allCards = {"A", "2", "3", "4", "5", "6", "7", "8", "9", "10", "J", "Q", "K"};
    static int[] tempValue4 = new int[4];

    /* Validasi/konversi input */
    public static int[] card4ToValue4(String[] cards){
        // Kembalikan null jika panjang array bukan 4
        if(cards.length != 4)return null;
        
        for(int i = 0; i < 4; i++){
            int val = cardToValue(cards[i]);

            // Break, kembalikan null jika tidak valid
            if(val == -1)return null;
            tempValue4[i] = val;
        }

        return tempValue4;
    }

    public static int cardToValue(String card){
        return switch(card){
            case "A" -> 1;
            case "2" -> 2;
            case "3" -> 3;
            case "4" -> 4;
            case "5" -> 5;
            case "6" -> 6;
            case "7" -> 7;
            case "8" -> 8;
            case "9" -> 9;
            case "10" -> 10;
            case "J" -> 11;
            case "Q" -> 12;
            case "K" -> 13;
            default -> -1;
        };
    }

    public static String valueToCard(int val){
        // Kembalikan null jika tidak valid
        if(val < 1 || val > 13)return null;
        return allCards[val - 1];
    }
}
