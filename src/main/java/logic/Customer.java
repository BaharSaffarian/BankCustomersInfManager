package logic;

/**
 * Created by DOTIN SCHOOL 3 on 5/26/2015.
 */
public abstract class Customer {
    private String id;

    protected Customer(String id) {
        this.id = id;
    }

    protected Customer() {
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getId() {
        return id;
    }
}
