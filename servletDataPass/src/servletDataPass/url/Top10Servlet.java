package servletDataPass.url;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//@WebServlet(name = "Top10Servlet", urlPatterns = { "/top10" })
public class Top10Servlet extends HttpServlet {
    private static final long serialVersionUID = 987654321L;

    private List<String> chengduAttractions;
    private List<String> yichangAttractions;
    private List<String> beijingAttractions;
    
    @Override
    public void init() throws ServletException {
        chengduAttractions = new ArrayList<String>(10);
        chengduAttractions.add("武侯祠");
        chengduAttractions.add("杜甫草堂");
        chengduAttractions.add("人民公园");
        chengduAttractions.add("天府广场");
        chengduAttractions.add("熊猫基地");
        chengduAttractions.add("动物园");
        chengduAttractions.add("洋海公园");
        chengduAttractions.add("望江公园");
        chengduAttractions.add("双流湿地公园");
        chengduAttractions.add("南湖");
        
        yichangAttractions = new ArrayList<String>(10);
        yichangAttractions.add("长江大桥");
        yichangAttractions.add("滨江公园");
        yichangAttractions.add("五一广场");
        yichangAttractions.add("夷陵广场");
        yichangAttractions.add("长江画廊");
        yichangAttractions.add("镇江阁");
        yichangAttractions.add("葛洲坝");
        yichangAttractions.add("清江画廊");
        yichangAttractions.add("东山公园");
        yichangAttractions.add("儿童公园");
        
        beijingAttractions = new ArrayList<String>(10);
        beijingAttractions.add("天安门");
        beijingAttractions.add("毛主席纪念堂");
        beijingAttractions.add("天坛");
        beijingAttractions.add("故宫");
        beijingAttractions.add("永定门");
        beijingAttractions.add("西直门");
        beijingAttractions.add("园明园");
        beijingAttractions.add("八达岭");
        beijingAttractions.add("北京西站");
        beijingAttractions.add("南宛机场");
    }

    @Override
    public void doGet(
    		HttpServletRequest request,
            HttpServletResponse response) throws ServletException,
            IOException {
        
        String city = request.getParameter("city");
        if (city != null && 
                (city.equals("成都") 
                		|| city.equals("宜昌")
                		|| city.equals("北京"))) {
            // show attractions
            showAttractions(request, response, city);
        } else {
            // show main page
            showMainPage(request, response);
        }
    }

    private void showMainPage(
    		HttpServletRequest request,
            HttpServletResponse response) throws ServletException,
            IOException {
        response.setContentType("text/html;charset=utf-8");
        PrintWriter writer = response.getWriter();
        writer.print("<html><head>" +
                "<title>十佳旅游景点</title>" +
                "</head><body>" + 
                "请选择一个城市:" +
                "<br/><a href='?city=成都'>成都</a>" +
                "<br/><a href='?city=宜昌'>宜昌</a>" +
                "<br/><a href='?city=北京'>北京</a>" +
                "<hr/>学生任务："
                + "<br/>请选一个自己感兴趣的城市，列举十个地点，加入到页面中"
                + "</body></html>");
    }

    private void showAttractions(
    		HttpServletRequest request,
            HttpServletResponse response, String city) 
            throws ServletException, IOException {
        
    	response.setContentType("text/html;charset=utf-8");
        int page = 1;
        String pageParameter = request.getParameter("page");
        if (pageParameter != null) {
            try {
                page = Integer.parseInt(pageParameter);
            } catch (NumberFormatException e) {
                // do nothing and retain default value for page
            }
            if (page > 2) {
                page = 1;
            }            
        }
        List<String> attractions = null;
        if (city.equals("成都")) {
            attractions = chengduAttractions;
        } else if (city.equals("宜昌")) {
            attractions = yichangAttractions;
        } else if (city.equals("北京")) {
        	attractions = beijingAttractions;
        }
        response.setContentType("text/html");
        PrintWriter writer = response.getWriter();
        writer.println("<html><head>" +
                "<title>十佳旅游景点</title>" +
                "</head><body>");
        writer.println("<a href='top10'>选择城市</a> ");
        writer.println("<hr/>Page " + page + "<hr/>");
        
        int start = page * 5 - 5;
        for (int i = start; i < start + 5; i++) {
            writer.println(attractions.get(i) + "<br/>");
        }
        writer.print("<hr style='color:blue'/>" +
                "<a href='?city=" + city + 
                "&page=1'>Page 1</a>");
        writer.println("&nbsp; <a href='?city=" + city + 
                "&page=2'>Page 2</a>");
        writer.println("</body></html>");
    }
}