package br.com.controller;

import br.com.interfaces.ClienteRemote;
import br.com.interfaces.PedidoRemote;
import br.com.modelos.Cliente;
import br.com.modelos.Item_Pedido;
import br.com.modelos.Pedido;
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

@WebServlet(name = "PedidosServlet", urlPatterns = {"/PedidosServlet"})
public class PedidosServlet extends HttpServlet {

    @EJB
    private PedidoRemote pr;
    @EJB
    private ClienteRemote cr;
    
    protected void processRequest(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        resp.setContentType("text/html;charset=UTF-8");
        PrintWriter out = resp.getWriter();
        try {
            if(req.getParameter("evento").equals("listar")){
                String email, senha;
                email = (String) req.getSession().getAttribute("emailLogado");
                senha = (String) req.getSession().getAttribute("senhaLogado");
                Cliente c = cr.login(email, senha);                
//                List<Pedido> lp = null;
                try {
                    req.getSession().setAttribute("listapedidos", c.getPedido());
                    req.getRequestDispatcher("pedidos.jsp").forward(req, resp);
                } catch (Exception e) {
                    out.println("Erro ao pegar a lista de pedidos do cliente");
                }                
            }
            
            if(req.getParameter("evento").equals("listarAdmin")){
                try {
                    req.getSession().setAttribute("listapedidos2", pr.findAll());
                    req.getRequestDispatcher("paineladmin.jsp").forward(req, resp);
                } catch (Exception e) {
                    out.println("Erro ao pegar todos os pedidos");
                }
            }
            
            if(req.getParameter("evento").equals("atualizar")){
                try {
                    int i = Integer.parseInt(req.getParameter("id-ped"));
                    String status = req.getParameter("status");
                    List<Pedido> lp = (List<Pedido>) req.getSession().getAttribute("listapedidos2");
//                    List<Item_Pedido> ip = (List<Item_Pedido>) req.getSession().getAttribute("listaitem");
//                    req.getSession().setAttribute("listaitem", ip);
                    Pedido p = lp.get(i);
                    p.setStatus_pedido(status);                                  
                    pr.edit(p);                        
                    req.getSession().removeAttribute("listapedidos2");
                    req.getRequestDispatcher("PedidosServlet?evento=listarAdmin").forward(req, resp);
//                    req.getSession().setAttribute("listapedidos2",pr.findAll());
                } catch (Exception e) {
                    out.println("erro atualizar");
                    e.printStackTrace(out);
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
