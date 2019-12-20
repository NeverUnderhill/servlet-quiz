import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.sql.*;
import java.util.Random;
import java.util.List;
import java.util.ArrayList;
import com.google.gson.Gson;


public class SwapQuestions extends HttpServlet {
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
                
                String src = request.getParameter("src");
                String dst = request.getParameter("dst");

                String query1 = "select * from questions where quiz_id = " + session.getAttribute("quiz_id") + " and order_no = " + src  + ";";
                String query2 = "select * from questions where quiz_id = " + session.getAttribute("quiz_id") + " and order_no = " + dst  + ";";

                ResultSet rs1 = stmt.executeQuery(query1);
                ResultSet rs2 = stmt.executeQuery(query2);

                rs1.next();
                rs2.next();

                String srcId = rs1.getString("id");
                String dstId = rs2.getString("id");

                String update1 = "update questions set order_no = " + dst + " where id = " + srcId + ";";
                String update2 = "update questions set order_no = " + src + " where id = " + dstId + ";";

                con.setAutoCommit(false);

                stmt.executeUpdate(update1);
                stmt.executeUpdate(update2);

                con.commit();

                PrintWriter out = response.getWriter();
                response.setContentType("application/json");
                response.setCharacterEncoding("UTF-8");
                out.print("correcc");
                out.flush();
            }
            catch(SQLException e){
                e.printStackTrace();
            }
            catch(ClassNotFoundException e){
                e.printStackTrace();
            }
    }
}

