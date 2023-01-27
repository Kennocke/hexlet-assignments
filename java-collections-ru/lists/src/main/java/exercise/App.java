package exercise;

import java.util.Arrays;
import java.util.ArrayList;

// BEGIN
class App {
    public static Boolean scrabble(String stringLetters, String word) {
        ArrayList<String> chars = new ArrayList<>(Arrays.asList(stringLetters.toLowerCase().split("")));
        String[] splitWord = word.toLowerCase().split("");
        for(String letter : splitWord) {
            if (!chars.remove(letter)) {
                return false;
            }
        }
        return true;
    }
}
//END
