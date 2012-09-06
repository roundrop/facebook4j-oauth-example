package facebook4j.examples.signin;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import facebook4j.Facebook;
import facebook4j.FacebookException;

public class PostServlet extends HttpServlet {
    private static final long serialVersionUID = 4179545353414298791L;

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        String message = request.getParameter("message");
        Facebook facebook = (Facebook) request.getSession().getAttribute("facebook");
        try {
            facebook.postStatusMessage(message);
        } catch (FacebookException e) {
            throw new ServletException(e);
        }
        response.sendRedirect(request.getContextPath()+ "/");
    }
    
}
