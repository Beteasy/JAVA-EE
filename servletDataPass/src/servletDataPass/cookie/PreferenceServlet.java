package servletDataPass.cookie;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/*@WebServlet(name = "PreferenceServlet", urlPatterns = { "/preference" })*/
public class PreferenceServlet extends HttpServlet {
    private static final long serialVersionUID = 888L;

    public static final String MENU = 
            "<div style='background:#e8e8e8;"
            + "padding:15px'>"
            + "<a href='cookieClass'>Cookie Class类</a>&nbsp;&nbsp;"
            + "<a href='cookieInfo'>Cookie Info信息</a>&nbsp;&nbsp;"
            + "<a href='preference'>Preference偏好</a>" + "</div>";

    @Override
    public void doGet(HttpServletRequest request,
            HttpServletResponse response) throws ServletException,
            IOException {
    	request.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=utf-8");
        PrintWriter writer = response.getWriter();
        writer.print("<html><head>" + "<title>Preference偏好设置</title>"
                + "<style>table {" + "font-size:small;"
                + "background:NavajoWhite }</style>"
                + "</head><body>"
                + MENU
                + "Please select the values below请做以下设置:"
                + "<form method='post'>"
                + "<table>"
                + "<tr><td>Title Font Size标题字号: </td>"
                + "<td><select name='titleFontSize'>"
                + "<option>large</option>"
                + "<option>x-large</option>"
                + "<option>xx-large</option>"
                + "</select></td>"
                + "</tr>"
                + "<tr><td>Title Style & Weight标题风格和字体: </td>"
                +"<td><select name='titleStyleAndWeight' multiple>"
                + "<option>italic</option>"
                + "<option>bold</option>"
                + "</select></td>"
                + "</tr>"
                + "<tr><td>Max. Records in Table表格中最大记录数: </td>"
                + "<td><select name='maxRecords'>"
                + "<option>5</option>"
                + "<option>10</option>"
                + "</select></td>"
                + "</tr>"
                + "<tr><td>字色: </td>"
                + "<td><select name='color'>"
                + "<option>#F00</option>"
                + "<option>#0F0</option>"
                + "<option>#00F</option>"
                + "</select></td>"
                + "</tr>"
                + "<tr><td rowspan='2'>"
                + "<input type='submit' value='设置Set'/></td>"
                + "</tr>"
                + "</table>" + "</form>" + "</body></html>");

    }

    @Override
    public void doPost(HttpServletRequest request,
            HttpServletResponse response) throws ServletException,
            IOException {
    	request.setCharacterEncoding("utf-8");
    	response.setContentType("text/html;charset=utf-8");
        String maxRecords = request.getParameter("maxRecords");
        String[] titleStyleAndWeight = request.getParameterValues("titleStyleAndWeight");
        String titleFontSize = request.getParameter("titleFontSize");
        String color = request.getParameter("color");
        response.addCookie(new Cookie("maxRecords", maxRecords));
        response.addCookie(new Cookie("titleFontSize",titleFontSize));
        response.addCookie(new Cookie("color", color));

        // delete titleFontWeight and titleFontStyle cookies first
        // Delete cookie by adding a cookie with the maxAge = 0;
        Cookie cookie = new Cookie("titleFontWeight", "");
        cookie.setMaxAge(0);
        response.addCookie(cookie);

        cookie = new Cookie("titleFontStyle", "");
        cookie.setMaxAge(0);
        response.addCookie(cookie);

        if (titleStyleAndWeight != null) {
            for (String style : titleStyleAndWeight) {
                if (style.equals("bold")) {
                    response.addCookie(new 
                            Cookie("titleFontWeight", "bold"));
                } else if (style.equals("italic")) {
                    response.addCookie(new Cookie("titleFontStyle",
                            "italic"));
                }
            }
        }

        
        PrintWriter writer = response.getWriter();
        
        String colorCN = "红";
        if (color.equals("#0F0")) {
			colorCN = "绿";
		} else if (color.equals("#00F")) {
			colorCN = "蓝";
		}
        writer.println("<html><head>" + "<title>Preference偏好设置</title>"
                + "</head><body>" + MENU
                + "Your preference has been set您的偏好已经设置."
                + "<br/><br/>Max. Records in Table表中最大记录: " + maxRecords
                + "<br/>Title Font Size标题字号: " + titleFontSize
                + "<br/>Title Font Color标题字色: " + colorCN
                + "<br/>Title Font Style & Weight标题风格与字体: ");

        // titleStyleAndWeight will be null if none of the options
        // was selected
        if (titleStyleAndWeight != null) {
            writer.println("<ul>");
            for (String style : titleStyleAndWeight) {
                writer.print("<li>" + style + "</li>");
            }
            writer.println("</ul>");
        }
        writer.println("</body></html>");
    }
}