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
import control.manage.ManageStipendi;

/**
 * Servlet implementation class Paga
 */
@WebServlet("/Paga")
public class PagaStipendi extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PagaStipendi() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String paga=request.getParameter("paga");
		String data=new SimpleDateFormat("yyyy-MM-dd").format(new Date());
		if(paga!=null){
		if(paga.equals("tutti")){
			new ManageStipendi().inserisciStipendiP(new ManageDipendente().getDipendenti(), data);
			RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/HomeContabile.jsp");
			dispatcher.forward(request, response);
		}
		else{
			if(request.getParameter("dipendente")!=null){
				String d=request.getParameter("dipendente");
				double stip=new ManageDipendente()
						.getDipendente(Integer.parseInt(d)).getStipendio();
				new ManageStipendi().inserisciStipendiP(d, data, stip);
				RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/PagaStipendi.jsp");
				dispatcher.forward(request, response);
			}
		}
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
