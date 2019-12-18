package testing;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class jdbc {

    public static void main(String[] args) throws SQLException {

        System.out.println(Search("Select * from users where user_id = 1211;"));
        
        
//        System.out.println("\nInitial contents of table:");
//Steps 3 and 4…
//Start of step 5…
        //String insert = "INSERT INTO users VALUES (1237,3121, 'b', 'abed','bekaa', 32323, 'fdfdf@gmail.com', 34)";
    }

    private static Connection OpenConnection() {
        Connection connection;

        try {
            Class.forName("com.mysql.jdbc.Driver");

            connection
                    = DriverManager.getConnection("jdbc:mysql://127.0.0.1/bar_managment", "admin", "68661661abc??");

            System.out.println("Database connected");
        } catch (ClassNotFoundException e) {
            System.out.println("Class not Found");
            return null;
        } catch (SQLException e) {
            System.out.println("sql exception");
            return null;
        }
        return connection;
    }

    public boolean InsertIntoTable(String SQLStatement) {
        try {
            Connection cn = OpenConnection();
            if (cn == null) {
                return false;
            }

            Statement statement = cn.createStatement();

            int result = statement.executeUpdate(SQLStatement);
            System.out.println(result);

            cn.close();
        } catch (Exception e) {
            return false;
        }
        return true;
    }

    public static boolean Search(String SQLStatement) {
        try {
            Connection cn = OpenConnection();
            if (cn == null) {
                return false;
            }

            Statement statement = cn.createStatement();
            ResultSet rs;

            rs = statement.executeQuery(SQLStatement);
            System.out.println("Statement executed");

            rs.last();
            boolean reslt;
            
           if (rs.getRow() > 0)
               reslt = true;
           else reslt = false;
           
            cn.close();
            return reslt;
            
        } catch (Exception e) {
            return false;
        }
       
    }
}
