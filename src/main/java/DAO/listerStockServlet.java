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
import java.sql.Date;

import javax.servlet.ServletException;


/**
 * Servlet implementation class listerStockServlet
 */
@WebServlet("/listerStockServlet")
public class listerStockServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public listerStockServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		StockDaoImpl liStDao = new  StockDaoImpl();
		List<Stock> listearticle = new ArrayList<>();	
		listearticle.addAll(liStDao.read());
		System.out.println(listearticle);
		
		request.setAttribute("listearticle",listearticle);
		request.getRequestDispatcher("/stock.jsp").forward(request, response);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		StockDaoImpl nSDao1 = new  StockDaoImpl();
		String mc =request.getParameter("reference");
		Stock artic = new Stock();
        artic.setReference(mc);
      
        List<Stock>produits=new ArrayList<>();
        produits=nSDao1.getStockParMC(mc);
        request.setAttribute("articles",produits);
        request.getRequestDispatcher("/stock.jsp").forward(request, response);
	
		
		
		
	}





}
