package logic;

import DataAccess.DataHandler;

import javax.servlet.http.HttpServletRequest;

public class LogicHandler {
    public static int registerCustomer(HttpServletRequest request){
        if(DataAccess.DataHandler.isNationalCodeExists(request.getParameter("NationalCode"))){
            RealCustomer realCustomer=new RealCustomer(request.getParameter("FirstName"),request.getParameter("FamilyName"),
                                                       request.getParameter("FatherName"),request.getParameter("DateOfBirth"),
                                                       request.getParameter("NationalCode"));
            return DataHandler.insertRealCustomer(realCustomer);
        }
        return -1;
    }
}
