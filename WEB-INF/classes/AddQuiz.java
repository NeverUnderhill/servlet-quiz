import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.sql.*;

public class AddQuiz extends HttpServlet {
    private String message;

    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException{
            try{
                System.out.println("doslo dovde");
                String driver = "org.mariadb.jdbc.Driver";
                Class.forName(driver);
                final String url = "jdbc:mariadb://localhost:3306/quiz";
                final String user = "root";
                final String password = ""; 
                HttpSession session = request.getSession();

                Connection con = DriverManager.getConnection(url, user, password);
                Statement stmt = con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_READ_ONLY);

                String name = request.getParameter("name"); 

                ResultSet rs = stmt.executeQuery("SELECT * FROM quizzes WHERE name = '" + name + "';");
                if(rs.next()){
                    response.sendRedirect(request.getContextPath() + "/projectrwa/editor/addquiz.html");
                }
                else{
                    String query = "INSERT INTO quizzes (name, editor) VALUES ('" + name + "', '" + session.getAttribute("id") + "');";
                    stmt.executeQuery(query);

                    response.sendRedirect(request.getContextPath() + "/projectrwa/editor/index.jsp");
                }
            }
            catch(SQLException e){
                //e.printStackTrace();
                System.out.println("baza");
            }
            catch(ClassNotFoundException e){
                //e.printStackTrace();
            }
    }
}

