package control;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import org.apache.tomcat.util.http.fileupload.IOUtils;

import control.manage.DatabaseConnection;
import control.manage.ManageArticolo;
import control.manage.ManageCarrello;
import control.manage.ManageOrdine;
import control.manage.ManageTshirt;
import model.Cart;
import model.TShirt;

/**
 * Servlet implementation class DbShow
 */
@MultipartConfig
public class Controller extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private static DatabaseConnection model=new DatabaseConnection();
    private static ManageArticolo art= new ManageArticolo();
    private static int i=(new ManageOrdine()).getI();
	
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Controller() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Cart cart = (Cart)request.getSession().getAttribute("cart");
		request.getSession().removeAttribute("cat");
		request.getSession().setAttribute("cat",0);
		if(cart == null) {
			cart = new Cart();
			request.getSession().setAttribute("cart", cart);
		}
		String action = request.getParameter("action");
		String path="/Home.jsp"; 
		try {
			if (action != null) {
				if (action.equalsIgnoreCase("dettagli")) {
					int id = Integer.parseInt(request.getParameter("id"));
					String sesso=(String)request.getParameter("sesso");
					request.removeAttribute("product");
					request.setAttribute("product", art.doRetrieveByKey(id,sesso));
					path="/dettagli.jsp";
			    }
				else if(action.equalsIgnoreCase("disponibilita")){
			    	int id = Integer.parseInt(request.getParameter("id"));
					String sesso=(String)request.getParameter("sesso");
					String nome=(String)request.getParameter("nome");
					String colore=(String)request.getParameter("color");
					String taglia=(String)request.getParameter("taglia");
					int prezzo = Integer.parseInt(request.getParameter("prezzo"));
					System.out.println("p");
					int quantity = Integer.parseInt(request.getParameter("quantity"));
				    TShirt th=new TShirt(id, sesso, nome, colore, taglia, prezzo, quantity);
			    	ArrayList<TShirt> ts=new ManageTshirt().getTshirts();
					int quantita=ts.get(ts.lastIndexOf(th)).getquantita();
					request.getSession().setAttribute("disponibilita",quantita);
					request.removeAttribute("product");
					request.setAttribute("product", art.doRetrieveByKey(id,sesso));
					path="/dettagli.jsp";
			    }
				else if(action.equalsIgnoreCase("Uomo")){
					request.getSession().setAttribute("all", 1);
					if(request.getParameter("categoria")!=null){
						request.getSession().setAttribute("cat",1);
					}
					else{
					    request.getSession().setAttribute("cat",0);}
					path="/HomeUomo.jsp";
				}
				else if(action.equalsIgnoreCase("Donna")){
					request.getSession().setAttribute("all", 1);
					if(request.getParameter("categoria")!=null){
						request.getSession().setAttribute("cat",1);
					}
					else{
					    request.getSession().setAttribute("cat",0);}
					path="/HomeDonna.jsp";
				}
				else if (action.equalsIgnoreCase("addC")) {
					int id = Integer.parseInt(request.getParameter("id"));
					String sesso=(String)request.getParameter("sesso");
					String nome=(String)request.getParameter("nome");
					String colore=(String)request.getParameter("color");
					String taglia=(String)request.getParameter("taglia");
					int prezzo = Integer.parseInt(request.getParameter("prezzo"));
					int quantity = Integer.parseInt(request.getParameter("quantity"));
					TShirt t=new TShirt(id, sesso, nome, colore, taglia, prezzo, quantity);
				    ArrayList<TShirt> arr=cart.getProducts();
				    if(arr.contains(t)){
				    	int quan=arr.get(arr.lastIndexOf(t)).getquantita();
				    	ArrayList<TShirt> ts=new ManageTshirt().getTshirts();
						int quantita=ts.get(ts.lastIndexOf(t)).getquantita();
						if(quantita<(quan+quantity)){
							request.getSession().setAttribute("aggiunto", "Articolo non aggiunto disponibilità insufficiente");
						}
						else{
							cart.addItem(t);
							request.getSession().setAttribute("aggiunto", "Articolo aggiunto al carrello");
						}
				    }
				    else{
				    	ArrayList<TShirt> ts=new ManageTshirt().getTshirts();
						int quantita=ts.get(ts.lastIndexOf(t)).getquantita();
						if(quantita<quantity){
							request.getSession().setAttribute("aggiunto", "Articolo non aggiunto disponibilità insufficiente");
						}
						else{
							cart.addItem(t);
							request.getSession().setAttribute("aggiunto", "Articolo aggiunto al carrello");
						}}
				    request.removeAttribute("product");
					request.setAttribute("product", art.doRetrieveByKey(id,sesso));
					path="/dettagli.jsp";
				}
				else if(action.equalsIgnoreCase("deleteC")){
					int id = Integer.parseInt(request.getParameter("id"));
					String sesso=(String)request.getParameter("sesso");
					String colore=(String)request.getParameter("color");
					String taglia=(String)request.getParameter("taglia");
					cart.deleteItem(id,sesso,colore,taglia);
					path="/cart.jsp";
				}
				else if(action.equalsIgnoreCase("cart")){
					path="/cart.jsp";
				}
				else if(action.equalsIgnoreCase("modifyT")){
					int id = Integer.parseInt(request.getParameter("id"));
					String sesso=(String)request.getParameter("sesso");
					String tg=(String)request.getParameter("taglia");
					String tg1=(String)request.getParameter("taglia1");
					String col=(String)request.getParameter("colore");
					cart.modifyT(id, sesso, tg,col,tg1);
					path="/cart.jsp";
				}
				else if(action.equalsIgnoreCase("modifyQ")){
					int id = Integer.parseInt(request.getParameter("id"));
					String sesso=(String)request.getParameter("sesso");
					String tg=(String)request.getParameter("taglia");
					String col=(String)request.getParameter("colore");
					int q = Integer.parseInt(request.getParameter("quantity"));
					cart.modifyQ(id, sesso,q,col, tg);
					path="/cart.jsp";
				}
				else if(action.equalsIgnoreCase("saveCart")){
					i++;
					String metodo="";
					ArrayList<String> x=new ArrayList<String>();
					String pagamento=request.getParameter("Payment");
					switch(pagamento){
					    case "1":{metodo="MasterCard";break;}
                        case "2":{metodo="Visa";break;}
                        case "3":{metodo="PayPal";break;}
                        case "4":{metodo="postepay";break;}
                        case "5":{metodo="Maestro";break;}
                        case "6":{metodo="American Express";break;}
                        case "7":{metodo="Discover";break;}
                        case "8":{metodo="Aura";break;}
					}
					if(pagamento.equalsIgnoreCase("3")){
						pagamento=request.getParameter("nomeutente")+request.getParameter("password");
					}
					else{
						pagamento=request.getParameter("NumeroCarta");
					}
					
					x.add((String)request.getParameter("Nome"));
					x.add((String)request.getParameter("Cognome"));
					x.add((String)request.getParameter("Recapito"));
					x.add((String)request.getParameter("Indirizzo")+", "+request.getParameter("citta"));
					x.add((String)request.getParameter("CAP"));
					x.add(metodo);
					x.add(pagamento);
					new ManageCarrello().saveCart(cart, x,i);
					path="/Home.jsp";
				}
				else if(action.equalsIgnoreCase("upload")){
					String title=request.getParameter("title");
					String categoria=request.getParameter("categoria");
					String num=model.insert(title,categoria);
					Part filePart = request.getPart("upfile"); // il nome del campo input di tipo file
		            String fileName = filePart.getSubmittedFileName(); // fileName è un oggetto di tipo String
		            InputStream is = filePart.getInputStream(); // is è un oggetto di tipo InputStream
		            String fileExt = fileName.substring(fileName.lastIndexOf(".")); // fileExt è un oggetto di tipo String
		            String destinationPath = getServletContext().getInitParameter("filepath") +num+fileExt;
		            OutputStream os = new FileOutputStream(destinationPath); // oggetto di tipo OutputStream
		            IOUtils.copy(is, os);
		            is.close();
		            os.close();
		            path="/Admin.jsp";
				}
				else if(action.equalsIgnoreCase("deleteItem")){
					String id=request.getParameter("item");
					model.delete(id);
					path="/Admin.jsp";
				}
				else if(action.equalsIgnoreCase("getCategory")){
					String sex=request.getParameter("sesso");
					String category=request.getParameter("categoria");
					request.getSession().setAttribute("productsC", art.getCategory(sex, category));
				    if(sex.equals("M")){
				    	path="/HomeUomo.jsp";
				    }
				    else{
				    	path="/HomeDonna.jsp";
				    }
				}
				else if(action.equalsIgnoreCase("getCategory1")){
					String sex=request.getParameter("sesso");
				    if(sex.equals("M")){
				    	path="/HomeUomo.jsp";
				    }
				    else{
				    	path="/HomeDonna.jsp";
				    }
				}
		    }
		}
		catch (SQLException e) {
			System.out.println("Error:" + e.getMessage());
		}
		try {
			request.removeAttribute("productsM");
			request.removeAttribute("productsF");
			request.setAttribute("productsM", art.doRetrieveMen());
			request.setAttribute("productsF", art.doRetrieveWomen());
		} catch (SQLException e) {
			System.out.println("Error:" + e.getMessage());
		}
		request.getSession().removeAttribute("cart");
        request.getSession().setAttribute("cart", cart);
        synchronized (request.getSession()) {
        	request.removeAttribute("cart");
        	request.setAttribute("cart", cart);
		}
		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(path);
		dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}
	
	protected Boolean checkLogin(String username,String password){
		return (username.equals("root")&&password.equals("admin"));
	}
}
