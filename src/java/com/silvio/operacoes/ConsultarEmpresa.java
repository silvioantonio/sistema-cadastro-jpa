package com.silvio.operacoes;

import com.silvio.dao.DaoFactory;
import com.silvio.dominio.Empresa;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author SILVIO
 */
public class ConsultarEmpresa extends HttpServlet {

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
        
        DaoFactory dao = new DaoFactory();
        
        //CONSULTAR EMPRESA POR CIDADE
        //List<Empresa> empresas = dao.getEmpresaDao().JpqlLike("endereco.cidade", "p");
   
        //CONSULTAR EMPRESA POR ESTADO
        //List<Empresa> empresas = dao.getEmpresaDao().JpqlLike("endereco.uf", "ST");
        
        //CONSULTAR EMPRESA POR NOME
        List<Empresa> empresas = dao.getEmpresaDao().JpqlLike("nome", "Hard");

        try (PrintWriter out = response.getWriter()) {
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet ConsultarEmpresa</title>");            
            out.println("</head>");
            out.println("<body>");
            
            for(Empresa empresa: empresas){
                out.println("<h3>Empresa: "+empresa.getNome());
                out.println("<p>Id : "+empresa.getId());
                out.println("<p>CNPJ : "+empresa.getCnpj());
                out.println("<p>Endereço cidade : "+empresa.getEndereco().getCidade());
                out.println("<p>Endereço cep : "+empresa.getEndereco().getCep());
                out.println("<hr/>");
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

}
