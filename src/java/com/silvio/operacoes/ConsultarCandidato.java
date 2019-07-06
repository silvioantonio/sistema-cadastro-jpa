/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.silvio.operacoes;

import com.silvio.dao.DaoFactory;
import com.silvio.dominio.Candidato;
import com.silvio.dominio.ExperienciaProficional;
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
public class ConsultarCandidato extends HttpServlet {

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
        
        
        //CONSULTAR CANDIDATO POR CARGO
        //List<Candidato> candidatos = dao.getCandDao().getCandidatoByCargo("Atendente");
        
        //CONSULTAR CANDIDATO POR CIDADE
        List<Candidato> candidatos = dao.getCandDao().getCandidatoByCidade("ALMAS");
                
       //CONSULTAR CANDIDATO POR ESTADO
       //List<Candidato> candidatos = dao.getCandDao().getCandidatoByEstado("TO");        
        
       
        try (PrintWriter out = response.getWriter()) {
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet ConsultarCandidato</title>");            
            out.println("</head>");
            out.println("<body>");
            
            for(Candidato candidato: candidatos){
                out.println("<h3>Candidato: "+candidato.getNome());
                out.println("<p>Id : "+candidato.getId());
                out.println("<p>CPF : "+candidato.getCpf());
                out.println("<p>Endereço cidade : "+candidato.getEndereco().getCidade());
                out.println("<p>Endereço cep : "+candidato.getEndereco().getCep());
                out.println("<p>==========================================================");
                for(ExperienciaProficional ex: dao.getExperienciaDao().getExperienciaByCandidato(candidato.getId())){
                    out.println("<p>Cargo EX:"+ex.getCargo());
                    out.println("<p>Nome da Empresa EX:"+ex.getNomeDaEmpresa());
                }
                out.println("<p>==========================================================");
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
