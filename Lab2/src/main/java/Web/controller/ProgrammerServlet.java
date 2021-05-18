package Web.controller;

import BusinessLogic.models.ProgrammerController;
import DIResolver.DIContainer;
import DataAccess.models.pojo.Programmer;

import javax.ejb.EJB;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.nio.file.Path;

public class ProgrammerServlet extends HttpServlet {
    protected Programmer programmer;
    @EJB
    protected ProgrammerController controller;
    protected Path path;
    protected final static String UTF_8_CONTENT_TYPE = "text/html;charset=UTF-8";

    void setRequestDispatcher(HttpServletRequest req, HttpServletResponse resp, String path) throws ServletException, IOException {
        RequestDispatcher requestDispatcher = req.getRequestDispatcher(path);
        requestDispatcher.forward(req, resp);
    }
}
