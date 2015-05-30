package presentation;

import model.LegalCustomer;
import model.LegalCustomerCRUD;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;


public class LegalCustomerSearchServlet extends HttpServlet {
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
                "                    <li><a href=\"RealCustomerSearch.html\">جستجوی مشتری حقیقی</a></li>\n" +
                "                    <li class=\"current_page_item\"><a href=\"LegalCustomerSearch.html\">جستجوی مشتری حقوقی</a></li>\n" +
                "                </ul>\n" +
                "            </div>\n" +
                "        </div>\n" +
                "    </div>\n" +
                "    <div id=\"content\">\n" +
                "        <div class=\"post\">\n" +
                "            <div class=\"entry\">");
        LegalCustomer legalCustomer=new LegalCustomer();
        if(request.getParameter("CustomerId").length()!=0)
            legalCustomer.setId(request.getParameter("CustomerId"));
        if(request.getParameter("CompanyName").length()!=0)
            legalCustomer.setCompanyName(request.getParameter("CompanyName"));
        if(request.getParameter("EconomicCode").length()!=0)
            legalCustomer.setEconomicCode(request.getParameter("EconomicCode"));
        ArrayList<LegalCustomer> legalCustomers= LegalCustomerCRUD.selectLegalCustomer(legalCustomer);
        if(legalCustomers.isEmpty()){
            out.println("<div class=\"sidebar\">");
            out.println("<p class=\"textCenter\">موردی یافت نشد</p>");
            out.println("</div>");
        }
        else{
            out.println("<div class=\"table\">\n" +
                    "                    <div class=\"htr\">\n" +
                    "                        <div class=\"idtd\">ردیف</div>\n" +
                    "\n" +
                    "                        <div class=\"htd\"><p>شناسه</p></div>\n" +
                    "                        <div class=\"htd\"><p>نام شرکت</p></div>\n" +
                    "                        <div class=\"htd\"><p>تاریخ ثبت</p></div>\n" +
                    "                        <div class=\"htd\"><p>کد اقتصادی</p></div>\n" +
                    "                        <div class=\"htd\"></div>\n" +
                    "                    </div>");
            int counter = 0;
            out.println("<script>\n" +
                    "                        function visible(count){\n" +
                    "                            document.getElementById(\"companyName\"+ count).style.display=\"inline\";\n" +
                    "                            document.getElementById(\"registerDate\"+ count).style.display=\"inline\";\n" +
                    "                            document.getElementById(\"economicCode\"+ count).style.display=\"inline\";\n" +
                    "                            document.getElementById(\"send\"+ count).style.display=\"inline\";\n" +
                    "\n" +
                    "                            document.getElementById(\"companyNameLabel\"+count).style.display=\"none\";\n" +
                    "                            document.getElementById(\"registerDateLabel\"+count).style.display=\"none\";\n" +
                    "                            document.getElementById(\"economicCodeLabel\"+ count).style.display=\"none\";\n" +
                    "                            document.getElementById(\"choose\"+count).style.display=\"none\";\n" +
                    "                        }\n" +
                    "                         function doUpdate()\n" +
                    "                        {\n" +
                    "                            form=document.getElementById('myform');\n" +
                    "                            form.target='_blank';\n" +
                    "                            form.action='LegalCustomerUpdateServlet';\n" +
                    "                            form.submit();\n" +
                    "                            form.target='';\n" +
                    "                        }"+
                    "                         function doDelete()\n" +
                    "                        {\n" +
                    "                            form=document.getElementById('myform');\n" +
                    "                            form.target='_blank';\n" +
                    "                            form.action='LegalCustomerDeleteServlet';\n" +
                    "                            form.submit();\n" +
                    "                            form.target='';\n" +
                    "                        }"+
                    "</script>");
            for (LegalCustomer legalCustomer1 : legalCustomers) {
                counter++;
                legalCustomer = legalCustomer1;
                out.println("<div class=\"tr\" >\n"+
                        "<form method=\"get\" id=\"myform\">" +
                                "                        <div class=\"idtd\">" + counter + "</div>\n" +
                                "                        <div class=\"td\">" +
                                "                        <p id=\"idLabel"+counter+"\">"+legalCustomer.getId()+"</p>"+
                                "                        <input style=\"display:none\" type=\"text\" id=\"id"+counter+"\" name=\"id\" size=\"8\" value=\"" + legalCustomer.getId() + "\">" +
                                "                        </div>\n" +
                                "                        <div class=\"td\">" +
                                "                        <p id=\"companyNameLabel"+counter+"\">"+legalCustomer.getCompanyName()+"</p>"+
                                "                        <input style=\"display:none\" type=\"text\" id=\"companyName"+counter+"\" name=\"companyName\" size=\"8\" value=\"" + legalCustomer.getCompanyName() + "\">" +
                                "                        </div>\n");
                out.println("                        <div class=\"td\">" +
                                "                        <p id=\"registerDateLabel"+counter+"\">"+legalCustomer.getRegisterDate().substring(0,10)+"</p>"+
                                "                        <input style=\"display:none\" type=\"text\" id=\"registerDate"+counter+"\" name=\"registerDate\" size=\"8\" value=\"" + legalCustomer.getRegisterDate().substring(0,10) + "\">"+
                                "                        </div>\n");
                out.println("                        <div class=\"td\">" +
                        "                        <p id=\"economicCodeLabel"+counter+"\">"+legalCustomer.getEconomicCode()+"</p>"+
                        "                        <input style=\"display:none\" type=\"text\" id=\"economicCode"+counter+"\" name=\"economicCode\" size=\"8\" value=\"" + legalCustomer.getEconomicCode() + "\">"+
                        "                        </div>\n");
                out.println(
                        "                        <div class=\"td\" id=\"choose"+counter+"\">\n" +
                        "                            <a href=\"#\" onclick=\"visible("+counter+")\"><img src=\"images/user_male_edit.png\" style=\"margin-left: 5px\"></a>\n" +
                        "                            <a  onclick=\"doDelete()\"><img src=\"images/user_male_delete.png\"></a>\n" +
                        "                        </div>\n" +
                        "                        <div class=\"td\" style=\"display:none\" id=\"send"+counter+"\">" +
                        "                           <div class=\"buttonDiv\">\n" +
                        "                        <input class=\"tinButton\" type=\"submit\" value=\"ثبت\" onclick=\"doUpdate()\">\n" +
                        "                   </div>"+
                        "                        </div>"+
                        "</form>" +
                        "                    </div>");
            }
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
