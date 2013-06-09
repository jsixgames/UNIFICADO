package br.com.controller;

import br.com.interfaces.ClienteRemote;
import br.com.interfaces.EnderecoRemote;
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

@WebServlet(name = "AdminPanelServlet", urlPatterns = {"/AdminPanelServlet"})
public class AdminPanelServlet extends HttpServlet {
    
    @EJB
    private ClienteRemote cr;
    @EJB
    private EnderecoRemote er;

    protected void processRequest(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        HttpSession session = req.getSession();
        resp.setContentType("text/html;charset=UTF-8");
        PrintWriter out = resp.getWriter();
        try {              
            
            //LISTAR CLIENTES
            if (req.getParameter("item").equals("listaclientes")) {
                try {                    
                    if(session.getAttribute("listacliente") == null) {                        
                       session.setAttribute("listacliente", cr.findAll());
                       req.getRequestDispatcher("paineladmin.jsp").forward(req, resp);                    
                    }                    
                } catch (Exception e) {
                    out.println("Erro na busca de clientes");
                }                
            }
            
            //LISTAR ENDERECOS
            if (req.getParameter("item").equals("listaend")) {
                try {                    
                    if(session.getAttribute("listaend") == null) {                                                                        
                    session.setAttribute("listaend", er.findAll());
                    req.getRequestDispatcher("paineladmin.jsp").forward(req, resp);
                    }                    
                } catch (Exception e) {
                    out.println("Erro na busca de enderecos");
                    e.printStackTrace(out);
                }
            }

            //LOGOUT ADMIN
            if (req.getParameter("item").equals("logoutadm")) {
                 List<Item_Pedido> ip = (List<Item_Pedido>) session.getAttribute("listaitem");
                List<Produto> lp = (List<Produto>) session.getAttribute("listacarrinho");
                int i = 0;
                if (ip != null) {
                    i = ip.size();
                }
                if (session.getAttribute("verificalog") == (Object) true) {
                try {
                    session.invalidate();
                    req.getSession().setAttribute("qtde", i);
                    req.getSession().setAttribute("listacarrinho", lp);
                    req.getSession().setAttribute("listaitem", ip);
                    req.getRequestDispatcher("index.jsp").forward(req, resp);
                } catch (Exception e) {
                }
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
