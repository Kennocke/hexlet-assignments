package exercise.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.util.List;
import java.util.stream.Collectors;
import static exercise.Data.getCompanies;

public class CompaniesServlet extends HttpServlet {

    @Override
    public void doGet(HttpServletRequest request,
                      HttpServletResponse response)
                throws IOException, ServletException {

        // BEGIN
        PrintWriter printWriter = response.getWriter();
        String searchString = request.getParameter("search");
        List<String> companies = getCompanies();

        if (searchString == null || searchString.isEmpty()) {
            printWriter.print(String.join("\n", companies));
        } else {
            List<String> foundedCompanies = companies.stream()
                    .filter(company -> company.contains(searchString))
                    .toList();
            if (foundedCompanies.isEmpty()) {
                printWriter.print("Companies not found");
            } else {
                printWriter.print(String.join("\n", foundedCompanies));
            }
        }
        // END
    }
}
