package facebook4j.examples.signin.device;

import facebook4j.Facebook;
import facebook4j.FacebookException;
import facebook4j.auth.DeviceCode;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class DeviceSigninServlet extends HttpServlet {
    private static final long serialVersionUID = -7453606094644144082L;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Facebook facebook = (Facebook) request.getSession().getAttribute("facebook");
        DeviceCode deviceCode = (DeviceCode) request.getSession().getAttribute("deviceCode");
        try {
            facebook.getOAuthDeviceToken(deviceCode);
        } catch (FacebookException e) {
            throw new ServletException(e);
        }
        request.getSession().setAttribute("facebook", facebook);
        response.sendRedirect(request.getContextPath() + "/");
    }
}
