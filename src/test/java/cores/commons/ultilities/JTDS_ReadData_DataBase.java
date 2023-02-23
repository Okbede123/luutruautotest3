package cores.commons.ultilities;

import java.sql.Connection;
import java.sql.DriverManager;

public class JTDS_ReadData_DataBase {

    public static Connection getSQLServerConnection(){
        String hostName = "10.24.113.1";
        String sqlInstanceName = "master";
        String database = "KV_TimeSheet_Booking_Dev";
        String userName = "kiotvietdev";
        String password = "C1t1g000$6162";
        return getSQLServerConnection(hostName,sqlInstanceName,database,userName,password);
    }

    public static Connection getSQLServerConnection(String hostName,String sqlInstanceName,String database,String userName,String password){
        Connection connection = null;
        try {
            Class.forName("net.sourceforge.jtds.jdbc.Driver");
            String connectionURL = "jdbc:jtds:sqlserver://"+ hostName+":1433/"+ database +";instance="+sqlInstanceName;
            connection = DriverManager.getConnection(connectionURL,userName,password);
        }catch (Exception e){
            e.printStackTrace();
        }
        return connection;
    }
}
