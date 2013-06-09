package br.com.controller;

import br.com.interfaces.ClienteRemote;
import br.com.interfaces.PedidoRemote;
import br.com.modelos.Cliente;
import br.com.modelos.Endereco;
import br.com.modelos.Item_Pedido;
import br.com.modelos.Pedido;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "FinalizarCompra", urlPatterns = {"/FinalizarCompra"})
public class FinalizarCompra extends HttpServlet {

    @EJB
    private ClienteRemote cr;
    @EJB
    private PedidoRemote pr;   
    
    protected void processRequest(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        resp.setContentType("text/html;charset=UTF-8");
        PrintWriter out = resp.getWriter();
        try {
//            req.getSession().getAttribute("listaitem")
            String email, senha;
            email = (String) req.getSession().getAttribute("emailLogado");
            senha = (String) req.getSession().getAttribute("senhaLogado");
            Cliente c = cr.login(email, senha);
            if(req.getParameter("evento").equals("ok")){                
                try {                                        
                    req.getSession().setAttribute("clientep", c);
                    List<Endereco> le = c.getEndereco();
                    req.getSession().setAttribute("enderecop", le);
//                    for(Endereco e : le){
//                        if(e.getDescricao().equals("Endereco Principal")){                            
//                            req.getSession().setAttribute("enderecop", e);
//                        }
//                    }
                    req.getRequestDispatcher("confirmacao.jsp").forward(req, resp);
                } catch (Exception e) {
                    out.println("Erro ao redirecionar para a pagina de confirmacao");
                    e.printStackTrace(out);
                }
            }
            
            if(req.getParameter("evento").equals("Escolher")){
                
                    String endentrega = req.getParameter("endentrega");                    
                    List<Endereco> le = c.getEndereco();                    
                for (Endereco e : le) {
                    if (e.getDescricao().equals(endentrega)) {
                        req.getSession().setAttribute("enderecoset", e);
                    }
                }
                   req.getSession().removeAttribute("enderecop"); 
                   req.getRequestDispatcher("confirmacao.jsp").forward(req, resp);
            }
            
            if(req.getParameter("evento").equals("finalizar")){
                List<Item_Pedido> li = null;
                try {
                    if (req.getSession().getAttribute("listaitem") != null) {
                        li = (List<Item_Pedido>) req.getSession().getAttribute("listaitem");
                    } else {
                        out.println("lista vazia");
                    }
                } catch (Exception e) {
                    
                }
                
                double vf = 0.0;
                try {
                vf = Double.parseDouble(req.getParameter("vf"));    
                } catch (Exception e) {
                }
                                
                Date data = new Date(System.currentTimeMillis());
                SimpleDateFormat formatarDate = new SimpleDateFormat("yyyy-MM-dd");
                String datastring = formatarDate.format(data);
                try {
                    data = formatarDate.parse(datastring);
                } catch (ParseException ex) {
                    Logger.getLogger(FinalizarCompra.class.getName()).log(Level.SEVERE, null, ex);
                }
                
                String aux = req.getParameter("formpag");
                int prazo = 0;
                String formpag = null;
                if(aux.equals("1")){
                    formpag = "BOLETO BANCARIO";
                    prazo = 7;
                }else{
                    formpag = "CARTAO DE CREDITO";
                    prazo = 3;
                }
                
                try {
                    Pedido p = new Pedido();
                    p.setData_pedido(data);
                    p.setPrazo_entrega(prazo);
                    p.setForma_pagamento(formpag);
                    p.setStatus_pedido("AGUARDANDO PAGAMENTO");
                    p.setItem(li);
                    p.setTotal_pedido(vf);
                    c.getPedido().add(p);                    
                    cr.edit(c);                             
                    req.getSession().setAttribute("pedidorealizado", 1);                    
                    req.getRequestDispatcher("index.jsp").forward(req, resp);
                } catch (Exception e) {
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
