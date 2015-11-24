package facebook4j.examples.signin;

import facebook4j.Facebook;
import facebook4j.FacebookException;
import facebook4j.auth.AccessToken;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class TokenInfoServlet extends HttpServlet {
    private static final long serialVersionUID = -3472958502660892624L;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Facebook facebook = (Facebook) request.getSession().getAttribute("facebook");
        try {
            AccessToken info = facebook.getOAuthAccessTokenInfo();
            request.setAttribute("token", info);
        } catch (FacebookException e) {
            throw new ServletException(e);
        }

        RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/token.jsp");
        dispatcher.forward(request, response);
    }
}
