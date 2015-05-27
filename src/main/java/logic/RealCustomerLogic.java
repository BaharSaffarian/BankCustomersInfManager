package logic;

import model.RealCustomer;
import model.RealCustomerCRUD;

import java.util.ArrayList;

public class RealCustomerLogic {
    public static int registerCustomer(RealCustomer realCustomer){
        if(RealCustomerCRUD.isNationalCodeExists(realCustomer.getNationalCode())){
            return RealCustomerCRUD.insertRealCustomer(realCustomer);
        }
        return -1;
    }

    public static ArrayList<RealCustomer> searchRealCustomer(RealCustomer realCustomer){
        return RealCustomerCRUD.selectRealCustomer(realCustomer);
    }
}
