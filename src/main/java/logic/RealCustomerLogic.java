package logic;

import model.RealCustomer;
import model.RealCustomerCRUD;

import java.util.ArrayList;

public class RealCustomerLogic {
    public static int registerCustomer(RealCustomer realCustomer) {
        if (!RealCustomerCRUD.doesNationalCodeExists(realCustomer.getNationalCode())) {
            return RealCustomerCRUD.insertRealCustomer(realCustomer);
        }
        return -1;
    }

    public static ArrayList<RealCustomer> searchRealCustomer(RealCustomer realCustomer) {
        return RealCustomerCRUD.selectRealCustomer(realCustomer);
    }

    public static int updateCustomer(RealCustomer realCustomer, String oldNationalCode) {
        if (!realCustomer.getNationalCode().equals(oldNationalCode) && !RealCustomerCRUD.doesNationalCodeExists(realCustomer.getNationalCode())) {
            if (RealCustomerCRUD.updateRealCustomer(realCustomer))
                return 1;
        } else if (realCustomer.getNationalCode().equals(oldNationalCode)) {
            if (RealCustomerCRUD.updateRealCustomer(realCustomer))
                return 1;
        }
        return -1;
    }

    public static boolean deleteRealCustomerById(String id) {
        return RealCustomerCRUD.deleteRealCustomerById(id);
    }
}
