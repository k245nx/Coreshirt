package control;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import control.manage.ManageDipendente;
import model.Dipendente;

import javax.servlet.RequestDispatcher;

/**
 * Servlet implementation class GestisciDipendente
 */
@WebServlet(name="GestisciDipendente",urlPatterns={"/GestisciDipendente"})
public class GestisciDipendente extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GestisciDipendente() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		ManageDipendente md=new ManageDipendente();
		int id=0;
		int dettagli=0;
		if(request.getParameter("dettagli")!=null){
			dettagli=Integer.parseInt(request.getParameter("dettagli"));
			Dipendente x=md.getDipendente(dettagli);
			request.getSession().removeAttribute("dipendente");
			request.getSession().setAttribute("dipendente",x);
			String tipo=request.getParameter("tipo");
			RequestDispatcher dispatcher;
			if(tipo!=null){
				if(tipo.equals("2")){
					dispatcher = getServletContext().getRequestDispatcher("/ModificaStipendio.jsp");
				}
				else{
					dispatcher = getServletContext().getRequestDispatcher("/PagaStipendi.jsp");	
				}
			}
			else{
				dispatcher = getServletContext().getRequestDispatcher("/RimuoviDipendente.jsp");
			}
			dispatcher.forward(request, response);
		}
		if(request.getParameter("delete")!=null){
			id=Integer.parseInt(request.getParameter("delete"));
			md.deleteDipendente(id);
			request.getSession().setAttribute("dipendenti", new ManageDipendente().getDipendenti());
			RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/HomeDipendenti.jsp");
			dispatcher.forward(request, response);
		}
		if(request.getParameter("dip")!=null){
			int dip=Integer.parseInt(request.getParameter("dip"));
			double stip=Double.parseDouble(request.getParameter("stipendio"));
			md.updateStipendio(dip, stip);
			RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/HomeDipendenti.jsp");
			dispatcher.forward(request, response);
		}
		//response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
		//elimina dipendente
		/*		
		if(request.getParameter("nome")!=""){
			if(md.updateNome(Integer.parseInt(request.getParameter("id")),request.getParameter("nome"))){
				System.out.println("modificato");
			}
		}
		if(request.getParameter("cognome")!=""){
			System.out.println("cognome:"+request.getParameter("cognome"));
			if(md.updateCognome(Integer.parseInt(request.getParameter("id")),request.getParameter("cognome"))){
				System.out.println("modificato");
			}
		}
		if(request.getParameter("cf")!=""){
			if(md.updateCodiceFiscale(Integer.parseInt(request.getParameter("id")),request.getParameter("cf"))){
				System.out.println("modificato");
			}
		}
		if(request.getParameter("stipendio")!=""){
			if(md.updateStipendio(Integer.parseInt(request.getParameter("id")),Double.parseDouble(request.getParameter("stipendio")))){
				System.out.println("modificato");
			}
		}
		if(request.getParameter("tipo")!=""){
			if(md.updateTipo(Integer.parseInt(request.getParameter("id")),request.getParameter("tipo"))){
				System.out.println("modificato");
			}
		}
		if(request.getParameter("username")!=""){
			if(md.updateUsername(Integer.parseInt(request.getParameter("id")),request.getParameter("username"))){
				System.out.println("modificato");
			}
		}
		if(request.getParameter("password")!=""){
			if(md.updatePassword(Integer.parseInt(request.getParameter("id")),request.getParameter("password"))){
				System.out.println("modificato");
			}
		}


		*/

	}
}


