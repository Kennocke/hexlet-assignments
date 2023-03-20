package exercise;

import java.nio.file.Path;
import java.nio.file.Files;

// BEGIN
public class App {
    public static void save(Path filePath, Car car) throws Exception {
        String json = car.serialize();
        Files.write(filePath, json.getBytes());
    }

    public static Car extract(Path filePath) throws Exception {
        String data = Files.readString(filePath);
        return Car.unserialize(data);
    }
}
// END
