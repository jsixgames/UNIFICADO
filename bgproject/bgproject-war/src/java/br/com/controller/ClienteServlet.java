package br.com.controller;

import br.com.interfaces.ClienteRemote;
import br.com.modelos.Cliente;
import br.com.modelos.Endereco;
import br.com.modelos.MetodosGerais;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet(name = "CadastroClienteServlet", urlPatterns = {"/CadastroClienteServlet"})
public class ClienteServlet extends HttpServlet {

    @EJB
    private ClienteRemote clienteRemote;

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession();                    
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        try {
            
            if (request.getParameter("btn_cadastrar") != null && 
                request.getParameter("btn_cadastrar").equals("Cadastrar")) {
                try {
                    Cliente c = new Cliente();
                    Endereco endereco = new Endereco();
                
                    c.setNome(request.getParameter("nome"));
                    c.setCpf(new MetodosGerais().tirardotecoma(request.getParameter("cpf")));            
                    c.setSexo(request.getParameter("sexo"));                    
                    c.setEmail(request.getParameter("email"));
                    c.setSenha(request.getParameter("senha"));

                    endereco.setEndereco(request.getParameter("endereco"));
                    endereco.setCep(new MetodosGerais().tirardotecoma(request.getParameter("cep")));                    
                    endereco.setCidade(request.getParameter("cidade"));                                        
                    endereco.setDescricao("Endereco Principal");
                    
                    List<Endereco> end = new ArrayList<Endereco>();
                    end.add(endereco);
                    c.setEndereco(end);                    
                    
                    clienteRemote.create(c);

                    session.setAttribute("user", request.getParameter("nome"));
                    request.getRequestDispatcher("respcadok.jsp").forward(request, response);    
                    
                    
                } catch (Exception e) {
                    request.getRequestDispatcher("respcadfail.jsp").forward(request, response);
                }                
            }                        
        } finally {
            out.close();
        }
    }
    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP
     * <code>GET</code> method.
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
     * Handles the HTTP
     * <code>POST</code> method.
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