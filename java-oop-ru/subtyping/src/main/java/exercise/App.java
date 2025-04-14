package exercise;

// BEGIN
public class App {

    public static void swapKeyValue(KeyValueStorage storage) {

        var map = storage.toMap();
        var setKeysValues = map.entrySet();

        for (var key : setKeysValues) {
            storage.unset(key.getKey());
            storage.set(key.getValue(), key.getKey());
        }

    }

}
// END
