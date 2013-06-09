package br.com.controller;

import br.com.interfaces.CarrinhoRemote;
import br.com.interfaces.Item_PedidoRemote;
import br.com.interfaces.PedidoRemote;
import br.com.interfaces.ProdutoRemote;
import br.com.modelos.Item_Pedido;
import br.com.modelos.Pedido;
import br.com.modelos.Produto;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet(name = "CarrinhoServlet", urlPatterns = {"/CarrinhoServlet"})
public class CarrinhoServlet extends HttpServlet {
    
    @EJB
    private CarrinhoRemote cart;    
    @EJB
    private ProdutoRemote pr;
    @EJB
    private PedidoRemote pedr;
    
    protected void processRequest(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        HttpSession session = req.getSession();
        resp.setContentType("text/html;charset=UTF-8");
        PrintWriter out = resp.getWriter();
        try {
                 if((session.getAttribute("listaitem")==null)){
                 List<Item_Pedido> prim = new ArrayList<Item_Pedido>();
                 session.setAttribute("listaitem", prim);
                 cart.getItems().clear();
                 }                 
                 List<Item_Pedido> items = (List<Item_Pedido>) session.getAttribute("listaitem");
                                     
                 
            try {                            
             if(req.getParameter("btn-comprar").equals("comprar1") ||
             req.getParameter("btn-comprar").equals("comprar2")){                       
                 //set id e busca produto
                 Long id = Long.parseLong(req.getParameter("prod-id"));                 
                 Produto p = pr.find(id);                                                       
                 
                 try {
                     if (cart.getItems().isEmpty() || cart.getItems().contains(p) == false) {                         
                         cart.addItem(p);
                         Item_Pedido ip = new Item_Pedido();
                         ip.setProduto(p);
                         ip.setPreco_unidade(p.getPreco());
                         ip.setQtd(1);
                         ip.setPreco_total(ip.getQtd() * ip.getPreco_unidade());                                                  
                         items.add(ip);                                                  
                         session.setAttribute("listaitem", items);
                         session.setAttribute("sitcart", 0);                         
                     }else{
                         if(cart.getItems().contains(p)){
                             session.setAttribute("sitcart", 1);
                         }
                     }
                     
                 } catch (Exception e) {
                     out.println("Erro ao adicionar item no carrinho");
                 }                                  
                                  
                 session.setAttribute("qtde", items.size());
                 session.setAttribute("listacarrinho", cart.getItems());
                 req.getRequestDispatcher("index.jsp").forward(req, resp);
            }                
            } catch (Exception e) {
                out.println("Erro ao adicionar produto no carrinho");
            }
            
            try {
                if (req.getParameter("mostrar").equals("1")) {                    
                    req.getRequestDispatcher("carrinho.jsp").forward(req, resp);
                }
            } catch (Exception e) {
                out.println("Erro ao redirecionar para a pagina do carrinho");
            }
            
            try {
                if (req.getParameter("evento").equals("atualiza")) {
                    int i = Integer.parseInt(req.getParameter("item-id"));
                    int qtd = Integer.parseInt(req.getParameter("qtdenova"));
                    Item_Pedido ipx = items.get(i);
                    ipx.setQtd(qtd);
                    ipx.setPreco_total(ipx.getQtd()*ipx.getPreco_unidade());
                    items.set(i, ipx);
                    session.setAttribute("listaitem", items);
                    req.getRequestDispatcher("carrinho.jsp").forward(req, resp);
                }
                if(req.getParameter("evento").equals("remover")){
                    int i = Integer.parseInt(req.getParameter("item-id"));
                    Produto px = items.get(i).getProduto();
                    cart.removeItem(px);
                    items.remove(i);
                    session.setAttribute("listaitem", items);
                    session.setAttribute("qtde", items.size());                    
                    req.getRequestDispatcher("carrinho.jsp").forward(req, resp);
                }
                
            } catch (Exception e) {
                out.println("Erro remover ou atualizar");
            }
             
        } catch (Exception e) {
            out.println("Erro no servlet do carrinho de compras");
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
