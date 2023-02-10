package exercise;

import java.util.LinkedHashMap;
import java.util.Map;

// BEGIN
class App {
    public static Map<String, String> genDiff(Map<String, Object> firstDictionary, Map<String, Object> secondDictionary) {
        Map<String, String> diff = new LinkedHashMap<>();

        for (String key : firstDictionary.keySet()) {
            if (secondDictionary.containsKey(key) && firstDictionary.get(key) == secondDictionary.get(key)) {
                diff.put(key, "unchanged");
            } else if (secondDictionary.containsKey(key)) {
                diff.put(key, "changed");
            } else {
                diff.put(key, "deleted");
            }
        }

        for (String key : secondDictionary.keySet()) {
            if (!diff.containsKey(key)) {
                diff.put(key, "added");
            }
        }

        return diff;
    }
}
//END
