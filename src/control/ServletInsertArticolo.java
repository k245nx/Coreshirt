package control;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import org.apache.tomcat.util.http.fileupload.IOUtils;

import control.manage.ManageArticolo;
import control.manage.ManageRifornimento;
import control.manage.ManageTshirt;
import model.Articolo;
import model.Rifornimento;
import model.TShirt;

/**
 * Servlet implementation class ServletInsertArticolo
 */
@WebServlet("/ServletInsertArticolo")
@MultipartConfig
public class ServletInsertArticolo extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletInsertArticolo() {
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
		
		ManageArticolo ma=new ManageArticolo();
		if(request.getParameter("rifornimento")!=null){
			if(request.getParameter("insertNome")!=""&&request.getParameter("insertCategoria")!=""&&request.getParameter("insertPrezzo")!=""&&request.getParameter("insertQuantita")!=""){
				Articolo a=new Articolo(request.getParameter("insertNome"),12,0,request.getParameter("insertCategoria"));
				int num;
				if((num=ma.insertArticolo(a))>0) System.out.println("Inserimento effettuato");
				else System.out.println("Inserimento non effettuato");
				TShirt t= new TShirt(ma.getArticolo(num),request.getParameter("sesso"),request.getParameter("taglia"),request.getParameter("colore"),Integer.parseInt(request.getParameter("insertQuantita")));
				new ManageTshirt().insertTshirt(t);
				ma.updateQuantita(""+num, ma.getQuantita(num)+t.getquantita());
				int idDipendente=Integer.parseInt(request.getParameter("id"));
				Rifornimento r=new Rifornimento(""+idDipendente,""+num, request.getParameter("sesso"),request.getParameter("taglia"),request.getParameter("colore"),request.getParameter("insertQuantita"));
				new ManageRifornimento().insertRifornimento(r,"evaso");
				try {
					request.getSession().setAttribute("articoli",new ManageArticolo().doRetrieveMen());
				} catch (SQLException e) {
					e.printStackTrace();
				}
		    	request.getSession().setAttribute("rifornimento", new ManageTshirt().getArticoliS());
		    	RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/OrdinaProdotto.jsp");
				dispatcher.forward(request, response);
			}
		}
		else{
		if(request.getParameter("insertNome")!=""&&request.getParameter("insertCategoria")!=""&&request.getParameter("insertPrezzo")!=""&&request.getParameter("insertQuantita")!=""){
			Articolo a=new Articolo(request.getParameter("insertNome"),Double.parseDouble(request.getParameter("insertPrezzo")),0,request.getParameter("insertCategoria"));
			int num;
			if((num=ma.insertArticolo(a))>0) System.out.println("Inserimento effettuato");
			else System.out.println("Inserimento non effettuato");
			if(request.getPart("upfile")!=null)
			   {Upload(request.getPart("upfile"),num);}
			if(request.getPart("anteprima")!=null)
			   {Upload(request.getPart("anteprima"),num,request.getParameter("sesso"));}
			TShirt t= new TShirt(ma.getArticolo(num),request.getParameter("sesso"),request.getParameter("taglia"),request.getParameter("colore"),Integer.parseInt(request.getParameter("insertQuantita")));
			new ManageTshirt().insertTshirt(t);
			ma.updateQuantita(""+num, ma.getQuantita(num)+t.getquantita());
			request.setAttribute("aggiunto", "Articolo aggiunto");
			try {
				request.getSession().setAttribute("articoli",new ManageArticolo().doRetrieveMen());
			} catch (SQLException e) {
				e.printStackTrace();
			}
	    	request.getSession().setAttribute("rifornimento", new ManageTshirt().getArticoliS());
	    	RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/InserisciProdotto.jsp");
			dispatcher.forward(request, response);
			}
		}
	}

	private void Upload(Part filePart,int num) {
		String fileName = filePart.getSubmittedFileName(); // fileName è un oggetto di tipo String
        InputStream is;
		try {
			is = filePart.getInputStream();
			String fileExt = fileName.substring(fileName.lastIndexOf(".")); // fileExt è un oggetto di tipo String
	        String destinationPath = getServletContext().getInitParameter("filepath") +num+fileExt;
	        OutputStream os = new FileOutputStream(destinationPath);
			IOUtils.copy(is, os);
			is.close();
	        os.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	private void Upload(Part filePart,int num,String str) {
        InputStream is;
		try {
			is = filePart.getInputStream();
			String destinationPath="";
			if(str.equals("M")){
				destinationPath = getServletContext().getInitParameter("filepath") +"Maglietta("+num+").jpg";
			}
			else{
				destinationPath = getServletContext().getInitParameter("filepath") +"Maglietta("+num+")F.jpg";	
			}
	        OutputStream os = new FileOutputStream(destinationPath);
			IOUtils.copy(is, os);
			is.close();
	        os.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
