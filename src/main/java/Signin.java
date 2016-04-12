/*
 *  Sources:  1) http://www.avajava.com/tutorials/lessons/how-do-i-read-a-properties-file.html?page=1
*             2) http://stackoverflow.com/questions/2161054/where-to-place-and-how-to-read-configuration-resource-files-in-servlet-based-app
 */

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.Enumeration;
import java.util.Hashtable;
import java.util.Properties;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Timothy Steele
 */
@WebServlet(urlPatterns = {"/Signin"})
public class Signin extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        response.setContentType("text/html;charset=UTF-8");
        String passwordIn = request.getParameter("password");
        String usernameIn = request.getParameter("username");
        
        // NEXT, do one of two things:
        // 1) loop through all username/password pairs, check for a match, and if so, move to login page (if not, to invalid login page)
        // 2) Find a function which looks for the submitted username/password in the properties (or enuKeys) file.
        
        try {
            InputStream inputStream = getServletContext().getResourceAsStream("/WEB-INF/users.properties"); 
            Properties properties = new Properties(); 
            properties.load(inputStream); 
            // inputStream.close(); 
             
            if (passwordIn.equals(properties.getProperty(usernameIn, null)) &&
                    !passwordIn.isEmpty()) {
                
                request.getSession().setAttribute("username",usernameIn);
                response.sendRedirect("/DiscussionThread2/newPost.jsp");
                
            } else {
                response.sendRedirect("/DiscussionThread2/invalidLogin.jsp");
            }
        }  catch (FileNotFoundException e) {
                System.out.println("Printing first catch statement");
		e.printStackTrace();
	} catch (IOException e) {
                System.out.println("Printing second catch statement");
		e.printStackTrace();
	}
            }
    
    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
