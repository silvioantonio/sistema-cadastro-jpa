/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.silvio.operacoes;

import com.silvio.dao.DaoFactory;
import com.silvio.dao.IDaoGenerico;
import com.silvio.dominio.Acesso;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import java.util.function.Consumer;
import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author SILVIO
 */
public class OperacoesAcesso extends HttpServlet {

    
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
        Acesso acesso = new Acesso();
        
        /*ADICIONAR ACESSO======================================================
        acesso.setEmail("emprea20.tel@empresa.com");
        acesso.setLogin("Novo");
        acesso.setSenha("Novo");
        acesso.setReceberNoticia(false);
        dao.getAcessoDao().add(acesso);*/
        
        /*ATUALIZAR ACESSO======================================================
        acesso = dao.getAcessoDao().findById(13);
        acesso.setLogin("novoemail");
        dao.getAcessoDao().upd(acesso);*/
        
        /*DELETAR ACESSO========================================================
        acesso = acesso = dao.getAcessoDao().findById(13);
        dao.getAcessoDao().del(acesso);*/
        
        //MOSTRAR ACESSOS=======================================================
        List<Acesso> acessos = dao.getAcessoDao().listaAll();

        try (PrintWriter out = response.getWriter()) {
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Operaçoes Acesso</title>");
            out.println("</head>");
            out.println("<body>");
            acessos.stream().map((acesso1) -> {
                out.println("<p>ID de Acesso: "+acesso1.getId());
                return acesso1;
            }).forEachOrdered((Acesso acesso1) -> {
                out.println("<p>Login de Acesso: " + acesso1.getLogin());
                out.println("<p>===============================================");
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
