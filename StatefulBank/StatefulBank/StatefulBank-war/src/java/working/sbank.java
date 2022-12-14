/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package working;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
@WebServlet(name = "sbank", urlPatterns = {"/sbank"})
public class sbank extends HttpServlet {

    BankTransactionLocal bankTransaction = lookupBankTransactionLocal();
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String opr = request.getParameter("group1");
        int amount = Integer.parseInt(request.getParameter("amount"));
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet sbank</title>");            
            out.println("</head>");
            out.println("<body>");
            if(opr.equals("deposit"))
            {
                int finalbal = bankTransaction.deposit(amount);
                out.println("<h3> Amount Rs " + amount + " deposited successfully.\n Available Balance - Rs " + finalbal + "</h3>");
            }
            else if(opr.equals("withdraw"))
            {
                int availbal = bankTransaction.getbal();
                if(availbal>amount)
                {
                    int finalbal = bankTransaction.withdraw(amount);
                    out.println("<h3> Amount Rs " + amount + " withdrawn successfully!\n Available Balance - Rs " + finalbal + "</h3>");
                }
                else
                {
                    out.println("<h3> Amount Rs " + amount + " cannot be withdrawn as the available Balance - Rs " + availbal + "</h3>");
                }
            }
            out.println("</body>");
            out.println("</html>");
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

    private BankTransactionLocal lookupBankTransactionLocal() {
        try {
            Context c = new InitialContext();
            return (BankTransactionLocal) c.lookup("java:global/StatefulBank/StatefulBank-ejb/BankTransaction!working.BankTransactionLocal");
        } catch (NamingException ne) {
            Logger.getLogger(getClass().getName()).log(Level.SEVERE, "exception caught", ne);
            throw new RuntimeException(ne);
        }
    }

}
