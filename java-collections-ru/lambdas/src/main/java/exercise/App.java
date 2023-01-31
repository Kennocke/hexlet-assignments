package exercise;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

// BEGIN
class App {
    public static String[][] enlargeArrayImage(String[][] image) {
        List<List<String>> resultImage = new ArrayList<>();

        for (String[] line : image) {
            List<String> newLine = generateLine(line);
            resultImage.add(newLine);
            resultImage.add(newLine);
        }

        return resultImage.stream()
                .map(l -> l.toArray(String[]::new))
                .toArray(String[][]::new);
    }
    public static List<String> generateLine(String[] lineImage) {
        List<String> newLine = new ArrayList<>();
        for (String pixel : lineImage) {
            newLine.add(pixel);
            newLine.add(pixel);
        }
        return newLine;
    }
}
// END
