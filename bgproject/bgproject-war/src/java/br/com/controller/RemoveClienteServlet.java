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


@WebServlet(name = "RemoveClienteServlet", urlPatterns = {"/RemoveClienteServlet"})
public class RemoveClienteServlet extends HttpServlet {

    @EJB    
    private ClienteRemote cr;

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession();                    
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        String email = (String)session.getAttribute("emailLogado");
        String senha = (String) session.getAttribute("senhaLogado");
        try {
            Cliente c = null;
            if (request.getParameter("excluir") != null && request.getParameter("excluir").equals("sim")) {
                try {                                                            
                    List<Item_Pedido> ip = (List<Item_Pedido>) session.getAttribute("listaitem");
                    List<Produto> lp = (List<Produto>) session.getAttribute("listacarrinho");
                    int i;
                    if(ip != null){
                    i = ip.size();
                    }else{i = 0;}                    
                    c = cr.login(email, senha);
                    cr.remove(c);
                    session.invalidate();
                    request.getSession().setAttribute("qtde", i);
                    request.getSession().setAttribute("listacarrinho", lp);
                    request.getSession().setAttribute("listaitem", ip);
                  request.getRequestDispatcher("index.jsp").forward(request, response);
                } catch (Exception e) {                                        
                    out.println("Problema ao excluir o usuario, provavel problema no glassfish");
                    e.printStackTrace(out);
//                    request.getRequestDispatcher("painel.jsp").forward(request, response);                    
                } 
            }
            
            if (request.getParameter("excluir") != null && request.getParameter("excluir").equals("nao")){
                    request.getRequestDispatcher("painel.jsp").forward(request, response);
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