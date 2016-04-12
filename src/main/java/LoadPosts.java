/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Stack;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.mycompany.discussion3.Bean123;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import javax.servlet.RequestDispatcher;

/**
 *
 * @author Timothy
 */
@WebServlet(urlPatterns = {"/LoadPosts"})
public class LoadPosts extends HttpServlet {

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
        
        String root = getInitParameter("root");
        
        Bean123 bean = new Bean123();
        
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            
            // AFTER MUCH SEARCHING, THIS FILE READING SOLUTION IS SPONSORED BY... 
            //  ...http://www.devmanuals.com/tutorials/java/servlet/TextFileReading.html

//            InputStream in = getServletContext().getResourceAsStream("/WEB-INF/discussion.txt");
//            InputStream in = getServletContext().getResourceAsStream("/discussion.txt");  
            //String path = getServletContext().getRealPath("/") + "discussion.txt";
            InputStream in = getServletContext().getResourceAsStream("/list_posts.txt");      
            
            if(in == null){
                out.println("file not found!"); 
                response.setStatus(response.SC_NOT_FOUND); 
            }
            else
            { 
                BufferedReader br = new BufferedReader((new InputStreamReader(in))); 
                String line;  // String word 
                while((line= br.readLine())!= null) 
                {
                    bean.addPost(line);
                }
            }
            
            // Create reverse-chronologically ordered list of the posts
            bean.reverseOrder(); 
            // STORE BEAN IN A SESSION
            // How to forward an attribute to a JSP 
            // http://www.coderanch.com/t/445845/JSP/java/request-getAttribute-returns-null-jsp 
            request.setAttribute("bean",bean); 
            RequestDispatcher view = getServletContext().getRequestDispatcher("/viewPosts.jsp"); 
            view.forward(request,response);
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
