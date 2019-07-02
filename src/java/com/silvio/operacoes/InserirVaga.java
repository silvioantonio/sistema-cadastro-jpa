package com.silvio.operacoes;

import com.silvio.dao.DaoFactory;
import com.silvio.dao.IDaoGenerico;
import com.silvio.dominio.Empresa;
import com.silvio.dominio.FormaDeContratacao;
import com.silvio.dominio.Turno;
import com.silvio.dominio.Vaga;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author SILVIO
 */
public class InserirVaga extends HttpServlet {

    
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
        
        Vaga vaga = new Vaga();
        vaga.setCargo("Suporte ");
        vaga.setEspecificacaoDeCargo("Fazer tudo e mais um pouco");
        vaga.setFormaDeContratacao(FormaDeContratacao.CLT);
        vaga.setRemuneracao(1050.00);
        vaga.setTurno(Turno.MATUTINO);
        vaga.setUf("TO");
        vaga.setValeRefeicao(true);
        vaga.setValeTransporte(true);
        vaga.setOutro("Recebe mais trabalho");
        
        DaoFactory dao = new DaoFactory();
        
        Empresa empresa = dao.getEmpresaDao().findById(1);

        vaga.setEmpresa(empresa);
        
        dao.getVagaDao().add(vaga);
        List<Vaga> vagas = empresa.getVagas();
        vagas.add(vaga);
        empresa.setVagas(vagas);
        dao.getEmpresaDao().upd(empresa);
        
        try (PrintWriter out = response.getWriter()) {
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet InserirVaga</title>");            
            out.println("</head>");
            out.println("<body>");
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
