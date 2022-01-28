package pl.polsl.lab.vartan.babayan.controllercipher.servlets;

import pl.polsl.lab.vartan.babayan.modelcipher.DBManager;
import pl.polsl.lab.vartan.babayan.modelcipher.History;
import pl.polsl.lab.vartan.babayan.modelcipher.HomophonicCipher;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.Enumeration;

/**
 * servlet that processes http methods
 *
 * @author vartan babayan
 * @version 1.0
 */
public class WebServlet extends HttpServlet {
    /**
     * message to cipher
     */
    private String message;

    /**
     * status to define, encrypt or decrypt the message
     */
    private Character flag;

    /**
     * interaction with model
     */
    private HomophonicCipher model;

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
        model = new HomophonicCipher();
        manager = DBManager.getInstance();
    }

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request  servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException      if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        Enumeration<String> enumeration = request.getParameterNames();
        String name;
        String initmsg = "";
        if (enumeration.hasMoreElements()) {
            name = enumeration.nextElement().toString();
            initmsg = request.getParameter(name);
            message = initmsg;

            if (enumeration.hasMoreElements()) {
                name = enumeration.nextElement().toString();
                flag = request.getParameter(name).charAt(0);
            }
        }

        if (message == null || flag == null) {
            response.sendError(401, "The request misses some parameters");
        }

        if (processData(message, flag)) {
            request.setAttribute("result", message);
            getServletContext().getRequestDispatcher("/index.jsp").forward(request, response);

            History record = new History(initmsg, message, flag);
            try {
                manager.create(record);
            } catch (SQLException sqle) {
                sqle.printStackTrace();
            }
        } else {
            response.sendError(401, "Message contains improper symbols");
        }
    }

    /**
     * processes <code>GET</code>method
     *
     * @param request  - handles request
     * @param response - handles response
     * @throws ServletException - in case of servlet is wrong
     * @throws IOException      - in case of wrong input
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        processRequest(request, response);
    }


    /**
     * processes <code>POST</code> method
     *
     * @param request  - handles request
     * @param response - handles response
     * @throws ServletException - in case of servlet is wrong
     * @throws IOException      - in case of wrong input
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * sending data to Model which return a processed message
     *
     * @param message - to make cipher from the text
     * @param flag    - to know [E]ncrypt or [D]ecrypt
     * @return true if everything is okay, false if message contains errors
     */
    public boolean processData(String message, Character flag) {
        this.flag = flag;
        if (this.flag == 'E') {
            this.message = model.encryptMessage(message);
        } else {
            this.message = model.decryptMessage(message);
        }

        return !this.message.equals(model.getErrMessage());
    }

    /**
     * destroy a connection with db and stop servlet
     */
    @Override
    public void destroy() {
        manager.destroyConnection();
    }
}

