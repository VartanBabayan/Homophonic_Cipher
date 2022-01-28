package pl.polsl.lab.vartan.babayan.controllercipher.servlets;

import pl.polsl.lab.vartan.babayan.modelcipher.DBManager;
import pl.polsl.lab.vartan.babayan.modelcipher.History;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 * class to contain cookies and history of performed operations
 *
 * @author vartan babayan
 * @version 1.0
 */
public class HistoryServlet extends HttpServlet {
    /**
     * counter of logs
     */
    private int logCounter = 0;

    /**
     * db manager
     */
    private DBManager manager;


    /**
     * init the servlet
     *
     * @throws ServletException - in case of any errors with initialization
     */
    @Override
    public void init() throws ServletException {
        manager = DBManager.getInstance();
    }

    /**
     * processes <code>GET</code>method
     *
     * @param request  - handles request
     * @param response - handles response
     * @throws IOException - in case of wrong input
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("text/html;charset=UTF-8");

        ArrayList<History> resultSet = null;
        try {
            resultSet = manager.read();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        String date = new java.util.Date().toString();
        String cookieDate = date.replace(":", "&");
        cookieDate = cookieDate.replace(" ", "#");
        Cookie cookie = new Cookie("lastVisitTime", cookieDate);
        response.addCookie(cookie);

        PrintWriter out = response.getWriter();
        out.println("<!DOCTYPE html>");
        out.println("<head> <meta charset=\"UTF-8\"></head>");
        out.println("<h1><p align=\"center\">History</p></h1>");

        if (resultSet == null) {
            out.println("<h3><p align=\"center\">The cipher hasn't performed any operations yet</p></h3>");
        } else {
            out.println("<table align=\"center\" cols=3 cellspacing=20>");
            out.println("<tr>" + "<th>Messages</th>" + "<th>EncodedMessages</th>" + "<th>Flags</th>" + "</tr>");

            for (History record : resultSet) {
                out.println("<tr>");

                out.println("<td> " + record.getMsg() + "</td> " +
                        "<td>" + record.getEncodedMsg() + "</td> " +
                        "<td>" + record.getFlag() + "</td>");

                out.println("</tr>");
            }
            out.println("</table>");
        }

        out.println("<h3><p align=\"center\">Last visited time is " + date + "</p></h3>");
        ++logCounter;
        out.println("<h3><p align=\"center\">You entered the page " + logCounter + " times</h3>");
    }
}
