package control.manage;
import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedList;

import model.Articolo;

import java.sql.*;
public class ManageArticolo{
	
	private static final String TABLE_NAME = "articolo";

	private ArrayList<Articolo> articoli;

	public ManageArticolo(){}

	
	public ArrayList<Articolo> getArticoli(){
		DbConnect.connect();
		articoli=new ArrayList<Articolo>();
		try{
			PreparedStatement ps=DbConnect.con.prepareStatement("select * from articolo");
			ResultSet rs=ps.executeQuery();
			while(rs.next()){
				Articolo a=new Articolo(rs.getInt("idArticolo"),rs.getString("nome"),rs.getDouble("prezzo"),rs.getInt("quantita"),rs.getString("categoria"));
				articoli.add(a);
			}
			ps.close();
			DbConnect.close();
		}catch(SQLException e){
			System.out.println("Connessione Fallita");
			e.printStackTrace();
		}
		return articoli;
	}
	
	
	public int insertArticolo(Articolo a){
		ArrayList<Articolo> c=getArticoli();
		int id=c.size()+1;
		DbConnect.connect();
		if(c.contains(a)){
			return c.get(c.indexOf(a)).getidArticolo();
		}
		try{
			PreparedStatement ps=DbConnect.con.prepareStatement("insert into articolo values(?,?,?,?,?)");
			ps.setInt(1,id);
			ps.setString(2,a.getnome());
			ps.setString(3,a.getcategoria());
			ps.setDouble(4,a.getprezzo());
			ps.setInt(5,a.getquantita());
			if(ps.executeUpdate()<=0) return 0;
			ps.close();
		}catch(SQLException e){
			System.out.println("Connessione Fallita");
			e.printStackTrace();
		}
		DbConnect.close();
		return id;
	}
	
	public boolean deleteArticolo(int idArticolo){
		DbConnect.connect();
		boolean flag=false;
		try{
			PreparedStatement ps=DbConnect.con.prepareStatement("delete from articolo where idarticolo=?");
			ps.setInt(1,idArticolo);
			if(ps.executeUpdate()>0) flag=true;
			ps.close();
			DbConnect.close();
		}catch(SQLException e){
			System.out.println("Connessione fallita");
			e.printStackTrace();
		}
		return flag;
	}
	
	public boolean updateNome(String idArticolo,String nome){
		DbConnect.connect();
		boolean flag=false;
		try{
			PreparedStatement ps=DbConnect.con.prepareStatement("update articolo set nome=? where idarticolo=?");
			ps.setString(1,nome);
			ps.setString(2,idArticolo);
			if(ps.executeUpdate()>0) flag=true;
			ps.close();
			DbConnect.close();
		}catch(SQLException e){
			System.out.println("Connesione fallita");
			e.printStackTrace();
		}
		return flag;
	}
	
	public boolean updateCategoria(String idArticolo,String categoria){
		DbConnect.connect();
		boolean flag=false;
		try{
			PreparedStatement ps=DbConnect.con.prepareStatement("update articolo set categoria=? where idarticolo=?");
			ps.setString(1,categoria);
			ps.setString(2,idArticolo);
			if(ps.executeUpdate()>0) flag=true;
			ps.close();
			DbConnect.close();
		}catch(SQLException e){
			System.out.println("Connesione fallita");
			e.printStackTrace();
		}
		return flag;
	}
	
	public boolean updatePrezzo(String idArticolo,String prezzo){
		DbConnect.connect();
		boolean flag=false;
		try{
			PreparedStatement ps=DbConnect.con.prepareStatement("update articolo set prezzo=? where idarticolo=?");
			ps.setDouble(1,Double.parseDouble(prezzo));
			ps.setString(2,idArticolo);
			if(ps.executeUpdate()>0) flag=true;
			ps.close();
			DbConnect.close();
		}catch(SQLException e){
			System.out.println("Connesione fallita");
			e.printStackTrace();
		}
		return flag;
	}
	
	public boolean updateQuantita(String idArticolo,int quantita){
		DbConnect.connect();
		boolean flag=false;
		try{
			PreparedStatement ps=DbConnect.con.prepareStatement("update articolo set quantita=? where idarticolo=?");
			ps.setInt(1,quantita);
			ps.setString(2,idArticolo);
			if(ps.executeUpdate()>0) flag=true;
			ps.close();
			DbConnect.close();
		}catch(SQLException e){
			System.out.println("Connesione fallita");
			e.printStackTrace();
		}
		return flag;
	}
	
	public synchronized Articolo doRetrieveByKey(int code,String sesso) throws SQLException {
		DbConnect.connect();

		PreparedStatement preparedStatement = null;

		Articolo bean = new Articolo();

		String selectSQL = "SELECT * FROM " + ManageArticolo.TABLE_NAME + " WHERE idarticolo = ?";

		try {
			preparedStatement = DbConnect.con.prepareStatement(selectSQL);
			preparedStatement.setInt(1,code);
			//preparedStatement.setString(2,sesso);

			ResultSet rs = preparedStatement.executeQuery();

			while (rs.next()) {
				bean.setId(rs.getInt("idarticolo"));
				bean.setSesso(sesso);
				bean.setnome(rs.getString("Nome"));
				bean.setquantita(0);
			}
			DbConnect.close();
		} finally {
			try {
				if (preparedStatement != null)
					preparedStatement.close();
			} finally {
				
			}
		}
		return bean;
	}

	public synchronized Collection<Articolo> doRetrieveMen() throws SQLException {
		DbConnect.connect();
		PreparedStatement preparedStatement = null;

		LinkedList<Articolo> products = new LinkedList<Articolo>();

		String selectSQL = "SELECT * FROM " + TABLE_NAME;

		try {
			
			preparedStatement = DbConnect.con.prepareStatement(selectSQL);

			ResultSet rs = preparedStatement.executeQuery();
			while (rs.next()) {
				Articolo bean = new Articolo();
				bean.setId(rs.getInt("idarticolo"));
				bean.setSesso("M");
				bean.setnome(rs.getString("Nome"));
				//bean.setQuantity(rs.getInt("PzVenduti"));
				bean.setcategoria(rs.getString("Categoria"));
				products.add(bean);
			}
			DbConnect.close();
		} finally {
			try {
				if (preparedStatement != null)
					preparedStatement.close();
			} finally {
				
			}
		}
		return products;
	}
	public synchronized Collection<Articolo> doRetrieveWomen() throws SQLException {
		DbConnect.connect();
		PreparedStatement preparedStatement = null;

		LinkedList<Articolo> products = new LinkedList<Articolo>();

		String selectSQL = "SELECT * FROM " + TABLE_NAME+" order by idarticolo desc";

		try {
			
			preparedStatement = DbConnect.con.prepareStatement(selectSQL);

			ResultSet rs = preparedStatement.executeQuery();
			while (rs.next()) {
				Articolo bean = new Articolo();
				bean.setId(rs.getInt("idarticolo"));
				bean.setSesso("F");
				bean.setnome(rs.getString("Nome"));
				//bean.setQuantity(rs.getInt("PzVenduti"));
				bean.setcategoria(rs.getString("Categoria"));
				products.add(bean);
			}
			DbConnect.close();
		} finally {
			try {
				if (preparedStatement != null)
					preparedStatement.close();
			} finally {
				
			}
		}
		return products;
	}
	public synchronized Collection<Articolo> getCategory(String sex,String category) throws SQLException{
		DbConnect.connect();
		PreparedStatement preparedStatement = null;
		LinkedList<Articolo> products = new LinkedList<Articolo>();
		String selectSQL = "SELECT * FROM " + TABLE_NAME + " where categoria='"+category+"' ;";
        
		try {
			
			preparedStatement = DbConnect.con.prepareStatement(selectSQL);

			ResultSet rs = preparedStatement.executeQuery();
			while (rs.next()) {
				Articolo bean = new Articolo();
				bean.setId(rs.getInt("idarticolo"));
				bean.setSesso(sex);
				bean.setnome(rs.getString("Nome"));
				//bean.setQuantity(rs.getInt("PzVenduti"));
				bean.setcategoria(rs.getString("Categoria"));
				products.add(bean);
			}
			DbConnect.close();
		} finally {
			try {
				if (preparedStatement != null)
					preparedStatement.close();
			} finally {
				
			}
		}
		return products;
	}
     
	public int getQuantita(int id){
		DbConnect.connect();
		PreparedStatement preparedStatement = null;
		String selectSQL = "SELECT quantita FROM " + TABLE_NAME+" where idarticolo="+id;
		int pezzi=0;
		try {
			preparedStatement = DbConnect.con.prepareStatement(selectSQL);
			ResultSet rs = preparedStatement.executeQuery();
			
			while(rs.next()){
				pezzi=rs.getInt(1);
			}
			return pezzi;
		}
		catch(SQLException e){
			e.printStackTrace();
			
		}
		return pezzi;
	}
	
	public Articolo getArticolo(int num){
		DbConnect.connect();
		Articolo a=null;
		try{
			PreparedStatement ps=DbConnect.con.prepareStatement("select * from articolo where idarticolo=?");
			ps.setInt(1, num);
			ResultSet rs=ps.executeQuery();
			while(rs.next()){
				a=new Articolo(rs.getInt("idArticolo"),rs.getString("nome"),rs.getDouble("prezzo"),rs.getInt("quantita"),rs.getString("categoria"));
			}
			ps.close();
			DbConnect.close();
		}catch(SQLException e){
			System.out.println("Connessione Fallita");
			e.printStackTrace();
		}
		return a;
	}

}
