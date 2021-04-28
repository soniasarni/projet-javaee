package servletPackage;

import java.io.IOException;
import java.sql.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import DAO.StockDaoImpl;

import beans.Stock;


/**
 * Servlet implementation class servletstock
 */
@WebServlet("/servletstock")
public class servletstock extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public servletstock() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("/stock.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String ref= request.getParameter("reference");
		Integer qte=Integer.parseInt(request.getParameter("quantite")) ;
		
		
//		
		//le mettre dans ma base de données
		 StockDaoImpl nSDao = new  StockDaoImpl();
		
		Stock article = new Stock(qte,ref);
			
			
			
			if(nSDao.ajout(article)) {
				
				 request.setAttribute("message", "bravo, votre article a bien été ajouté");
				 request.getRequestDispatcher("/stock.jsp").forward(request, response);
				
			}else {
				request.setAttribute("message1", "Oups, erreur ");
				request.getRequestDispatcher("/stock.jsp").forward(request, response);
			}
			
			
		}
			
		}