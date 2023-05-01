package exercise.servlet;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.util.List;
import java.util.Map;

import java.nio.file.Paths;
import java.nio.file.Path;
import java.nio.file.Files;
import java.util.Optional;
import java.util.stream.Collectors;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.core.JsonProcessingException;
import org.apache.commons.lang3.ArrayUtils;

public class UsersServlet extends HttpServlet {

//    public static void main(String[] args) {
//        try {
//            List<Map> users = getUsers();
//            System.out.println(users.get(0).get("id") == "8");
//            Optional<Map> foundUser = users.stream()
//                    .filter(person -> ((Map) person).get("id").equals("8"))
//                    .findFirst();
//            System.out.println(foundUser);
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//    }
    @Override
    public void doGet(HttpServletRequest request,
                      HttpServletResponse response)
                throws IOException, ServletException {

        String pathInfo = request.getPathInfo();

        if (pathInfo == null) {
            showUsers(request, response);
            return;
        }

        String[] pathParts = pathInfo.split("/");
        String id = ArrayUtils.get(pathParts, 1, "");

        showUser(request, response, id);
    }

    private static List getUsers() throws JsonProcessingException, IOException {
        // BEGIN
        Path filePath = Paths.get("src/main/resources/users.json");
        ObjectMapper mapper = new ObjectMapper();
        return mapper.readValue(new File(filePath.normalize().toString()), new TypeReference<List<Map>>() {});
        // END
    }

    private void showUsers(HttpServletRequest request,
                          HttpServletResponse response)
                throws IOException {

        // BEGIN
        List<Map> users = getUsers();
        PrintWriter printWriter = response.getWriter();
        printWriter.print("<table>");
        users.stream().forEach(user -> {
            printWriter.print("<tr>");
            printWriter.print("<td>" + user.get("id") + "</td>");
            printWriter.print("<td><a href='/users/" + user.get("id") + "'>"
                    + user.get("firstName") + " " + user.get("lastName")
                    + "</a></td>");
            printWriter.print("</tr>");
        });
        printWriter.print("</table>");
        // END
    }

    private void showUser(HttpServletRequest request,
                         HttpServletResponse response,
                         String id)
                 throws IOException {

        // BEGIN
        PrintWriter printWriter = response.getWriter();
        Optional<Map> foundUser = getUsers().stream()
                        .filter(person -> ((Map) person).get("id").equals(id))
                        .findFirst();

        if (foundUser.isEmpty()) {
            response.sendError(404, "Not found");
            return;
        }

        Map user = foundUser.get();

        printWriter.print("<table style='border: 1px solid black;'>");
        printWriter.println("<tr>");
        printWriter.print("<td>id</td>");
        printWriter.print("<td>" + user.get("id") + "</td>");
        printWriter.print("</tr>");

        printWriter.println("<tr>");
        printWriter.print("<td>Full name</td>");
        printWriter.print("<td>" + user.get("firstName") + " " + user.get("lastName") + "</td>");
        printWriter.print("</tr>");

        printWriter.println("<tr>");
        printWriter.print("<td>Email</td>");
        printWriter.print("<td>" + user.get("email") + "</td>");
        printWriter.print("</tr>");

        printWriter.print("</table>");
        // END
    }
}
