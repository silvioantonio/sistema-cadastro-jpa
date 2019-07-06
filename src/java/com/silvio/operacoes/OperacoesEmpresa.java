package com.silvio.operacoes;

import com.silvio.dao.DaoFactory;
import com.silvio.dominio.Empresa;
import com.silvio.dominio.Endereco;
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
public class OperacoesEmpresa extends HttpServlet {
    
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
        Empresa empresa = new Empresa();
        
        /*INSERIR EMPRESA====================================
        empresa.setAreaDeAtuacao("Panificaçao");
        empresa.setCnpj(1234000112);
        empresa.setNome("Pao Divino");
        
        Endereco endereco = new Endereco();
        endereco.setCep(270000);
        endereco.setCidade("goiania");
        endereco.setNumero(2);
        endereco.setUf("GO");
        empresa.setEndereco(endereco);
        dao.getEmpresaDao().add(empresa);*/
        
        
        /*ATUALIZAR EMPRESA===================================
        empresa = dao.getEmpresaDao().findById(1);
        empresa.setCnpj(01010101);
        dao.getEmpresaDao().upd(empresa);*/
        
        /*DELETAR EMPRESA=====================================
        empresa = dao.getEmpresaDao().findById(13);
        dao.getEmpresaDao().del(empresa);*/
        
        //MOSTRAR EMPRESAS====================================
        List<Empresa> empresas = dao.getEmpresaDao().listaAll();
            
        try (PrintWriter out = response.getWriter()) {
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet Inserir</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Empresa Cadastradas</h1>");
            empresas.stream().map((emp) -> {
                out.println("<p>Id: "+emp.getId());
                return emp;
            }).map((emp) -> {
                out.println("<p>Area de Atuaçao: "+emp.getAreaDeAtuacao());
                return emp;
            }).map((emp) -> {
                out.println("<p>CNPJ: "+emp.getCnpj());
                return emp;
            }).map((Empresa emp) -> {
                out.println("<p>CEP: "+emp.getEndereco().getCep());
                return emp;
            }).map((Empresa emp) -> {
                out.println("<p>Cidade: "+emp.getEndereco().getCidade());
                return emp;
            }).map((emp) -> {
                out.println("<p>UF: "+emp.getEndereco().getUf());
                return emp;
            }).map((emp) -> {
                out.println("<p>Nome da Empresa: "+emp.getNome());
                return emp;
            }).map((emp) -> {
                out.println("<p>Login de Acesso: "+emp.getAcesso().getEmail());
                return emp;
            }).map((emp) -> {
                out.println("<p>Senha de Acesso: "+emp.getAcesso().getSenha());
                return emp;
            }).map((emp) -> {
                out.println("<p>Email Corporativo: "+emp.getAcesso().getEmail());
                return emp;
            }).map((emp) -> {
                out.println("<p>Vagas : "+emp.getVagas().size());
                return emp;
            }).forEachOrdered((_item) -> {
                out.println("<hr>");
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
