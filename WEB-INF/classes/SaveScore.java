import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.sql.*;

public class SaveScore extends HttpServlet {
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

                Connection con = DriverManager.getConnection(url, user, password);
                Statement stmt = con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_READ_ONLY);

                String email = request.getParameter("email");
                String quiz_id = request.getParameter("quiz_id");
                String name = request.getParameter("name");
                String surname = request.getParameter("surname");
                String points = request.getParameter("points");
                String max_points = request.getParameter("max_points");

                String query = "INSERT INTO results (email, quiz_id, name, surname, points, max_points) VALUES (\"" +
                    email + "\", " +
                    quiz_id + ", \"" +
                    name + "\", \"" +
                    surname + "\", " +
                    points + ", " +
                    max_points + ");";
                int num = stmt.executeUpdate(query);

                PrintWriter out = response.getWriter();
                response.setContentType("text/plain");
                response.setCharacterEncoding("UTF-8");
                String resp;
                if(num > 0){
                    resp = "correcc";
                }
                else{
                    resp = "not correcc";
                }
                out.print(resp);
                out.flush();
            }
            catch(SQLException e){
                e.printStackTrace();
                System.out.println("database error");
            }
            catch(ClassNotFoundException e){
                e.printStackTrace();
            }
    }
}

