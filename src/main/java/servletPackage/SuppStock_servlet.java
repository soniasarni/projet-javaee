package servletPackage;

import java.io.IOException;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import beans.Stock;

import DAO.StockDaoImpl;

@WebServlet("/SuppStock_servlet")
public class SuppStock_servlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public SuppStock_servlet() {
        super();
    }
 protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
       StockDaoImpl liStDao = new  StockDaoImpl();
    	List<Stock> listearticle = new ArrayList<>();	
		listearticle.addAll(liStDao.read());
		request.setAttribute("listearticle",listearticle);
        //request.getRequestDispatcher("/stock.jsp").forward(request, response);
        String action= request.getParameter("action");
	 
        System.out.println("Dans le Doget de SuppuStock");
	if (action!=null) {
                if (action.equals("supprimer")) {
                int id=Integer.parseInt(request.getParameter("id"));
                liStDao.deleteById(id);
                List<Stock> listearticle1 = new ArrayList<>();
                listearticle.addAll(liStDao.read());
             	request.setAttribute("listearticle",listearticle1);
                  

                }else if(action.equals("modifier")) {
                int id=Integer.parseInt(request.getParameter("id"));
                
			  String ref=request.getParameter("reference");	
			  int qte=Integer.parseInt(request.getParameter("quantite"));
			  System.out.println(id+"moussa");  
			  System.out.println(ref);
			  System.out.println(qte);
			 
               
                request.setAttribute("qte",qte);
                
                request.setAttribute("ref",ref);
                
                Stock sk=new Stock(qte,ref);
                sk.setId(id);
              // Stock sk=new Stock(qte,ref);
               System.out.println(sk+"==="+id);
//                liStDao.Update(sk);
//                List<Stock> listearticle1 = new ArrayList<>();	
//                listearticle.addAll(liStDao.read());
//                request.setAttribute("listearticle",listearticle1);
                //response.sendRedirect("/servletstock");
   
		}
	}
	request.getRequestDispatcher("/stock.jsp").forward(request, response);
	
    }
	
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    }

}
