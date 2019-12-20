import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.sql.*;
import java.util.Random;
import java.util.List;
import java.util.ArrayList;
import com.google.gson.Gson;


public class GetResults extends HttpServlet {
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

                PrintWriter out = response.getWriter();
                response.setContentType("application/json");
                response.setCharacterEncoding("UTF-8");

                Connection con;
                Statement stmt;

                con = DriverManager.getConnection(url, user, password);
                stmt = con.createStatement();

                List<ResultData> results = new ArrayList<>();
                String resultsQuery = "SELECT CONCAT(results.name, \" \", surname) AS name, email, quizzes.name AS quiz, points, max_points FROM results INNER JOIN quizzes ON results.quiz_id = quizzes.id WHERE quizzes.editor = \"" + session.getAttribute("id") + "\";";
                ResultSet rs = stmt.executeQuery(resultsQuery);
                rs.next();

                while(!rs.isAfterLast()){
                    results.add(new ResultData(rs.getString("name"), rs.getString("email"), rs.getString("quiz"), rs.getString("points"), rs.getString("max_points")));
                    rs.next();
                }

                String resultsDataJson = new Gson().toJson(results);

                out.print(resultsDataJson);
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

