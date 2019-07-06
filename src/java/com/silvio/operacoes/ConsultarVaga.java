package com.silvio.operacoes;

import com.silvio.dao.DaoFactory;
import com.silvio.dominio.Empresa;
import com.silvio.dominio.Vaga;
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
public class ConsultarVaga extends HttpServlet {

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
        
        //CONSULTAR VAGA POR EMPRESA
        /*Empresa empresa = dao.getEmpresaDao().findById(1);
        List<Vaga> vagas = dao.getVagaDao().getVagasByIdEmpresa(1);*/
        
        //CONSULTAR VAGA POR CARGO
        List<Vaga> vagas = dao.getVagaDao().getVagasByCargo("Suporte");
        
        //CONSULTAR VAGA POR CIDADE
        //List<Vaga> vagas = dao.getVagaDao().getVagasByCidade("Goiania");
        
        //CONSULTAR VAGA POR ESTADO
        //List<Vaga> vagas = dao.getVagaDao().getVagasByEstado("GO");

        
        
        try (PrintWriter out = response.getWriter()) {
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet ConsultarVaga</title>");            
            out.println("</head>");
            out.println("<body>");
            //out.println("<h1>Vagas disponiveis na empresa: "+empresa.getNome()+"</h1>");
            for (Vaga vaga : vagas) {
                out.println("<p>Id Vaga: " + vaga.getId());
                out.println("<p>Cargo : " + vaga.getCargo());
                out.println("<p>Especificaçao da vaga: " + vaga.getEspecificacaoDeCargo());
                out.println("<p>Comentarios da vaga: " + vaga.getOutro());
                out.println("<p>Valor da vaga: " + vaga.getRemuneracao());
                out.println("<p>Turno: " + vaga.getTurno());
                out.println("<p>===============================");

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
