/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author NGUYENSE190290
 */
@WebServlet(urlPatterns = {"/CalculatorServlet"})
public class CalculatorServlet extends HttpServlet {

  
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String resMsg = "";
        try {
            double n1 = Double.parseDouble(request.getParameter("num1"));
            double n2 = Double.parseDouble(request.getParameter("num2"));
            String op = request.getParameter("operator");
            double result = 0;
            String symbol = "";
            switch (op) {
                case "add": result = n1 + n2; symbol = "+"; break;
                case "sub": result = n1 - n2; symbol = "-"; break;
                case "mul": result = n1 * n2; symbol = "*"; break;
                case "div":
                if (n2 == 0) {
                        resMsg = "Lỗi: Không thể chia cho 0!";
                    } else {
                        result = n1 / n2;
                        symbol = "/";
                    }
                    break;
                
               }
            if(resMsg.isEmpty()){
                resMsg = n1 + " " + symbol + " " + n2 + " = " + result;
            }
        } catch (Exception e) {
            resMsg = "Vui lòng nhập số hợp lệ!";
        }
        request.setAttribute("message", resMsg);
        request.getRequestDispatcher("result.jsp").forward(request, response);
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
