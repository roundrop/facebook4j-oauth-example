package facebook4j.examples.signin;

import facebook4j.Facebook;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class LogoutServlet extends HttpServlet {
    private static final long serialVersionUID = 5357658337449255998L;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {      
        Facebook facebook = (Facebook) request.getSession().getAttribute("facebook");
        String accessToken = "";
        try {
        	accessToken = facebook.getOAuthAccessToken().getToken();
        } catch (Exception e) {
            throw new ServletException(e);
        }
        request.getSession().invalidate();

        // Log Out of the Facebook
        StringBuffer next = request.getRequestURL();
        int index = next.lastIndexOf("/");
        next.replace(index+1, next.length(), "");
        response.sendRedirect("http://www.facebook.com/logout.php?next=" + next.toString() + "&access_token=" + accessToken);
    }
}
