/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.silvio.operacoes;

import com.silvio.dao.DaoFactory;
import com.silvio.dominio.Candidato;
import com.silvio.dominio.ExperienciaProficional;
import com.silvio.dominio.FormaDeContratacao;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author SILVIO
 */
public class OperacoesExperienciaProfissional extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     * @throws java.text.ParseException
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, ParseException {
        response.setContentType("text/html;charset=UTF-8");
        
        DaoFactory dao = new DaoFactory();
        
        ExperienciaProficional ex = new ExperienciaProficional();
        
        /*ADICIONAR EXPERIENCIA===================================== 
        ex.setCargo("Lava alimentos");
        ex.setDataDeInicio("20/10/2008");
        ex.setDataDeFim("10/06/2011");
        ex.setFormaDeContratacao(FormaDeContratacao.CONTRATO);
        ex.setNomeDaEmpresa("Lava Rapido");
        ex.setTarefasExecutadas("Lavar Legumes");
        dao.getExperienciaDao().add(ex);*/
        
        /*ATUALIZAR EXPERIENCIA======================================
        ex = dao.getExperienciaDao().getExperienciaById(13);
        Candidato candidato = dao.getCandidatoDao().findById(3);
        ex.setCandidato(candidato);
        dao.getExperienciaDao().upd(ex);*/
        
        /*DELETAR EXPERIENCIA=========================================
        dao.getExperienciaDao().del(dao.getExperienciaDao().findById(14));*/
        
        //PEGAR TODAS AS EXPERIENCIAS PROFISSIONAIS===================
        List<ExperienciaProficional> experiencias = dao.getExperienciaDao().listaAll();

        try (PrintWriter out = response.getWriter()) {
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>EX PROF</title>");
            out.println("</head>");
            out.println("<body>");
            experiencias.stream().map((exs) -> {
                out.println("<p>id EXPERIENCIA PROFISSIONAL: "+exs.getId());
                return exs;
            }).map((exs) -> {
                out.println("<p>Nome da Empresa: "+exs.getNomeDaEmpresa());
                return exs;
            }).map((exs) -> {
                out.println("<p>Cargo: "+exs.getCargo());
                return exs;
            }).forEachOrdered((exs) -> {
                out.println("<p>Tarefas executadas: "+exs.getTarefasExecutadas());
                out.println("<p>==================================================");
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
        try {
            processRequest(request, response);
        } catch (ParseException ex) {
            Logger.getLogger(OperacoesExperienciaProfissional.class.getName()).log(Level.SEVERE, null, ex);
        }
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
        try {
            processRequest(request, response);
        } catch (ParseException ex) {
            Logger.getLogger(OperacoesExperienciaProfissional.class.getName()).log(Level.SEVERE, null, ex);
        }
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
