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
        String action= request.getParameter("action");
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
			    
			    request.setAttribute("qte",qte);
                request.setAttribute("ref",ref);
              //  Stock sk=new Stock(qte,ref);
                
//                sk.setId(id);
//                sk.setReference(ref);
//                sk.setQuantite(qte);
                //liStDao.modifier(qte,ref);
              }
	    }
	request.getRequestDispatcher("/stock.jsp").forward(request, response);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		    String ref=request.getParameter("reference");	
		    int qte=Integer.parseInt(request.getParameter("quantite"));
		   // int id=Integer.parseInt(request.getParameter("id"));
		    //le mettre dans ma base de données
		    StockDaoImpl nSDao = new  StockDaoImpl();
		    Stock article = new Stock(qte,ref);
				nSDao.modifier(article) ;
					 request.setAttribute("message", " L'article a bien été modifier");
					 request.getRequestDispatcher("/stock.jsp").forward(request, response);
				System.out.println();
    }
	

}
