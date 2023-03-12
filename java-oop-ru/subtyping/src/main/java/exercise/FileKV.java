package exercise;

import java.util.Map;

// BEGIN
public class FileKV implements KeyValueStorage {
    private final String pathToFile;

    public FileKV(String pathToFile, Map<String, String> storage) {
        this.pathToFile = pathToFile;
        String storageAsJSON = Utils.serialize(storage);
        Utils.writeFile(pathToFile, storageAsJSON);
    }

    @Override
    public void set(String key, String value) {
        Map<String, String> storage = Utils.unserialize(Utils.readFile(pathToFile));
        storage.put(key, value);
        Utils.writeFile(pathToFile, Utils.serialize(storage));
    }

    @Override
    public void unset(String key) {
        Map<String, String> storage = Utils.unserialize(Utils.readFile(pathToFile));
        storage.remove(key);
        Utils.writeFile(pathToFile, Utils.serialize(storage));
    }

    @Override
    public String get(String key, String defaultValue) {
        Map<String, String> storage = Utils.unserialize(Utils.readFile(pathToFile));
        return storage.getOrDefault(key, defaultValue);
    }

    @Override
    public Map<String, String> toMap() {
        return Utils.unserialize(Utils.readFile(pathToFile));
    }
}
// END
