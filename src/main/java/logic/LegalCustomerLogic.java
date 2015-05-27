package logic;

import model.LegalCustomer;
import model.LegalCustomerCRUD;

public class LegalCustomerLogic {
    public static int registerCustomer(LegalCustomer legalCustomer){
        if(LegalCustomerCRUD.isEconomicCodeExists(legalCustomer.getEconomicCode())){
            return LegalCustomerCRUD.insertLegalCustomer(legalCustomer);
        }
        return -1;
    }

    /*public static LegalCustomer searchCustomer(LegalCustomer legalCustomer){

    }*/
}
