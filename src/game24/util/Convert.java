package game24.util;

public class Convert{
    static String[] allCards = {"A", "2", "3", "4", "5", "6", "7", "8", "9", "10", "J", "Q", "K"};
    static float[] tempValue4 = new float[4];

    /* Validasi/konversi input */
    public static float[] card4ToValue4(String[] cards){
        // Kembalikan null jika panjang array bukan 4
        if(cards.length != 4)return null;
        
        for(int i = 0; i < 4; i++){
            float val = cardToValue(cards[i]);

            // Break, kembalikan null jika tidak valid
            if(val == -1f)return null;
            tempValue4[i] = val;
        }

        return tempValue4;
    }

    public static float cardToValue(String card){
        return switch(card){
            case "A" -> 1f;
            case "2" -> 2f;
            case "3" -> 3f;
            case "4" -> 4f;
            case "5" -> 5f;
            case "6" -> 6f;
            case "7" -> 7f;
            case "8" -> 8f;
            case "9" -> 9f;
            case "10" -> 10f;
            case "J" -> 11f;
            case "Q" -> 12f;
            case "K" -> 13f;
            default -> -1f;
        };
    }

    public static String valueToCard(float val){
        // Kembalikan null jika tidak valid
        if(val < 1f || val > 13f)return null;
        return allCards[(int)val - 1];
    }
}
