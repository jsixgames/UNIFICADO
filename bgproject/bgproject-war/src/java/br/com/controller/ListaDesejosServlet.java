package br.com.controller;

import br.com.interfaces.ClienteRemote;
import br.com.interfaces.ListaDesejoRemote;
import br.com.interfaces.ProdutoRemote;
import br.com.modelos.Cliente;
import br.com.modelos.ListaDesejos;
import br.com.modelos.Produto;
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

@WebServlet(name = "ListaDesejosServlet", urlPatterns = {"/ListaDesejosServlet"})
public class ListaDesejosServlet extends HttpServlet {
    
    @EJB
    private ListaDesejoRemote ldr;
    @EJB
    private ProdutoRemote pr;
    @EJB
    private ClienteRemote cr;

    protected void processRequest(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        HttpSession session = req.getSession();
        resp.setContentType("text/html;charset=UTF-8");
        PrintWriter out = resp.getWriter();
        try {            
            //BUSCANDO O CLIENTE PARA ADICIONAR A LISTA DE DESEJOS
            String email, senha;
            email = (String) session.getAttribute("emailLogado");
            senha = (String) session.getAttribute("senhaLogado");
            Cliente cc = cr.login(email, senha);                                    
            //INSTANCIA DE PRODUTO CRIADA PARA RECEBER O PRODUTO
            Produto p = null;
            ListaDesejos ld = new ListaDesejos();                        
            //RECEBENDO ID DO PRODUTO E BUSCANDO NO BANCO
            try {
                Long id = Long.parseLong(req.getParameter("prod-id"));
                p = pr.find(id);
            } catch (Exception e) {
                out.println("Erro ao pesquisar o cliente no banco de dados");
            }
            
            try {
                if (req.getParameter("listar").equals("show")) {
                    if(cc.getLista().getProduto()!=null){
                    session.setAttribute("listadesejo", cc.getLista().getProduto());
                    req.getRequestDispatcher("listadesejos.jsp").forward(req, resp);
                    }else{
                        if(cc.getLista()==null){
                            List<Produto> lpp = new ArrayList<Produto>();
                            ListaDesejos ldc = new ListaDesejos();
                            ldc.setProduto(lpp);
                            cc.setLista(ldc);
                            cr.edit(cc);
                            session.setAttribute("listadesejo", cc.getLista().getProduto());
                    req.getRequestDispatcher("listadesejos.jsp").forward(req, resp);
                        }
                    }
                }
            } catch (Exception e) {
                out.println("Erro ao setar a lista desejo");
            }
            
            try {
                if (req.getParameter("listar").equals("show2")) {
                    if(cc.getLista().getProduto()!=null){
                    session.setAttribute("listadesejo", cc.getLista().getProduto());
                    req.getRequestDispatcher("wishlist.jsp").forward(req, resp);
                    }else{
                        if(cc.getLista()==null){
                            List<Produto> lpp = new ArrayList<Produto>();
                            ListaDesejos ldc = new ListaDesejos();
                            ldc.setProduto(lpp);
                            cc.setLista(ldc);
                            cr.edit(cc);
                            session.setAttribute("listadesejo", cc.getLista().getProduto());
                    req.getRequestDispatcher("wishlist.jsp").forward(req, resp);
                        }
                    }
                }
            } catch (Exception e) {
                out.println("Erro ao setar a lista desejo");
            }
            
            try {
                if (req.getParameter("btn-desejo").equals("add")) {
                    if (cc.getLista() == null) {
                        List<Produto> list = new ArrayList<Produto>();
                        ld.setProduto(list);
                        cc.setLista(ld);
                        ldr.create(ld);
                        cr.edit(cc);
                    }
                    if(cc.getLista().getProduto().contains(p) == false){                        
                        cc.getLista().getProduto().add(p);
                        ldr.edit(cc.getLista());
                        cr.edit(cc);                        
                        session.setAttribute("jaexiste", 1);
                    }else{
                        session.setAttribute("jaexiste", 0);
                    }                    
                }
                req.getRequestDispatcher("index.jsp").forward(req, resp);
            } catch (Exception e) {
                out.println("Erro ao adicionar um produto na lista de desejos");
            }                                   
            
            try {
                if(req.getParameter("remover").equals("true")){
                    Long id = Long.parseLong(req.getParameter("prod-remove"));
                    Produto pp = pr.find(id);
                    cc.getLista().getProduto().remove(pp);
                    ldr.edit(cc.getLista());
                    cr.edit(cc);
                    session.setAttribute("listadesejo", cc.getLista().getProduto());
                    req.getRequestDispatcher("listadesejos.jsp").forward(req, resp);
                }
            } catch (Exception e) {
                out.println("Erro ao remover produto da lista de desejos");
            }
            
            try {
                
                if(req.getParameter("remover").equals("true2")){                                                     
                    Long id = Long.parseLong(req.getParameter("prod-remove"));
                    Produto pp = pr.find(id);
                    cc.getLista().getProduto().remove(pp);
                    ldr.edit(cc.getLista());
                    cr.edit(cc);
                    session.setAttribute("listadesejo", cc.getLista().getProduto());
                    req.getRequestDispatcher("wishlist.jsp").forward(req, resp);
                }
            } catch (Exception e) {
                out.println("Erro ao remover produto da lista de desejos");
            }
                
        }catch (Exception e){
        out.println("Erro lista de desejos servlet");
        }
        finally {            
            out.close();
        }
    }
//    public boolean verificaLista(ListaDesejos ld, Produto p) {
//        boolean cont = false;
//        List<Produto> list = ld.getProduto();
//        for (int i = 0; i <= list.size(); i++) {
//            if (list.get(i).getId_prod() == p.getId_prod()) {
//                cont = true;
//            }
//        }
//        return cont;
//    }

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
