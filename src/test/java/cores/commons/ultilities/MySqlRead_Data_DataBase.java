package cores.commons.ultilities;

import java.sql.Connection;
import java.sql.DriverManager;

public class MySqlRead_Data_DataBase {

    public static Connection getMySQLConnection(){
        String hostName = "ducthantai.site";
        String dbName = "cs16_ranktest";
        String userName = "cs16_rank";
        String password = "halong123";
        return getMySQLConnection(hostName,dbName,userName,password);
    }

    private static Connection getMySQLConnection(String hostName,String dbName,String userName,String password){
        Connection connection =  null;
        try {
            //khai báo class driver cho my sql
            //Class.forName("com.mysql.jdbc.Driver");

            //cấu trúc url connection dành cho mysql
            String connectionURL = "jdbc:mysql://"+hostName+":3306/"+dbName;
            connection = DriverManager.getConnection(connectionURL,userName,password);
        }catch (Exception e){
            e.printStackTrace();
        }
        return connection;
    }
}
