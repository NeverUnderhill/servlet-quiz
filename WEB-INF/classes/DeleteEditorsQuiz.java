import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.sql.*;
import java.util.Random;
import java.util.List;
import java.util.ArrayList;
import com.google.gson.Gson;


public class DeleteEditorsQuiz extends HttpServlet {
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

                String topVidsQuery = "select * from quizzes where editor = '" + session.getAttribute("id") + "';";
                ResultSet rs = stmt.executeQuery(topVidsQuery);

                rs.next();
                for(int i = 0; i < Integer.parseInt(request.getParameter("row")); i++){
                    if(rs.isAfterLast())
                        break;
                    rs.next();
                }
                String id = rs.getString("id");

                stmt.executeQuery("delete from quizzes where id = '" + id + "';");

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

