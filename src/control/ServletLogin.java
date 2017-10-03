package control;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.websocket.Session;

import control.manage.ManageArticolo;
import control.manage.ManageDipendente;
import control.manage.ManageRifornimento;
import control.manage.ManageTshirt;

/**
 * Servlet implementation class ServletLogin
 */
@WebServlet("/Login")
public class ServletLogin extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletLogin() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ManageDipendente md=new ManageDipendente();
		String path="";
		if(request.getParameter("logout")!=null){
			request.getSession().setAttribute("adminRoles", new Boolean(false));
			request.getSession().setAttribute("Contabile", new Boolean(false));
			request.getSession().setAttribute("Magazzino", new Boolean(false));
			request.getSession().setAttribute("AdminDip", new Boolean(false));
			request.setAttribute("DipendenteSession",null);
			request.getSession().invalidate();
			RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/login.jsp");
			dispatcher.forward(request, response);
		}
		else{
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		String tipo=new ManageDipendente().checkLogin(username, password);
		request.getSession().removeAttribute("aggiunto");
		if(tipo == null){
			request.getSession().setAttribute("adminRoles", new Boolean(false));
			path="/login.jsp";
		}
		else{
		if(tipo.equals("Contabilita")){
			request.getSession().setAttribute("Contabile", new Boolean(true));
			request.getSession().setAttribute("rifornimenti", new ManageRifornimento().getInevasi());
			path="/HomeContabile.jsp";
		}
		else if(tipo.equals("Magazzino")){
			request.getSession().setAttribute("Magazzino", new Boolean(true));
			try {
				request.getSession().setAttribute("articoli",new ManageArticolo().doRetrieveMen());
			} catch (SQLException e) {
				e.printStackTrace();
			}
			request.getSession().setAttribute("rifornimento", new ManageTshirt().getArticoliS());
			path="/HomeMagazzino.jsp";
		}
		else if(tipo.equals("AdminDip")){
			request.getSession().setAttribute("AdminDip", new Boolean(true));
			request.getSession().setAttribute("dipendenti", new ManageDipendente().getDipendenti());
			path="/HomeDipendenti.jsp";
		}
		}
		request.getSession().setAttribute("DipendenteSession",md.getDipendente(username,password));
		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(path);
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
