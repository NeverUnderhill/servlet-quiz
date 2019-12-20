import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.sql.*;

public class RegisterEditor extends HttpServlet {
    private String message;

    public void doPost(HttpServletRequest request, HttpServletResponse response)
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

                String query = "SELECT * FROM editors;";
                ResultSet rs = stmt.executeQuery(query);

                boolean exists = false;
                while(rs.next()){
                    if(rs.getString("id").equals(uname)){
                        exists = true;
                        break;
                    }
                }

                if(!exists){
                    query = "INSERT INTO editors VALUES (\"" + uname + "\", \"" + passw + "\")";
                    stmt.executeQuery(query);
                }

                PrintWriter out = response.getWriter();
                response.setContentType("text/plain");
                response.setCharacterEncoding("UTF-8");
                String resp;
                if(exists){
                    response.sendRedirect(request.getContextPath() + "/projectrwa/editor_register_fail.html");
                }
                else{
                    session.setAttribute("id", uname);
                    response.sendRedirect(request.getContextPath() + "/projectrwa/editor/");
                }
            }
            catch(SQLException e){
                //e.printStackTrace();
                System.out.println("sjebana baza");
            }
            catch(ClassNotFoundException e){
                //e.printStackTrace();
            }
    }
}

