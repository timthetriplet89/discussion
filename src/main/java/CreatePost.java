/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Timothy
 */
@WebServlet(urlPatterns = {"/CreatePost"})
public class CreatePost extends HttpServlet {

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

        // CAPTURE THE SUBMITTED DISCUSSION POST
        Date timeStamp = new Date();
        SimpleDateFormat formatter = new SimpleDateFormat("EEE, dd MMM yyyy HH:mm");
        String postTime = formatter.format(timeStamp);
        
        String text = request.getParameter("postText");
        String username = (String)request.getSession().getAttribute("username");
        String discussionPost = text + "  -By " + username + ", " + postTime;
        
        // WRITE TO THE FILE (ADD A COUPLE LINES...)
        //     (From http://stackoverflow.com/questions/1625234/how-to-append-text-to-an-existing-file-in-java)
        try {
            String path = getServletContext().getRealPath("/WEB-INF/discussion");
            PrintWriter out2 = new PrintWriter(new BufferedWriter(new FileWriter(path, true)));
            // getServletContext().getResource("/WEB-INF/discussion.txt")
            out2.println(discussionPost);
            out2.close();
        } catch (IOException e) {
            //exception handling left as an exercise for the reader
        }
        
        //response.sendRedirect("/discussion3/viewPosts.jsp"); // What was this doing here?! Was redirecting to the wrong page!
        response.sendRedirect("/discussion3/LoadPosts");
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
