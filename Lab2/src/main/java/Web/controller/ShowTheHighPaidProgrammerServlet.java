package Web.controller;

import DataAccess.models.pojo.Programmer;
import Web.util.URL;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.nio.file.Paths;

public class ShowTheHighPaidProgrammerServlet extends ProgrammerServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        setRequestDispatcher(req, resp, URL.BASE_URL);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType(UTF_8_CONTENT_TYPE);
        path = Paths.get("D:/My Documents/University/IdeaProjects/Lab2/Programmers.json");
        Programmer programmer = controller.showHighPaidProgrammer(path);
        req.setAttribute("programmer", programmer);
        setRequestDispatcher(req, resp, URL.SHOW_HIGH_PAID_PROGRAMMERS);
    }
}
