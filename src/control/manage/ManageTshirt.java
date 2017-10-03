package control.manage;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.sql.Connection;
import model.TShirt;
public class ManageTshirt {
	
	private ArrayList<TShirt> tshirts;
	private Connection connection;
	public ManageTshirt(){}
	
	public ArrayList<TShirt> getTshirts(){
		DbConnect.connect();
		tshirts=new ArrayList<TShirt>();
		try{
			PreparedStatement ps=DbConnect.con.prepareStatement("select * from tshirt");
			ResultSet rs=ps.executeQuery();
			while(rs.next()){
				TShirt t=new TShirt(rs.getInt("articolo"),rs.getString("sesso"),"",rs.getString("colore"),rs.getString("taglia"),rs.getInt("quantita"));
				tshirts.add(t);
			}
			ps.close();
			DbConnect.close();
		}catch(SQLException e){
			System.out.println("Connessione Fallita");
			e.printStackTrace();
		}
		return tshirts;
	}
	public ArrayList<TShirt> getArticoliS(){
		DbConnect.connect();
		tshirts=new ArrayList<TShirt>();
		try{
			PreparedStatement ps=DbConnect.con.prepareStatement("select * from tshirt where quantita<6");
			ResultSet rs=ps.executeQuery();
			while(rs.next()){
				TShirt t=new TShirt(rs.getInt("articolo"),rs.getString("sesso"),"",rs.getString("colore"),rs.getString("taglia"),rs.getInt("quantita"));
				tshirts.add(t);
			}
			ps.close();
			DbConnect.close();
		}catch(SQLException e){
			System.out.println("Connessione Fallita");
			e.printStackTrace();
		}
		return tshirts;
	}
	
	public boolean insertTshirt(TShirt t){
		String id=getIdTshirt(t.getidArticolo(),t.getSesso(), t.getTaglia(), t.getColore());
		if(!id.equals("")){
			return updateQuantita(id,t.getquantita());
		}
		else{
		DbConnect.connect();
		boolean flag=false;
		try{
			PreparedStatement ps=DbConnect.con.prepareStatement("insert into tshirt (articolo, sesso, taglia, colore, quantita) values(?,?,?,?,?)");
			ps.setInt(1, t.getidArticolo());
			ps.setString(2,t.getSesso());
			ps.setString(3,t.getTaglia());
			ps.setString(4,t.getColore());
			ps.setInt(5,t.getquantita());
			if(ps.executeUpdate()>0) flag=true;
			ps.close();
		}catch(SQLException e){
			System.out.println("Connessione Fallita");
			e.printStackTrace();
		}
		DbConnect.close();
		return flag;}
	}
	
	public boolean deleteTshirt(String id){
		DbConnect.connect();
		connection=DbConnect.con;
		boolean flag=false;
		try{
			String select="delete from tshirt where idtshirt="+id+";";
	    	PreparedStatement ps = connection.prepareStatement(select);
			if(ps.executeUpdate()>0) flag=true;
			ps.close();
			DbConnect.close();
		}catch(SQLException e){
			System.out.println("Connessione fallita");
			e.printStackTrace();
		}
		return flag;
	}
	
	public boolean updateSesso(int idTshirt,String sesso){
		DbConnect.connect();
		boolean flag=false;
		try{
			PreparedStatement ps=DbConnect.con.prepareStatement("update tshirt set sesso=? where id=?");
			ps.setString(1,sesso);
			ps.setInt(2,idTshirt);
			if(ps.executeUpdate()>0) flag=true;
			ps.close();
			DbConnect.close();
		}catch(SQLException e){
			System.out.println("Connesione fallita");
			e.printStackTrace();
		}
		return flag;
	}
	
	public boolean updateTaglia(int idTshirt,String taglia){
		DbConnect.connect();
		boolean flag=false;
		try{
			PreparedStatement ps=DbConnect.con.prepareStatement("update tshirt set taglia=? where id=?");
			ps.setString(1,taglia);
			ps.setInt(2,idTshirt);
			if(ps.executeUpdate()>0) flag=true;
			ps.close();
			DbConnect.close();
		}catch(SQLException e){
			System.out.println("Connesione fallita");
			e.printStackTrace();
		}
		return flag;
	}
	
	public boolean updateColore(int idTshirt,String colore){
		DbConnect.connect();
		boolean flag=false;
		try{
			PreparedStatement ps=DbConnect.con.prepareStatement("update tshirt set colore=? where id=?");
			ps.setString(1,colore);
			ps.setInt(2,idTshirt);
			if(ps.executeUpdate()>0) flag=true;
			ps.close();
			DbConnect.close();
		}catch(SQLException e){
			System.out.println("Connesione fallita");
			e.printStackTrace();
		}
		return flag;
	}
	
	public boolean updateQuantita(String idTshirt,int quantita){
		DbConnect.connect();
		boolean flag=false;
		try{
			int q=0;
			PreparedStatement ps=DbConnect.con.prepareStatement("select quantita from tshirt where idtshirt=?");
			ps.setString(1,idTshirt);
			ResultSet rs=ps.executeQuery();
	    	while(rs.next()){
	    		q=rs.getInt(1);
	    	}
	    	quantita=quantita+q;
			ps=DbConnect.con.prepareStatement("update tshirt set quantita=? where idtshirt=?");
			ps.setString(2,idTshirt);
			ps.setInt(1,quantita);
			if(ps.executeUpdate()>0) flag=true;
			ps.close();
			DbConnect.close();
		}catch(SQLException e){
			System.out.println("Connesione fallita");
			e.printStackTrace();
		}
		return flag;
	}
	
	public String getIdTshirt(int idArticolo,String sesso,String taglia,String colore){
		DbConnect.connect();
        connection=DbConnect.con;
        String id="";
		try{
			String select="select idtshirt from tshirt where articolo="+idArticolo+" and sesso='"+sesso+"' and taglia='"+taglia+"' and colore='"+colore+"';";
	    	PreparedStatement preparedStatement = connection.prepareStatement(select);
	    	ResultSet rs=preparedStatement.executeQuery();
	    	while(rs.next()){
	    		id=rs.getString(1);
	    	}
			preparedStatement.close();
			DbConnect.close();
		}catch(SQLException e){
			System.out.println("Connesione fallita");
			e.printStackTrace();
		}
		return id;
	}
	
	public TShirt getTShirtR(String string){
		TShirt t=new TShirt();
		DbConnect.connect();
		try{
			PreparedStatement ps=DbConnect.con.prepareStatement("select * from tshirt where idtshirt in(select idtshirt from composizionerifornimento where idrifornimento=?);");
			ps.setInt(1,Integer.parseInt(string));
			ResultSet rs=ps.executeQuery();
			while(rs.next()){
				t.setId(rs.getInt("articolo"));
				t.setSesso(rs.getString("sesso"));
				t.setTaglia(rs.getString("taglia"));
				t.setColore(rs.getString("colore"));
				t.setquantita(rs.getInt("quantita"));
			}
			ps.close();
			DbConnect.close();
		}catch(SQLException e){
			System.out.println("Connessione Fallita");
			e.printStackTrace();
		}
		return t;
	}
}
	

