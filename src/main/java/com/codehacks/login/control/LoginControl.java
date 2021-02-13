package com.codehacks.login.control;

import com.codehacks.login.model.Login;
import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Rhume
 */
@WebServlet(name = "LoginControl", urlPatterns = {"/Logincontrol"})
public class LoginControl extends HttpServlet {

    private static final long serialVersionUID = 1L;

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        response.setContentType("text/html;charset=UTF-8");

        String emailAdd = request.getParameter("username");
        String passWord = request.getParameter("pass");
        Login login = new Login();
        login.setEmailAddress(emailAdd);
        login.setPassword(passWord);

        LoginAuthenticator authenticator = new LoginAuthenticator();
        boolean state = authenticator.authenticate(login);

        RequestDispatcher dispatcher;

        if (state) {
            dispatcher = request.getRequestDispatcher("/profile.jsp");
            dispatcher.forward(request, response);
        }

        dispatcher = request.getRequestDispatcher("/login.jsp");
        dispatcher.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }
}
