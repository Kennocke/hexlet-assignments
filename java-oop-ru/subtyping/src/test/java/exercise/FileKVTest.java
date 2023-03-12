package exercise;

import java.util.HashMap;
import org.junit.jupiter.api.BeforeEach;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;
import java.util.Map;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
// BEGIN
import static org.assertj.core.api.Assertions.assertThat;
// END


class FileKVTest {

    private static Path filepath = Paths.get("src/test/resources/file").toAbsolutePath().normalize();

    @BeforeEach
    public void beforeEach() throws Exception {
        ObjectMapper mapper = new ObjectMapper();
        String content = mapper.writeValueAsString(new HashMap<String, String>());
        Files.writeString(filepath, content, StandardOpenOption.CREATE);
    }

    // BEGIN
    @Test
    public void fileKVTest() {
        String filePathString = filepath.toString();

        Map<String, String> expected0 = Map.of("firstName", "Stanislav");
        FileKV fileKV = new FileKV(filePathString, expected0);
        Map<String, String> result0 = fileKV.toMap();
        assertThat(result0).isEqualTo(expected0);

        Map<String, String> expected1 = Map.of("firstName", "Stanislav", "secondName", "Ivanov");
        fileKV.set("secondName", "Ivanov");
        Map<String, String> result1 = fileKV.toMap();
        assertThat(result1).isEqualTo(expected1);

        Map<String, String> expected2 = Map.of("firstName", "Stanislav");
        fileKV.unset("secondName");
        Map<String, String> result2 = fileKV.toMap();
        assertThat(result2).isEqualTo(expected2);

        String expected3 = "Stanislav";
        String result3 = fileKV.get("firstName", "default");
        assertThat(result3).isEqualTo(expected3);

        String expected4 = "default";
        String result4 = fileKV.get("secondName", "default");
        assertThat(result4).isEqualTo(expected4);
    }
    // END
}
