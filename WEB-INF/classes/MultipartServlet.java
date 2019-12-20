import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.sql.*;
import java.util.Random;
import java.util.List;
import java.util.ArrayList;
import com.google.gson.Gson;

public class MultipartServlet extends HttpServlet {
    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException{
            HttpSession session = request.getSession();
            response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate"); // HTTP 1.1.

            String uploadPath = getServletContext().getRealPath("") + "projectrwa/img";
            String fileName = (String) session.getAttribute("quiz_id");
            for (Part part : request.getParts()) {
                if(part.getSubmittedFileName() != ""){
                    part.write(uploadPath + File.separator + fileName);
                }
            }
            response.sendRedirect(request.getContextPath() + "/projectrwa/editor/editquiz.jsp");

    }
}
