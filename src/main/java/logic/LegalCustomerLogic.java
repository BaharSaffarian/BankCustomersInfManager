package logic;

import model.LegalCustomer;
import model.LegalCustomerCRUD;

import java.util.ArrayList;

public class LegalCustomerLogic {
    public static int registerCustomer(LegalCustomer legalCustomer){
        if(!LegalCustomerCRUD.doesEconomicCodeExists(legalCustomer.getEconomicCode())){
            return LegalCustomerCRUD.insertLegalCustomer(legalCustomer);
        }
        return -1;
    }

    public static ArrayList<LegalCustomer> searchLegalCustomer(LegalCustomer legalCustomer) {
        return LegalCustomerCRUD.selectLegalCustomer(legalCustomer);
    }

    public static int updateCustomer(LegalCustomer legalCustomer, String oldEconomicCod){
        if(!legalCustomer.getEconomicCode().equals(oldEconomicCod) && !LegalCustomerCRUD.doesEconomicCodeExists(legalCustomer.getEconomicCode())){
            if(LegalCustomerCRUD.updateLegalCustomer(legalCustomer))
                return 1;
        }else if(legalCustomer.getEconomicCode().equals(oldEconomicCod)){
            if(LegalCustomerCRUD.updateLegalCustomer(legalCustomer))
                return 1;
        }
        return -1;
    }

    public static boolean deleteLegalCustomerById(String id){
        return LegalCustomerCRUD.deleteLegalCustomerByID(id);
    }

    /*public static LegalCustomer searchCustomer(LegalCustomer legalCustomer){

    }*/
}
