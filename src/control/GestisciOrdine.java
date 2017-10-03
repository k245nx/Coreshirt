package control;


import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import control.manage.ManageOrdine;

/**
 * Servlet implementation class GestisciOrdine
 */
@WebServlet(name="GestisciOrdine",urlPatterns={"/GestisciOrdine"})
public class GestisciOrdine extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GestisciOrdine() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ManageOrdine mo=new ManageOrdine();
		if(request.getParameter("cambiaStato")!=""){
			if(mo.evadi(request.getParameter("idOrdine")))
				System.out.println("Modificato!");
		}
		if(request.getParameter("dettagli")!=null){
			String ordine=request.getParameter("idOrdine");
			String cliente=request.getParameter("idCliente");
			request.getSession().removeAttribute("listaArticoli");
		    request.getSession().removeAttribute("Cliente");
			request.getSession().setAttribute("listaArticoli",mo.dettagliA(Integer.parseInt(ordine)));
		    request.getSession().setAttribute("Cliente",mo.dettagliC(Integer.parseInt(cliente)));
		}
		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/EvadiOrdine.jsp");
		dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
