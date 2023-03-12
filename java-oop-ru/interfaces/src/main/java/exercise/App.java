package exercise;

import java.util.List;
import java.util.stream.Collectors;

// BEGIN
public class App {
    public static List<String> buildApartmentsList(List<Home> buildings, int countBuildings) {
        return buildings.stream()
                .sorted(Home::compareTo)
                .limit(countBuildings)
                .map(Object::toString)
                .collect(Collectors.toList());
    }
}
// END
