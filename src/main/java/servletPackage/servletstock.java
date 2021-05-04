package servletPackage;

import java.io.IOException;



import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import DAO.StockDaoImpl;

import beans.Stock;


@WebServlet("/servletstock")
public class servletstock extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
    public servletstock() {
        super();
      
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		String ref= request.getParameter("reference");
//		int qte=Integer.parseInt(request.getParameter("quantite"));	 
//	    request.getRequestDispatcher("/stock.jsp").forward(request, response);
//		
//	     //init le moteur session
//		HttpSession session = request.getSession();
//		//stocker en memoire 		
//	    session.setAttribute("paramtttre",qte + ref);
//	    //Delete
//		StockDaoImpl liStDao = new  StockDaoImpl();
//		Stock nArt= new Stock(qte,ref);
//		liStDao.r�cup�r�(nArt);
//		  request.setAttribute("paramettre",qte+ ref);
////			 //FOWARD � LA JSP
			this.getServletContext().getRequestDispatcher("/stock.jsp").forward(request,response);	
// �      
//    
			}
		
 protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String ref= request.getParameter("reference");
		int qte=Integer.parseInt(request.getParameter("quantite")) ;
			
		//le mettre dans ma base de donn�es
		 StockDaoImpl nSDao = new  StockDaoImpl();
	     Stock article = new Stock(qte,ref);
			if(nSDao.ajout(article)) {
				 request.setAttribute("message", " L'article a bien �t� ajout�");
				 request.getRequestDispatcher("/stock.jsp").forward(request, response);
			}else {
				request.setAttribute("message1", "Oups, erreur ");
				request.getRequestDispatcher("/stock.jsp").forward(request, response);
			}
			
			
		}
			
		}