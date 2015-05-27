package DataAccess;

import logic.RealCustomer;

import java.sql.*;

public class DataHandler {
    private final static String DB_URL="jdbc:mysql://localhost:3306/bahar_bank_db?useUnicode=true&characterEncoding=utf-8";
    private final static String USER_NAME="root";
    private final static String PASSWORD="Root";
    static Connection dbConnection=null;
    static PreparedStatement preparedStatement=null;
    static {
        try {
            Class.forName("com.mysql.jdbc.Driver").newInstance();
            dbConnection = DriverManager.getConnection(DB_URL, USER_NAME, PASSWORD);
        }catch (SQLException e){
            e.printStackTrace();
        }catch (ClassNotFoundException e){
            e.printStackTrace();
        }catch (InstantiationException e){
            e.printStackTrace();
        }catch (IllegalAccessException e) {
            e.printStackTrace();
        }
    }

    public static boolean isNationalCodeExists(String nationalCode){
        try {
            preparedStatement=dbConnection.prepareStatement("SELECT * FROM real_customer WHERE national_code="+nationalCode);
            ResultSet result=preparedStatement.executeQuery();
            if(!result.next())
                return true;
        }catch (SQLException e){
            e.printStackTrace();
        }
        return false;
    }

    public static int insertRealCustomer(RealCustomer realCustomer){
        try {
            preparedStatement=dbConnection.prepareStatement("Insert into customer value()");
            preparedStatement.executeUpdate();
            ResultSet customerResult=preparedStatement.executeQuery("SELECT @@IDENTITY");
            customerResult.next();
            int customerId=customerResult.getInt(1);
            preparedStatement=dbConnection.prepareStatement("insert into real_customer "
                    + " values (?, ?, ?, ?, ?, ?)");
            preparedStatement.setInt(1,customerId);
            preparedStatement.setString(2, realCustomer.getFirstName());
            preparedStatement.setString(3,realCustomer.getLastName());
            preparedStatement.setString(4,realCustomer.getFatherName());
            preparedStatement.setDate(5, java.sql.Date.valueOf(realCustomer.getDateOfBirth()));
            preparedStatement.setString(6, realCustomer.getNationalCode());
            int resultNum=preparedStatement.executeUpdate();
            if(resultNum==1){
                return customerId;
            }
        }catch (SQLException e){
            e.printStackTrace();
        }
        return -1;
    }
}
