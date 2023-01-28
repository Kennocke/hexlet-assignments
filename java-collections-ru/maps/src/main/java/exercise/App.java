package exercise;

import java.util.HashMap;
import java.util.Map;

// BEGIN
class App {
    public static void main(String[] args) {
        String sentence = "";
        Map<String, Integer> dictionary = getWordCount(sentence);
        System.out.println(toString(dictionary));
    }
    public static Map<String, Integer> getWordCount(String sentence) {
        Map<String, Integer> dictionary = new HashMap<>();

        if (sentence.isEmpty()) {
            return dictionary;
        }

        String[] words = sentence.split(" ");

        for (String word : words) {
            if(dictionary.containsKey(word)) {
                dictionary.put(word, dictionary.get(word) + 1);
            } else {
                dictionary.put(word, 1);
            }
        }

        return dictionary;
    }
    public static String toString(Map<String, Integer> dictionary) {
        if (dictionary.size() == 0) {
            return "{}";
        }

        StringBuilder dictionaryAsString = new StringBuilder();
        dictionaryAsString.append("{\n");

        for (Map.Entry<String, Integer> row : dictionary.entrySet()) {
            dictionaryAsString.append("  ");
            dictionaryAsString.append(row.getKey());
            dictionaryAsString.append(": ");
            dictionaryAsString.append(row.getValue());
            dictionaryAsString.append("\n");
        }

        dictionaryAsString.append("}");
        return dictionaryAsString.toString();
    }
}
//END
