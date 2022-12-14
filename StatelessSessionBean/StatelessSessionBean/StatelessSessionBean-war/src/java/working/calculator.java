package working;
import java.io.IOException;
import java.io.PrintWriter;
import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
@WebServlet(name = "calculator", urlPatterns = {"/calculator"})
public class calculator extends HttpServlet {
    @EJB
    private NewSessionBeanLocal newSessionBean;
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            String opr = request.getParameter("group1");
            int num1 = Integer.parseInt(request.getParameter("num1"));
            int num2 = Integer.parseInt(request.getParameter("num2"));
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet calculator</title>");            
            out.println("</head>");
            out.println("<body>");
            if(opr.equals("add"))
            {
                float ans = newSessionBean.add(num1, num2);
                out.println("<h3> Result Addition : " + ans + "</h1>");
            }
            else if(opr.equals("sub"))
            {
                float ans = newSessionBean.subtract(num1, num2);
                out.println("<h3> Result Subtraction : " + ans + "</h1>");
            }
            else if(opr.equals("multi"))
            {
                float ans = newSessionBean.multiply(num1, num2);
                out.println("<h3> Result Multiply : " + ans + "</h1>");
            }
            else if(opr.equals("div"))
            {
                float ans = newSessionBean.division(num1, num2);
                out.println("<h3> Result Division : " + ans + "</h1>");
            }
            out.println("</body>");
            out.println("</html>");
        }
    }
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }
    @Override
    public String getServletInfo() {
        return "Short description";
    }
}
