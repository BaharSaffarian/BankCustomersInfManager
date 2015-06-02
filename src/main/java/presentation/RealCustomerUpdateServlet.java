package presentation;

import logic.RealCustomerLogic;
import model.RealCustomer;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;


public class RealCustomerUpdateServlet extends HttpServlet {

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
                "\n" +
                "            <div class=\"entry\">\n" +
                "<div class=\"sidebar\">");
        RealCustomer realCustomer = new RealCustomer(request.getParameter("id"), request.getParameter("firstName"), request.getParameter("lastName"),
                request.getParameter("fatherName"), request.getParameter("birthDate"), request.getParameter("nationalCode"));
        if (RealCustomerLogic.updateCustomer(realCustomer, request.getParameter("oldNationalCode")) != -1) {
            out.println("اطلاعات مشتری با موفقیت تغییر یافت");
        } else {
            out.println("<p class=\"textCenter\">کد ملی تکراری است</p>");
            out.println("<p class=\"textCenter\">لطفا مجددا تلاش کنید</p>");
        }
        out.println("</div>\n" +
                "            </div>\n" +
                "        </div>\n" +
                "    </div>\n" +
                "</div>\n" +
                "</body>\n" +
                "</html>");

    }
}
