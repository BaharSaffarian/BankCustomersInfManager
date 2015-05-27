package presentation;

import model.RealCustomer;
import model.RealCustomerCRUD;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Iterator;


public class RealCustomerSearchServlet extends HttpServlet {
    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setCharacterEncoding("UTF-8");
        response.setContentType("text/html; charset=utf-8");
        PrintWriter out = response.getWriter();
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
                "                    <li><a href=\"RealCustomerRegistration.html\">ثبت مشتری حقیقی</a></li>\n" +
                "                    <li><a href=\"LegalCustomerRegistration.html\">ثبت مشتری حقوقی</a></li>\n" +
                "                    <li class=\"current_page_item\"><a href=\"RealCustomerSearch.html\">جستجوی مشتری حقیقی</a></li>\n" +
                "                    <li><a href=\"LegalCustomerSearch.html\">جستجوی مشتری حقوقی</a></li>\n" +
                "                </ul>\n" +
                "            </div>\n" +
                "        </div>\n" +
                "    </div>\n" +
                "    <div id=\"content\">\n" +
                "        <div class=\"post\">\n" +
                "            <div class=\"entry\">");
        RealCustomer realCustomer=new RealCustomer();
        if(request.getParameter("CustomerId").length()!=0)
            realCustomer.setId(request.getParameter("CustomerId"));
        if(request.getParameter("FirstName").length()!=0)
            realCustomer.setFirstName(request.getParameter("FirstName"));
        if(request.getParameter("LastName").length()!=0)
            realCustomer.setLastName(request.getParameter("LastName"));
        if(request.getParameter("NationalCode").length()!=0)
            realCustomer.setNationalCode(request.getParameter("NationalCode"));
        ArrayList<RealCustomer> realCustomers=RealCustomerCRUD.selectRealCustomer(realCustomer);
        if(realCustomers.isEmpty()){
            out.println("<div class=\"sidebar\">");
            out.println("<p class=\"textCenter\">موردی یافت نشد</p>");
            out.println("</div>");
        }
        else{
            out.println("<div class=\"table\">\n" +
                    "                    <div class=\"htr\">\n" +
                    "                        <div class=\"idtd\"></div>\n" +
                    "\n" +
                    "                        <div class=\"htd\"><p>شناسه</p></div>\n" +
                    "                        <div class=\"htd\"><p>نام</p></div>\n" +
                    "                        <div class=\"htd\"><p>نام خانوادگی</p></div>\n" +
                    "                        <div class=\"htd\"><p>نام پدر</p></div>\n" +
                    "                        <div class=\"htd\"><p>تاریخ تولد</p></div>\n" +
                    "                        <div class=\"htd\"><p>کد ملی</p></div>\n" +
                    "                        <div class=\"htd\"></div>\n" +
                    "                    </div>");
            Iterator<RealCustomer> it=realCustomers.iterator();
            //while ()
            out.println("</div>");
        }
        out.println("</div>\n" +
                "        </div>\n" +
                "    </div>\n" +
                "</div>\n" +
                "</body>\n" +
                "</html>");
    }
}
