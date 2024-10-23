package GameQuiz;

import java.sql.*;

public class DBConnection {


    public static Connection conn;
    static{
        try{
            Class.forName("com.mysql.jdbc.Driver");
            conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/quizDb","root","Lindijem92");
        }
        catch(Exception e){
            System.out.println("Connection failed");
            e.printStackTrace();
        }
    }

    public static Connection getConnection()
    {
        return conn;
    }

    public static void closeConnection()
    {
        try{
            conn.close();
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }
}

