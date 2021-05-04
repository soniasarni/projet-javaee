package servletPackage;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import DAO.StockDaoImpl;
import beans.Stock;


@WebServlet("/modifStock_servlet")
public class modifStock_servlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    public modifStock_servlet() {
        super();
       
    }
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		StockDaoImpl liStDao = new  StockDaoImpl();
		List<Stock> listearticle = new ArrayList<>();	
		listearticle.addAll(liStDao.read());
		request.setAttribute("listearticle",listearticle);
		request.getRequestDispatcher("/stock.jsp").forward(request, response);
		}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String ref= request.getParameter("reference");
		Integer qte=Integer.parseInt(request.getParameter("quantite"));	 
	    request.getRequestDispatcher("/stock2.jsp").forward(request, response);
		
	     //init le moteur session
		HttpSession session = request.getSession();
		//stocker en memoire 		
	    session.setAttribute("paramtttre",qte + ref);
	    //Delete
		StockDaoImpl liStDao = new  StockDaoImpl();
		Stock nArt= new Stock(qte,ref);
		liStDao.Update(nArt);
		
        request.getRequestDispatcher("/stock2.jsp").forward(request, response);
    
			}
	
}


