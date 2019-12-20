import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.sql.*;
import java.util.Random;
import java.util.List;
import java.util.ArrayList;
import com.google.gson.Gson;


public class GetQuizzesQuestions extends HttpServlet {
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
                String id = (String) session.getAttribute("quiz_id");

                ResultSet rs = stmt.executeQuery("select * from questions where quiz_id = '" + id + "' order by order_no;");
                List<QuestionData> questions = new ArrayList<>();
                rs.next();
                while(true){
                    if(rs.isAfterLast())
                        break;
                    questions.add(new QuestionData(rs.getString("id"), rs.getString("quiz_id"), rs.getString("text"), Integer.parseInt(rs.getString("time"))));
                    rs.next();
                }

                session.setAttribute("quiz_id", id);

                String questionsJson = new Gson().toJson(questions);

                PrintWriter out = response.getWriter();
                response.setContentType("application/json");
                response.setCharacterEncoding("UTF-8");
                out.print(questionsJson);
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

