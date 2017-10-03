package control;

import java.io.IOException;
import java.util.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import control.manage.ManageSpesa;
import model.Spesa;

/**
 * Servlet implementation class ServletInsertSpesa
 */
@WebServlet("/ServletInsertSpesa")
public class ServletInsertSpesa extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletInsertSpesa() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        double ammontare=Double.parseDouble(request.getParameter("prezzo"));
        String descrizione=request.getParameter("descrizione");
        Date data=new Date();
        ManageSpesa ms=new ManageSpesa();
        request.setAttribute("inserita",ms.insertSpesa(new Spesa(ammontare, data, descrizione)));
        RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/AggiungiSpesa.jsp");
		dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
