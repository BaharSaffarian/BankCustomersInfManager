package presentation;

import logic.RealCustomerLogic;
import model.RealCustomer;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;


public class RealCustomerRegistrarServlet extends HttpServlet {

    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        //request.setCharacterEncoding("UTF-8");
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
                "            <div class=\"entry\">\n" +
                "<div class=\"sidebar\">");
        RealCustomer realCustomer = new RealCustomer(request.getParameter("FirstName"), request.getParameter("LastName"),
                request.getParameter("FatherName"), request.getParameter("DateOfBirth"),
                request.getParameter("NationalCode"));
        int customerId = RealCustomerLogic.registerCustomer(realCustomer);
        if (customerId != -1) {
            out.println("<p class=\"textCenter\">مشتری با موفقیت ثبت شد</p>");
            out.println("<p class=\"textCenter\">شماره مشتری:" + customerId + "</p>");
        } else {
            out.println("<p class=\"textCenter\">کد ملی تکراری است</p>");
            out.println("<p class=\"textCenter\">لطفا مجددا تلاش کنید</p>");
            out.println("<h2>ثبت مشتری حقیقی</h2>\n" +
                    "                    <form method=\"get\" action=\"http://localhost:8080/RealCustomerRegistrarServlet\">\n" +
                    "                    <div class=\"inputRow\" >\n" +
                    "                        <div class=\"label\" >نام:</div>\n" +
                    "                        <div class=\"input\"><input class=\"input\" type=\"text\" name=\"FirstName\" size=\"20\"></div>\n" +
                    "                    </div>\n" +
                    "                    <div class=\"inputRow\" >\n" +
                    "                        <div class=\"label\" >نام خانوادگی:</div>\n" +
                    "                        <div class=\"input\"><input class=\"input\" type=\"text\" name=\"LastName\" size=\"20\"></div>\n" +
                    "                    </div>\n" +
                    "                    <div class=\"inputRow\" >\n" +
                    "                        <div class=\"label\">نام پدر:</div>\n" +
                    "                        <div class=\"input\"><input class=\"input\" type=\"text\" name=\"FatherName\" size=\"20\"></div>\n" +
                    "                    </div>\n" +
                    "                    <div class=\"inputRow\" >\n" +
                    "                        <div class=\"label\">تاریخ تولد:</div>\n" +
                    "                        <div class=\"input\"><input class=\"input\" type=\"text\" name=\"DateOfBirth\" size=\"20\"></div>\n" +
                    "                    </div>\n" +
                    "                    <div class=\"LastInputRow\" >\n" +
                    "                        <div class=\"label\">کد ملی:</div>\n" +
                    "                        <div class=\"input\"><input class=\"input\" type=\"text\" name=\"NationalCode\" size=\"20\"></div>\n" +
                    "                    </div>\n" +
                    "                    <div>\n" +
                    "                        <div class=\"buttonDiv\">\n" +
                    "                            <input class=\"button\" type=\"submit\" value=\"ثبت\" >\n" +
                    "                        </div>\n" +
                    "                    </div>\n" +
                    "                    </form>");
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
