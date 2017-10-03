package control;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import control.manage.ManageDipendente;
import model.Dipendente;
/**
 * Servlet implementation class ServletDipendente
 */
@WebServlet(name="ServletInserisciDipendente",urlPatterns={"/ServletInserisciDipendente"})

public class ServletInserisciDipendente extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletInserisciDipendente() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
		
				
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
		PrintWriter out=response.getWriter();
		ManageDipendente md=new ManageDipendente();

		
		//inserisci dipendente
		Dipendente d=new Dipendente();
		d.setId(request.getParameter("id"));
		d.setNome(request.getParameter("nome"));
		d.setCognome(request.getParameter("cognome"));
		d.setCodiceFiscale(request.getParameter("codiceFiscale"));
		d.setStipendio(Double.parseDouble(request.getParameter("stipendio")));
		d.setTipo(request.getParameter("tipo"));
		d.setUsername(request.getParameter("username"));
		d.setPassword(request.getParameter("password"));
		if(md.insertDipendente(d)) 
			System.out.println("ok");
		else
			System.out.println("no");
		
		request.getSession().setAttribute("dipendenti", new ManageDipendente().getDipendenti());
		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/InserisciDipendente.jsp");
		dispatcher.forward(request, response);
		


		
	
		
	}

}
