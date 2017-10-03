package control;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import control.manage.ManageDipendente;
import control.manage.ManageOrdine;
import control.manage.ManageRifornimento;
import control.manage.ManageSpesa;

/**
 * Servlet implementation class FlussoEconomico
 */
@WebServlet("/FlussoEconomico")
public class FlussoEconomico extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public FlussoEconomico() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String tipo=request.getParameter("tipo");
		String data=new SimpleDateFormat("yyyy-MM-dd").format(new Date());
		request.setAttribute("ListaOrdini", new ManageOrdine().getOrdini());
		request.setAttribute("ListaRichieste", new ManageRifornimento().getOrdini());
		request.setAttribute("ListaStipendi", new ManageDipendente().getStipendiP(data));
		request.setAttribute("ListaSpese", new ManageSpesa().getSpese());
		if(tipo.equals("1")){
			RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/VisualizzaFlussoEconomicoC.jsp");
			dispatcher.forward(request, response);
		}
		else if(tipo.equals("2")){
			RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/VisualizzaFlussoEconomico.jsp");
			dispatcher.forward(request, response);
		}
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
