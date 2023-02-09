package exercise;

import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.Arrays;

// BEGIN
class App {
    public static String getForwardedVariables(String configString) {
        String[] lines = configString.split("\\r?\\n");
        String result = Arrays.stream(lines)
                .filter(line -> line.startsWith("environment"))
                .map(line -> Arrays.stream(line.replaceAll("environment=", "")
                        .replaceAll("\"", "")
                        .split(","))
                )
                .map(line -> line
                        .filter(part -> part.startsWith("X_FORWARDED_"))
                        .map(part -> part.replace("X_FORWARDED_", ""))
                        .collect(Collectors.joining(",")))
                .filter(Predicate.not(String::isEmpty))
                .collect(Collectors.joining(","));
        return result;
    }
}
//END
