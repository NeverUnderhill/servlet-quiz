import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.sql.*;

public class LoginAdmin extends HttpServlet {
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

                String query = "SELECT * FROM admins";
                ResultSet rs = stmt.executeQuery(query);

                boolean exists = false;
                while(rs.next()){
                    if(rs.getString("id").equals(uname) && rs.getString("password").equals(passw)){
                        exists = true;
                        session.setAttribute("admin", uname);
                        break;
                    }
                }

                String resp;
                if(exists){
                    response.sendRedirect(request.getContextPath() + "/projectrwa/admin/");
                }
                else{
                    response.sendRedirect(request.getContextPath() + "/projectrwa/admin_register_fail.html");
                }
            }
            catch(SQLException e){
                e.printStackTrace();
            }
            catch(ClassNotFoundException e){
                e.printStackTrace();
            }
    }
}

