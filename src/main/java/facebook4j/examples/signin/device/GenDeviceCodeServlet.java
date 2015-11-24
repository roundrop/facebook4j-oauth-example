package facebook4j.examples.signin.device;

import facebook4j.Facebook;
import facebook4j.FacebookException;
import facebook4j.FacebookFactory;
import facebook4j.auth.DeviceCode;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class GenDeviceCodeServlet extends HttpServlet {
    private static final long serialVersionUID = 4334127926392489578L;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Facebook facebook = new FacebookFactory().getInstance();
        request.getSession().setAttribute("facebook", facebook);
        try {
            DeviceCode deviceCode = facebook.getOAuthDeviceCode();
            request.getSession().setAttribute("deviceCode", deviceCode);
        } catch (FacebookException e) {
            throw new ServletException(e);
        }

        RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/device.jsp");
        dispatcher.forward(request, response);
    }
}
