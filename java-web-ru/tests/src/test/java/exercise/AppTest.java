package exercise;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

import kong.unirest.HttpResponse;
import kong.unirest.Unirest;
import io.javalin.Javalin;
import io.ebean.DB;

import exercise.domain.User;
import exercise.domain.query.QUser;
import io.ebean.Database;

import java.util.List;
import java.util.Optional;

class AppTest {

    private static Javalin app;
    private static String baseUrl;

    // BEGIN
    @BeforeAll
    public static void beforeAll() {
        app = App.getApp();
        app.start(0);
        int port = app.port();
        baseUrl = "http://localhost:" + port;
    }
    // END

    // Между тестами база данных очищается
    // Благодаря этому тесты не влияют друг на друга
    @BeforeEach
    void beforeEach() {
        Database db = DB.getDefault();
        db.truncate("user");
        User existingUser = new User("Wendell", "Legros", "a@a.com", "123456");
        existingUser.save();
    }

    @Test
    void testUsers() {

        // Выполняем GET запрос на адрес http://localhost:port/users
        HttpResponse<String> response = Unirest
            .get(baseUrl + "/users")
            .asString();
        // Получаем тело ответа
        String content = response.getBody();

        // Проверяем код ответа
        assertThat(response.getStatus()).isEqualTo(200);
        // Проверяем, что страница содержит определенный текст
        assertThat(response.getBody()).contains("Wendell Legros");
    }

    @Test
    void testNewUser() {

        HttpResponse<String> response = Unirest
            .get(baseUrl + "/users/new")
            .asString();

        assertThat(response.getStatus()).isEqualTo(200);
    }

    // BEGIN
    @Test
    void testCreateNewUser() {
        HttpResponse<String> response = Unirest
                .post(baseUrl + "/users")
                .field("firstName", "Stanislav")
                .field("lastName", "Vitkovskiy")
                .field("email", "Stasvitkovskiy700@gmail.com")
                .field("password", "1234567890")
                .asString();

        assertThat(response.getStatus()).isEqualTo(302);

        User user = new QUser()
                .firstName.equalTo("Stanislav")
                .lastName.equalTo("Vitkovskiy")
                .email.equalTo("Stasvitkovskiy700@gmail.com")
                .password.equalTo("1234567890")
                .findOne();

        assertThat(user).isNotNull();
    }

    @Test
    void testIncorrectCreateNewUser() {
        HttpResponse<String> response = Unirest
                .post(baseUrl + "/users")
                .field("firstName", "")
                .field("lastName", "")
                .field("email", "Stasvitkovskiy700")
                .field("password", "12")
                .asString();

        assertThat(response.getStatus()).isEqualTo(422);
        assertThat(response.getBody())
                .contains("Имя не должно быть пустым")
                .contains("Фамилия не должна быть пустой")
                .contains("Должно быть валидным email")
                .contains("Пароль должен содержать не менее 4 символов");
    }

    @AfterAll
    public static void afterAll() {
        app.stop();
    }
    // END
}
