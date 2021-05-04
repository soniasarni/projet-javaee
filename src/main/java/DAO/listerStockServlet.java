package DAO;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import beans.Stock;



@WebServlet("/listerStockServlet")
public class listerStockServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public listerStockServlet() {
        super();
        
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		StockDaoImpl liStDao = new StockDaoImpl();
		List<Stock> listearticle = new ArrayList<>();	
		listearticle.addAll(liStDao.read());
		request.setAttribute("listearticle",listearticle);
		request.getRequestDispatcher("/stock.jsp").forward(request, response);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String mc =request.getParameter("reference");
		Stock artic = new Stock();
		StockDaoImpl nSDao1 = new  StockDaoImpl();
        artic.setReference(mc);
        List<Stock>produits=new ArrayList<>();
        produits=nSDao1.getStockParMC(mc);
        
		
        request.setAttribute("articles",produits);
        request.getRequestDispatcher("/stock.jsp").forward(request, response);
   }
}
