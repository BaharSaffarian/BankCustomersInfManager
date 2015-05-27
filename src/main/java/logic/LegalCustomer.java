package logic;

/**
 * Created by DOTIN SCHOOL 3 on 5/26/2015.
 */
public class LegalCustomer {
    String companyName;
    String registerDate;
    String economicCode;

    public LegalCustomer(String companyName, String registerDate, String economicCode) {
        this.companyName = companyName;
        this.registerDate = registerDate;
        this.economicCode = economicCode;
    }

    public String getCompanyName() {
        return companyName;
    }

    public String getRegisterDate() {
        return registerDate;
    }

    public String getEconomicCode() {
        return economicCode;
    }
}
