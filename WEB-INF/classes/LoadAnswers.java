import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.sql.*;
import java.util.Random;
import java.util.List;
import java.util.ArrayList;
import com.google.gson.Gson;


public class LoadAnswers extends HttpServlet {
    private String message;

    public void doGet(HttpServletRequest request, HttpServletResponse response)
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
                String id = (String) session.getAttribute("question_id");

                ResultSet rs = stmt.executeQuery("select * from questions where id = '" + id + "';");
                rs.next();
                QuestionData question = new QuestionData(rs.getString("id"), rs.getString("quiz_id"), rs.getString("text"), Integer.parseInt(rs.getString("time")));
                for(int i = 0; i < 8; i++){
                    question.setAnswer(i, rs.getString("answer" + Integer.toString(i + 1)));
                    question.setCorrecc(i, rs.getString("correct" + Integer.toString(i + 1)));
                }

                String questionJson = new Gson().toJson(question);
                System.out.println(questionJson);

                response.setContentType("application/json");
                response.setCharacterEncoding("UTF-8");
                out.print(questionJson);
                out.flush();
            }
            catch(SQLException e){
                System.out.println("greska u bazi");
                e.printStackTrace();
            }
            catch(ClassNotFoundException e){
                e.printStackTrace();
            }
    }
}

