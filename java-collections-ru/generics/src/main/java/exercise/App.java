package exercise;

import java.util.List;
import java.util.Map;
import java.util.ArrayList;

// BEGIN
class App {
    public static <T, W> List<Map<T, W>> findWhere(List<Map<T, W>> books, Map<T, W> searchingParams) {
        List<Map<T, W>> foundBooks = new ArrayList<>();
        boolean foundElement;

        for(Map<T, W> book : books) {
            foundElement = true;
            for(Map.Entry<T, W> searchingParam : searchingParams.entrySet()) {
                if (!book.get(searchingParam.getKey()).equals(searchingParam.getValue())) {
                    foundElement = false;
                }
            }
            if (foundElement) {
                foundBooks.add(book);
            }
        }

        return foundBooks;
    }
}
//END
