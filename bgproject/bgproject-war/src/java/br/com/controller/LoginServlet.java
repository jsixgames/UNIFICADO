package br.com.controller;

import br.com.interfaces.ClienteRemote;
import br.com.modelos.Cliente;
import br.com.modelos.Item_Pedido;
import br.com.modelos.Produto;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet(name = "LoginServlet", urlPatterns = {"/LoginServlet"})
public class LoginServlet extends HttpServlet {

    private boolean logado = false;
    @EJB
    private ClienteRemote cr;
    
   
    @SuppressWarnings("empty-statement")
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession();
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();                
        try {            
            if (request.getParameter("btn_login") != null && request.getParameter("btn_login").equals("Logar")) {
                try {
                    //instancias
                    String email,senha;
                    email = request.getParameter("email").toLowerCase();
                    senha = request.getParameter("senha").toLowerCase();                    
                    Cliente c;
                    
                    //login Administrador
                    try {
                        if (email.equals("admin@admin.com") && senha.equals("admin")) {
                            logado = true;
                            session.setAttribute("verificalog", isLogado());
                            request.getRequestDispatcher("paineladmin.jsp").forward(request, response);
                        } 
                    } catch (Exception e) {
                        out.println("Erro login administrador");
                    }
                    
                    //Login do cliente
                    try {            
                         c = cr.login(email, senha);
                            if (c == null) {
                            request.getRequestDispatcher("loginError.jsp").forward(request, response);
                        } else {
                            logado = true;
                            session.setAttribute("username", c.getNome());
                            session.setAttribute("emailLogado", email);
                            session.setAttribute("senhaLogado", senha);
                            session.setAttribute("verificalog", isLogado());
                            request.getRequestDispatcher("index.jsp").forward(request, response);
                        }                                                        
                    } catch (Exception e) {
                    request.getRequestDispatcher("loginError.jsp").forward(request, response);
                    }
                        
                    
                    session.setAttribute("verificalog", isLogado());                        
                    
                } catch (Exception e) {
                    out.println("Erro no loginServlet");
                }
            }
            
            if (request.getParameter("btn_logout") != null && request.getParameter("btn_logout").equals("Logout")) {
                try {                   
                    
                        List<Item_Pedido> ip = (List<Item_Pedido>) session.getAttribute("listaitem");
                        List<Produto> lp = (List<Produto>) session.getAttribute("listacarrinho");                        
                        int i = 0;                        
                        if(ip!=null){
                        i = ip.size();                        
                        }
                    if (session.getAttribute("verificalog") == (Object) true) {                                                
                        try {
                            session.invalidate();                                               
                        request.getSession().setAttribute("qtde", i);                        
                        request.getSession().setAttribute("listacarrinho", lp);
                        request.getSession().setAttribute("listaitem", ip);                       
                        request.getRequestDispatcher("index.jsp").forward(request, response);
                        } catch (Exception e) {
                        }                        
                    }
                } catch (Exception e) {
                    out.println("Erro no loginServlet 2");
                    e.printStackTrace(out);
                } finally {
                    out.close();
                }
            }
        } finally {
            out.close();
        }
    }

    public boolean isLogado() {
        return logado;
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
