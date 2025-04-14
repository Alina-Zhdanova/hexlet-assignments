package exercise;

import java.util.HashMap;
import java.util.Map;

// BEGIN
public final class FileKV implements KeyValueStorage {

    private final String filePath;
    private final Map<String, String> storage;

    FileKV(String filePath, Map<String, String> storage) {
        this.filePath = filePath;
        this.storage = new HashMap<>(storage);
        Utils.writeFile(filePath, Utils.serialize(storage));
    }

    @Override
    public void set(String key, String value) {
        storage.put(key, value);
        Utils.writeFile(filePath, Utils.serialize(storage));
    }

    @Override
    public void unset(String key) {
        storage.remove(key);
        Utils.writeFile(filePath, Utils.serialize(storage));
    }

    @Override
    public String get(String key, String defaultValue) {
        return Utils.deserialize(Utils.readFile(filePath)).getOrDefault(key, defaultValue);
    }

    @Override
    public Map<String, String> toMap() {
        return Utils.deserialize(Utils.readFile(filePath));
    }
}
// END
