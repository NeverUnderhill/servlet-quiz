import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.sql.*;
import java.util.Random;
import java.util.List;
import java.util.ArrayList;
import com.google.gson.Gson;


public class DeleteQuestion extends HttpServlet {
    private String message;

    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException{
            try{
                String driver = "org.mariadb.jdbc.Driver";
                Class.forName(driver);
                final String url = "jdbc:mariadb://localhost:3306/quiz";
                final String user = "root";
                final String password = ""; 
                HttpSession session = request.getSession();

                Connection con;
                Statement stmt;

                con = DriverManager.getConnection(url, user, password);
                stmt = con.createStatement();

                stmt.executeQuery("delete from questions where quiz_id = " + session.getAttribute("quiz_id") + " and order_no = " + request.getParameter("row") + ";");
                stmt.executeQuery("update questions set order_no = order_no - 1 where quiz_id = " + session.getAttribute("quiz_id") +" and order_no >= " + request.getParameter("row") + ";");

                response.sendRedirect(request.getContextPath() + "/projectrwa/editor/editquiz.jsp");
            }
            catch(SQLException e){
                e.printStackTrace();
            }
            catch(ClassNotFoundException e){
                e.printStackTrace();
            }
    }
}

