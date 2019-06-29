package com.silvio.operacoes;

import com.silvio.dao.DaoFactory;
import com.silvio.dao.IDaoGenerico;
import com.silvio.dominio.Candidato;
import com.silvio.dominio.EstadoCivil;
import com.silvio.dominio.Rg;
import com.silvio.dominio.Sexo;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author SILVIO
 */
public class InserirCandidato extends HttpServlet {

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

        Candidato candidato = new Candidato();
        candidato.setCpf(111111111);
        candidato.setNome("Julia Batista");
        candidato.setSexo(Sexo.FEMININO);
        candidato.setEstadoCivil(EstadoCivil.CASADO);

        Rg rg = new Rg();
        try {
            rg.setDataExpedicao("10/12/2010");
        } catch (ParseException ex) {
            Logger.getLogger(InserirCandidato.class.getName()).log(Level.SEVERE, null, ex);
        }
        rg.setNumeroRg(817337);
        rg.setOrgaoExpeditor("SSP");
        rg.setUfExpedicao("TO");
        
        DaoFactory dao = new DaoFactory();
        
        dao.getCandidatoDao().add(candidato);

        List<Candidato> candidatos = dao.getCandidatoDao().listaAll();

        try (PrintWriter out = response.getWriter()) {
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet InserirCandidato</title>");
            out.println("</head>");
            out.println("<body>");
            candidatos.forEach((candidato1) -> {
                out.println("<p>Candidato" + candidato1.getNome());
            });
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
