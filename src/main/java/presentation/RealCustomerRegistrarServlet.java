package presentation;

import logic.LogicHandler;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;


public class RealCustomerRegistrarServlet extends HttpServlet {

    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        //request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");
        response.setContentType("text/html; charset=utf-8");
        PrintWriter out = response.getWriter();
        Connection dbConnection=null;
        String insertQuery;
        int result=-1;
        out.println("<!DOCTYPE html >\n" +
                "<html lang=\"fa-IR\">\n" +
                "<head>\n" +
                "    <meta charset=\"UTF-8\">\n" +
                "    <title>مدیریت اطلاعات مشتریان</title>\n" +
                "    <link href=\"style.css\" rel=\"stylesheet\" type=\"text/css\" media=\"screen\" />\n" +
                "</head>\n" +
                "<body dir=\"rtl\">\n" +
                "<div id=\"wrapper\">\n" +
                "    <div id=\"header-wrapper\">\n" +
                "        <div id=\"header\" class=\"container\" >\n" +
                "            <div id=\"logo\">\n" +
                "                <h1><a href=\"#\">سامانه مدیریت اطلاعات مشتریان</a></h1>\n" +
                "            </div>\n" +
                "            <div id=\"menu\" dir=\"rtl\">\n" +
                "                <ul>\n" +
                "                    <li><a href=\"index.html\">خانه</a></li>\n" +
                "                    <li class=\"current_page_item\"><a href=\"RealCustomerRegistration.html\">ثبت مشتری حقیقی</a></li>\n" +
                "                    <li><a href=\"LegalCustomerRegistration.html\">ثبت مشتری حقوقی</a></li>\n" +
                "                    <li><a href=\"RealCustomerSearch.html\">جستجوی مشتری حقیقی</a></li>\n" +
                "                    <li><a href=\"LegalCustomerSearch.html\">جستجوی مشتری حقوقی</a></li>\n" +
                "                </ul>\n" +
                "            </div>\n" +
                "        </div>\n" +
                "    </div>\n" +
                "    <div id=\"content\">\n" +
                "        <div class=\"post\">\n" +
                "\n" +
                "            <div class=\"entry\">\n"+
                "<div class=\"sidebar\">");
        int customerId=LogicHandler.registerCustomer(request);
        if(customerId!=-1){
            out.println("<p class=\"textCenter\">مشتری با موفقیت ثبت شد</p>");
            out.println("<p class=\"textCenter\">شماره مشتری:"+customerId+"</p>");
        }

        out.println("</div>\n" +
                "            </div>\n" +
                "        </div>\n" +
                "    </div>\n" +
                "</div>\n" +
                "</body>\n" +
                "</html>");
        out.close();
    }


}
