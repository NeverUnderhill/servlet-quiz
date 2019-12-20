import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.sql.*;
import java.util.Random;
import java.util.List;
import java.util.ArrayList;
import com.google.gson.Gson;


public class GetEditors extends HttpServlet {
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

                String query = "select * from editors;";
                ResultSet rs = stmt.executeQuery(query);

                List<EditorData> quizzes = new ArrayList<>();
                rs.next();
                while(true){
                    if(rs.isAfterLast())
                        break;
                    quizzes.add(new EditorData(rs.getString("id"), ""));
                    rs.next();
                }

                String editorQuizDataJson = new Gson().toJson(quizzes);

                PrintWriter out = response.getWriter();
                response.setContentType("application/json");
                response.setCharacterEncoding("UTF-8");
                out.print(editorQuizDataJson);
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

