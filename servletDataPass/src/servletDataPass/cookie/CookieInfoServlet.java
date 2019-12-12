package servletDataPass.cookie;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/*@WebServlet(name = "CookieInfoServlet", urlPatterns = { "/cookieInfo" })*/
public class CookieInfoServlet extends HttpServlet {
    private static final long serialVersionUID = 3829L;

    @Override
    public void doGet(HttpServletRequest request,
            HttpServletResponse response) throws ServletException,
            IOException {
    	request.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=utf-8");

        Cookie[] cookies = request.getCookies();
        StringBuilder styles = new StringBuilder();
        styles.append(".title {");
        if (cookies != null) {
            for (Cookie cookie : cookies) {
                String name = cookie.getName();
                String value = cookie.getValue();
                if (name.equals("titleFontSize")) {
                    styles.append("font-size:" + value + ";");
                } else if (name.equals("titleFontWeight")) {
                    styles.append("font-weight:" + value + ";");
                } else if (name.equals("titleFontStyle")) {
                    styles.append("font-style:" + value + ";");
                } else if (name.equals("color")) {
                    styles.append("color:" + value + ";");
                }
            }
        }
        //styles.append("color:#F00;");
        styles.append("}");
        //response.setContentType("text/html;charset=utf-8");
        PrintWriter writer = response.getWriter();
        writer.print("<html><head>" + "<title>Cookie Info</title>"
                + "<style>" + styles.toString() + "</style>"
                + "</head><body>" + PreferenceServlet.MENU 
                + "<div class='title'>"
                + "Session Management with Cookies会话中的Cookies管理:</div>");
        writer.print("<div class='title'>");

        // cookies will be null if there's no cookie
        if (cookies == null) {
            writer.print("No cookie in this HTTP response.响应中没有Cookie");
        } else {
            writer.println("<br/>Cookies in this HTTP response响应中的Cookie是:");
            for (Cookie cookie : cookies) {
                writer.println("<br/>" + cookie.getName() + ":"
                        + cookie.getValue());
            }
        }
        writer.print("</div>");
        writer.print("</body></html>");
    }
}