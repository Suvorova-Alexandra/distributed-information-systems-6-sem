package Web.controller;

import DataAccess.models.pojo.Programmer;
import Web.util.URL;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.nio.file.Paths;
import java.util.ArrayList;

public class ShowProgrammerByPositionServlet extends ProgrammerServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        setRequestDispatcher(req, resp, URL.BASE_URL);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {

        resp.setContentType(UTF_8_CONTENT_TYPE);
        resp.setCharacterEncoding("UTF-8");
        path = Paths.get(getServletContext().getRealPath("WEB-INF/classes/Programmers.json"));
        String position = req.getParameter("category");
        ArrayList<Programmer> filteredProgrammers = controller.showProgrammerByPosition(position,path);
        req.setAttribute("filteredProgrammers", filteredProgrammers);
        req.setAttribute("position", position);
        setRequestDispatcher(req, resp, URL.SHOW_PROGRAMMERS_BY_POSITION);

    }
}
