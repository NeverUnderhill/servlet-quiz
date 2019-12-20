import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.sql.*;
import java.util.Random;
import java.util.List;
import java.util.ArrayList;
import com.google.gson.Gson;


public class Admin extends HttpServlet {
    private String message;

    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException{
            try{
                String driver = "org.mariadb.jdbc.Driver";
                Class.forName(driver);
                final String url = "jdbc:mariadb://localhost:3306/quiz";
                final String user = "root";
                final String password = ""; 

                Connection con = DriverManager.getConnection(url, user, password);
                Statement stmt = con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_READ_ONLY);

                String operation = request.getParameter("op");
                String table = request.getParameter("class");
                String id = Integer.parseInt(request.getParameter("id"));

                if(op == "delete"){
                    String query = "DELETE FROM " + table + " WHERE 'id' = " + id; 
                    stmt.executeQuery(query);
                }

            }
            catch(SQLException e){
                //e.printStackTrace();
                System.out.println("sjebana baza");
            }
            catch(ClassNotFoundException e){
                //e.printStackTrace();
            }
    }
}

