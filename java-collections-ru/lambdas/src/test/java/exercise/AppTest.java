package exercise;

import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;

// BEGIN
class AppTest {
    @Test()
    void enlargeArrayImage() {
        String[][] empty = new String[0][];
        String[][] image = new String[][] {
                {"0","0","0","0"},
                {"0","1","1","0"},
                {"0","1","1","0"},
                {"0","0","0","0"}
        };
        String[][] result = new String[][] {
                {"0", "0", "0", "0", "0", "0", "0", "0"},
                {"0", "0", "0", "0", "0", "0", "0", "0"},
                {"0", "0", "1", "1", "1", "1", "0", "0"},
                {"0", "0", "1", "1", "1", "1", "0", "0"},
                {"0", "0", "1", "1", "1", "1", "0", "0"},
                {"0", "0", "1", "1", "1", "1", "0", "0"},
                {"0", "0", "0", "0", "0", "0", "0", "0"},
                {"0", "0", "0", "0", "0", "0", "0", "0"}
        };

        assertThat(App.enlargeArrayImage(image)).isEqualTo(result);
        assertThat(App.enlargeArrayImage(empty)).isEqualTo(empty);
    }
}
// END
