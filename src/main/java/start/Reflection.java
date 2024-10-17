package start;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

/**
 * Utility class for performing reflection operations on objects.
 */
public class Reflection {

    /**
     * Retrieves the names of properties (fields) of an object.
     *
     * @param object The object whose properties are to be retrieved.
     * @return A list of property names.
     */
    public static List<String> retrieveProperties(Object object) {
        List<String> properties = new ArrayList<>();
        for (Field field : object.getClass().getDeclaredFields()) {
            field.setAccessible(true);
            try {
                properties.add(field.getName());

            } catch (IllegalArgumentException e) {
                e.printStackTrace();
            }

        }
        return properties;
    }

    /**
     * Retrieves the details (values) of properties of an object.
     *
     * @param object The object whose details are to be retrieved.
     * @return A list of property details.
     * @throws RuntimeException If unable to access the object's properties.
     */
    public static List<String> getDetails(Object object) {
        List<String> details = new ArrayList<>();
        for (Field field : object.getClass().getDeclaredFields()) {
            field.setAccessible(true);
            Object value;
            try {
                value = field.get(object);
                details.add(String.valueOf(value));
            } catch (IllegalArgumentException e) {
                e.printStackTrace();
            } catch (IllegalAccessException e) {
                throw new RuntimeException(e);
            }

        }
        return details;
    }

    /**
     * Retrieves details of multiple objects as a 2D array.
     *
     * @param objects The list of objects whose details are to be retrieved.
     * @return A 2D array containing details of each object.
     * @throws RuntimeException If unable to access the objects' properties.
     */
    public static String[][] getAllDetails(List<?> objects) {
        String[][] detailsArray;
        List<List<String>> detailsList = new ArrayList<>();
        for (Object object : objects) {
            List<String> objectDetails = getDetails(object);
            detailsList.add(objectDetails);
        }

        detailsArray = new String[detailsList.size()][];

        for (int i = 0; i < detailsList.size(); i++) {
            List<String> innerList = detailsList.get(i);
            detailsArray[i] = new String[innerList.size()];
            for (int j = 0; j < innerList.size(); j++) {
                detailsArray[i][j] = innerList.get(j);
            }
        }

        return detailsArray;
    }

    /**
     * Converts an object to its string representation.
     *
     * @param object The object to be converted.
     * @return The string representation of the object.
     */
    public static String toString(Object object) {
        if (object instanceof String) return (String) object;
        else if (object instanceof Integer) {
            Integer integer = (Integer) object;
            return integer.toString();
        }
        return "";
    }
}
