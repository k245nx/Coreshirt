package control;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import control.manage.ManageArticolo;
import control.manage.ManageRifornimento;
import control.manage.ManageTshirt;
import model.Rifornimento;

/**
 * Servlet implementation class ServletRifornimento
 */
@WebServlet("/ServletRifornimento")
public class ServletRifornimento extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletRifornimento() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		if(request.getParameter("evadi")!=null){
			String idRifornimento=request.getParameter("richiesta");
			new ManageRifornimento().evadi(idRifornimento);
			request.getSession().setAttribute("rifornimenti", new ManageRifornimento().getInevasi());
			RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/HomeContabile.jsp");
			dispatcher.forward(request, response);
		}
		else{
		String idDipendente=request.getParameter("dipendente");
		String articolo=request.getParameter("insertarticolo");
		String sesso=request.getParameter("sesso");
		String taglia=request.getParameter("taglia");
		String colore=request.getParameter("colore");
		String quantita=request.getParameter("quantita");
		Rifornimento r=new Rifornimento(idDipendente,articolo,sesso,taglia,colore,quantita);
	    new ManageRifornimento().insertRifornimento(r);
	    try {
			request.getSession().setAttribute("articoli",new ManageArticolo().doRetrieveMen());
		} catch (SQLException e) {
			e.printStackTrace();
		}
    	request.getSession().setAttribute("rifornimento", new ManageTshirt().getArticoliS());
    	RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/HomeMagazzino.jsp");
		dispatcher.forward(request, response);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
