package exercise;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

// BEGIN
public class Validator {
    public static List<String> validate(Object obj) {
        List<String> nullFields = new ArrayList<>();
        Field[] fields = obj.getClass().getDeclaredFields();

        for (Field field : fields) {
            try {
                field.setAccessible(true);
                Object value = field.get(obj);
                if (field.isAnnotationPresent(NotNull.class) && value == null) {
                    nullFields.add(field.getName());
                }
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
        }

        return nullFields;
    }

    public static Map<String, List<String>> advancedValidate(Object obj) {
        Map<String, List<String>> checkResults = new HashMap<>();
        Field[] fields = obj.getClass().getDeclaredFields();

        for (Field field : fields) {
            try {
                List<String> fieldCheckResults = new ArrayList<>();
                field.setAccessible(true);
                String name = field.getName();
                String value = (String) field.get(obj);

                if (field.isAnnotationPresent(NotNull.class) && value == null) {
                    fieldCheckResults.add("can not be null");
                }

                MinLength minLengthAnnotation = field.getAnnotation(MinLength.class);
                if (minLengthAnnotation != null) {
                    int minStringLength = minLengthAnnotation.minLength();

                    if (value == null || minStringLength > value.length()) {
                        fieldCheckResults.add(String.format("length less than %s", minStringLength));
                    }
                }

                if (fieldCheckResults.size() > 0) {
                    checkResults.put(name, fieldCheckResults);
                }
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
        }

        return checkResults;
    }
}
// END
