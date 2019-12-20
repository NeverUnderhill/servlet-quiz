import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.sql.*;
import java.util.Random;
import java.util.List;
import java.util.ArrayList;
import com.google.gson.Gson;


public class GetRandomQuiz extends HttpServlet {
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
                String query;
                if(request.getParameter("excludedQuizzes").isEmpty()){
                    query = "select * from quizzes order by rand();";
                }
                else{
                    query = "select * from quizzes where id not in (" + request.getParameter("excludedQuizzes") + ") order by rand();";
                    
                }
                System.out.println(query);
                ResultSet rs = stmt.executeQuery(query);
                rs.next();

                session.setAttribute("currentQuizName", rs.getString("name"));
                String quiz_id = rs.getString("id");
                session.setAttribute("quiz_id", quiz_id);

                rs = stmt.executeQuery("select * from questions where quiz_id = '" + quiz_id + "';");

                List<QuestionData> questions = new ArrayList<>();
                rs.next();
                while(true){
                    if(rs.isAfterLast())
                        break;
                    questions.add(new QuestionData(rs.getString("id"), rs.getString("quiz_id"), rs.getString("text"), Integer.parseInt(rs.getString("time"))));
                    for(int i = 0; i < 8; i++){
                        questions.get(questions.size() - 1).setAnswer(i, rs.getString("answer" + Integer.toString(i + 1)));
                        questions.get(questions.size() - 1).setCorrecc(i, rs.getString("correct" + Integer.toString(i + 1)));
                    }

                    rs.next();
                }

                String questionJson = new Gson().toJson(questions);
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

