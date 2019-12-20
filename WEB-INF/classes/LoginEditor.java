import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.sql.*;

public class LoginEditor extends HttpServlet {
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

                String uname = request.getParameter("username"); 
                String passw = request.getParameter("password"); 

                String query = "SELECT * FROM editors";
                ResultSet rs = stmt.executeQuery(query);

                boolean exists = false;
                while(rs.next()){
                    if(rs.getString("id").equals(uname) && rs.getString("password").equals(passw)){
                        exists = true;
                        session.setAttribute("id", uname);
                        break;
                    }
                }

                PrintWriter out = response.getWriter();
                response.setContentType("text/plain");
                response.setCharacterEncoding("UTF-8");
                String resp;
                if(exists){
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
            }
            catch(ClassNotFoundException e){
                e.printStackTrace();
            }
    }
}

