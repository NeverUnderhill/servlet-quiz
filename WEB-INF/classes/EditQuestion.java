import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.sql.*;
import java.util.Random;
import java.util.List;
import java.util.ArrayList;
import com.google.gson.Gson;

public class EditQuestion extends HttpServlet {
    private String message;

    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException{
            try{
                PrintWriter out = response.getWriter();
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
                String query = "UPDATE questions SET " +
                    "text = \"" + request.getParameter("text") + "\", " +
                    "time = "   + request.getParameter("time");
                for(int i = 1; i < 9; i++){
                    query += ", answer" + Integer.toString(i) + " = \"" + request.getParameter("answer" + Integer.toString(i)) + "\"";
                    query += ", correct" + Integer.toString(i) + " = " + toBoolean(request.getParameter("correct" + Integer.toString(i))); 
                }
                query += " WHERE id = " + session.getAttribute("question_id") + ";";

                stmt.executeQuery(query);


                response.sendRedirect(request.getContextPath() + "/projectrwa/editor/editquiz.jsp");
            }
            catch(SQLException e){
                e.printStackTrace();
            }
            catch(ClassNotFoundException e){
                e.printStackTrace();
            }
    }
    private String toBoolean(String s){
        if(s == null){
            return "0";
        }
        if(s.equals("on"))
            return "1";
        else
            return "0";
    }
}

