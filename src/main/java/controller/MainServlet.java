package controller;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * @author Oleksandr Haleta
 * 2021
 */

@WebServlet("/hello")
public class MainServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        Integer visitCounter = (Integer) session.getAttribute("visitCounter");
        if (visitCounter == null) {
            visitCounter = 1;
        } else {
            visitCounter++;
        }

        session.setAttribute("visitCounter", visitCounter);
        String username = req.getParameter("username"); //аналогично http://localhost:8080/hello?username=Pavel
        resp.setContentType("text/html");
        PrintWriter writer = resp.getWriter();
        if (username == null) {
            writer.write("Hello, Anonymous" + "<br>");
        } else {
            writer.write("Hello, " + username + "<br>");
        }
        writer.write("Page was visited " + visitCounter + " times.");
        writer.close();
    }
}
