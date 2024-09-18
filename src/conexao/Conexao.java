package conexao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexao {

    private static Connection conn;

    public static Connection GetConnection() {
        try {
            if(conn == null) {
                Class.forName("com.mysql.cj.jdbc.Driver");
                // conn = DriverManager.getConnection("jdbc:sqlserver://servername=DESKTOP-H156HPH\\SQLEXPRESS/JavaProject;encrypt=true;integratedSecurity=true;authenticationScheme=JavaKerberos");
                conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/javaproject", "root", "root");
                System.out.println("Conexão estabelecida com sucesso!");
                return conn;
            } else {
                System.out.println("Caiu no else dentro do Try.");
                return conn;
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            System.out.println("Caiu no ClassNotFoundException!");
            return null;
        } catch (SQLException ex) {
            ex.getStackTrace();
            System.out.println("Caiu no catch SQLException!");
            return null;
        }
    }
}