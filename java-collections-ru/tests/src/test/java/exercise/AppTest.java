package exercise;

import static org.assertj.core.api.Assertions.assertThat;
import java.util.List;
import java.util.Arrays;
import java.util.ArrayList;
import org.junit.jupiter.api.Test;

class AppTest {
    @Test
    void testTake() {
        List<Integer> actual = new ArrayList<>(Arrays.asList(1, 2, 3, 4));
        List<Integer> expected = new ArrayList<>(Arrays.asList(1, 2, 3));
        List<Integer> empty = new ArrayList<>();
        int elementsCount = 3;
        // BEGIN
        assertThat(App.take(actual, elementsCount)).hasSize(3).containsAll(expected);
        assertThat(App.take(actual, 5)).hasSize(4).containsAll(actual);
        assertThat(App.take(empty, 5)).hasSize(0);
        // END
    }
}
