package exercise;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

// BEGIN
public class Validator {

    public static List<String> validate(Address address) {

        var nullField = new ArrayList<String>();
        var fields = address.getClass().getDeclaredFields();

        for (var field : fields) {

            if (field.isAnnotationPresent(NotNull.class)) {
                field.setAccessible(true);

                try {
                    if (field.get(address) == null) {
                        nullField.add(field.getName());
                    }
                } catch (IllegalAccessException e) {
                    throw new RuntimeException(e);
                }

            }
        }

        return nullField;

    }

    public static Map<String, List<String>> advancedValidate(Address address) {

        var nullField = new HashMap<String, List<String>>();
        var fields = address.getClass().getDeclaredFields();

        for (var field : fields) {

            if (field.isAnnotationPresent(NotNull.class)) {
                field.setAccessible(true);

                try {
                    if (field.get(address) == null) {
                        var errorDescription = new ArrayList<String>();
                        errorDescription.add("can not be null");
                        nullField.put(field.getName(), errorDescription);
                        continue;
                    }
                } catch (IllegalAccessException e) {
                    throw new RuntimeException(e);
                }

            }

            try {
            if (field.isAnnotationPresent(MinLength.class)) {
                field.setAccessible(true);
                var nameField = field.get(address);
                var annotation = field.getAnnotation(MinLength.class);
                var minLength = annotation.minLength();

                if (nameField.toString().length() < minLength) {
                    var errorDescription = new ArrayList<String>();
                    var description = "length less than " + minLength;
                    errorDescription.add(description);
                    nullField.put(field.getName(), errorDescription);
                }
            }
            } catch (IllegalAccessException e) {
                throw new RuntimeException(e);
            }
            }


        return nullField;
}
}
// END
