package control.manage;
import java.util.ArrayList;
import java.sql.*;
import model.Dipendente;
public class ManageDipendente {
	
	public ArrayList<Dipendente> dipendenti;
	
	public ManageDipendente(){}
	

	private boolean flag;
	
	public ArrayList<Dipendente> getDipendenti(){
		DbConnect.connect();
		dipendenti=new ArrayList<Dipendente>();
		try{
			PreparedStatement ps=DbConnect.con.prepareStatement("select * from Dipendente");
			ResultSet rs=ps.executeQuery();
			while(rs.next()){
				Dipendente d=new Dipendente();
				d.setId(rs.getString("idDipendente"));
				d.setNome(rs.getString("nome"));
				d.setCognome(rs.getString("cognome"));
				d.setCodiceFiscale(rs.getString("codiceFiscale"));
				d.setStipendio(rs.getDouble("stipendio"));
				d.setTipo(rs.getString("tipo"));
				d.setUsername(rs.getString("username"));
				d.setPassword(rs.getString("password"));
				dipendenti.add(d);
			}
			ps.close();
			DbConnect.close();
		}catch(SQLException e){
			System.out.println("Connessione Fallita");
			e.printStackTrace();
		}
		return dipendenti;
	}
	
	
	public boolean insertDipendente(Dipendente d){
		DbConnect.connect();
		boolean flag=false;
		try{
			PreparedStatement ps=DbConnect.con.prepareStatement("insert into dipendente values(?,?,?,?,?,?,?,?);");
			ps.setString(1,d.getId());
			ps.setString(2,d.getNome());
			ps.setString(3,d.getCognome());
			ps.setString(4,d.getCodiceFiscale());
			ps.setDouble(5,d.getStipendio());
			ps.setString(6,d.getTipo());
			ps.setString(7,d.getUsername());
			ps.setString(8,d.getPassword());
			if(ps.executeUpdate()>0) flag=true;
			ps.close();
		}catch(SQLException e){
			System.out.println("Connessione Fallita");
			e.printStackTrace();
		}
		DbConnect.close();
		return flag;
	}
	
	public boolean deleteDipendente(int idDipendente){
		DbConnect.connect();
		boolean flag=false;
		try{
			PreparedStatement ps=DbConnect.con.prepareStatement("delete from dipendente where idDipendente=?");
			ps.setInt(1,idDipendente);
			if(ps.executeUpdate()>0) flag=true;
			ps.close();
			DbConnect.close();
		}catch(SQLException e){
			System.out.println("Connessione fallita");
			e.printStackTrace();
		}
		return flag;
	}
	
	public boolean updateStipendio(int idDipendente,double stipendio){
		DbConnect.connect();
		boolean flag=false;
		try{
			PreparedStatement ps=DbConnect.con.prepareStatement("update dipendente set stipendio=? where idDipendente=?");
			ps.setDouble(1,stipendio);
			ps.setInt(2,idDipendente);
			if(ps.executeUpdate()>0) flag=true;
			ps.close();
			DbConnect.close();
		}catch(SQLException e){
			System.out.println("Connesione fallita");
			e.printStackTrace();
		}
		return flag;
	}
	
	public boolean updateTipo(int idDipendente,String tipo){
		DbConnect.connect();
		boolean flag=false;
		try{
			PreparedStatement ps=DbConnect.con.prepareStatement("update dipendente set tipo=? where idDipendente=?");
			ps.setString(1,tipo);
			ps.setInt(2,idDipendente);
			if(ps.executeUpdate()>0) flag=true;
			ps.close();
			DbConnect.close();
		}catch(SQLException e){
			System.out.println("Connesione fallita");
			e.printStackTrace();
		}
		return flag;
	}
	
	public boolean updateNome(int idDipendente,String nome){
		DbConnect.connect();
		boolean flag=false;
		try{
			PreparedStatement ps=DbConnect.con.prepareStatement("update dipendente set nome=? where idDipendente=?");
			ps.setString(1,nome);
			ps.setInt(2,idDipendente);
			if(ps.executeUpdate()>0) flag=true;
			ps.close();
			DbConnect.close();
		}catch(SQLException e){
			System.out.println("Connesione fallita");
			e.printStackTrace();
		}
		return flag;
	}
	
	public boolean updateCognome(int idDipendente,String cognome){
		DbConnect.connect();
		boolean flag=false;
		try{
			PreparedStatement ps=DbConnect.con.prepareStatement("update dipendente set cognome=? where idDipendente=?");
			ps.setString(1,cognome);
			ps.setInt(2,idDipendente);
			if(ps.executeUpdate()>0) flag=true;
			ps.close();
			DbConnect.close();
		}catch(SQLException e){
			System.out.println("Connesione fallita");
			e.printStackTrace();
		}
		return flag;
	}
	
	public boolean updateCodiceFiscale(int idDipendente,String codiceFiscale){
		DbConnect.connect();
		boolean flag=false;
		try{
			PreparedStatement ps=DbConnect.con.prepareStatement("update dipendente set codiceFiscale=? where idDipendente=?");
			ps.setString(1,codiceFiscale);
			ps.setInt(2,idDipendente);
			if(ps.executeUpdate()>0) flag=true;
			ps.close();
			DbConnect.close();
		}catch(SQLException e){
			System.out.println("Connesione fallita");
			e.printStackTrace();
		}
		return flag;
	}
	
	public boolean updateUsername(int idDipendente,String username){
		DbConnect.connect();
		boolean flag=false;
		try{
			PreparedStatement ps=DbConnect.con.prepareStatement("update dipendente set username=? where idDipendente=?");
			ps.setString(1,username);
			ps.setInt(2,idDipendente);
			if(ps.executeUpdate()>0) flag=true;
			ps.close();
			DbConnect.close();
		}catch(SQLException e){
			System.out.println("Connesione fallita");
			e.printStackTrace();
		}
		return flag;
	}
	
	public boolean updatePassword(int idDipendente,String password){
		DbConnect.connect();
		boolean flag=false;
		try{
			PreparedStatement ps=DbConnect.con.prepareStatement("update dipendente set password=? where idDipendente=?");
			ps.setInt(1,idDipendente);
			ps.setString(2,password);
			if(ps.executeUpdate()>0) flag=true;
			ps.close();
			DbConnect.close();
		}catch(SQLException e){
			System.out.println("Connesione fallita");
			e.printStackTrace();
		}
		return flag;
	}
	
	public Dipendente getDipendente(int id){
		DbConnect.connect();
		Dipendente d=new Dipendente();
		try{
			PreparedStatement ps=DbConnect.con.prepareStatement("select * from Dipendente where iddipendente=?");
			ps.setInt(1, id);
			ResultSet rs=ps.executeQuery();
			while(rs.next()){
				d.setId(rs.getString("idDipendente"));
				d.setNome(rs.getString("nome"));
				d.setCognome(rs.getString("cognome"));
				d.setCodiceFiscale(rs.getString("codiceFiscale"));
				d.setStipendio(rs.getDouble("stipendio"));
				d.setTipo(rs.getString("tipo"));
				d.setUsername(rs.getString("username"));
				d.setPassword(rs.getString("password"));
			}
			ps.close();
			DbConnect.close();
		}catch(SQLException e){
			System.out.println("Connessione Fallita");
			e.printStackTrace();
		}
		return d;
	}
	
	public Dipendente getDipendente(String user,String password){
		DbConnect.connect();
		Dipendente d=new Dipendente();
		try{
			PreparedStatement ps=DbConnect.con.prepareStatement("select * from dipendente where username=? and password=?");
			ps.setString(1,user);
			ps.setString(2,password);
			ResultSet rs=ps.executeQuery();
			while(rs.next()){
				d.setId(rs.getString("idDipendente"));
				d.setNome(rs.getString("nome"));
				d.setCognome(rs.getString("cognome"));
				d.setCodiceFiscale(rs.getString("codiceFiscale"));
				d.setStipendio(rs.getDouble("stipendio"));
				d.setTipo(rs.getString("tipo"));
				d.setUsername(rs.getString("username"));
				d.setPassword(rs.getString("password"));
			}
			ps.close();
			DbConnect.close();
			return d;
		}catch(SQLException e){
			System.out.println("Connesione fallita");
			e.printStackTrace();
		}
		return null;
	}
	
	public String checkLogin(String user,String password){
		DbConnect.connect();
		try{
			PreparedStatement ps=DbConnect.con.prepareStatement("select tipo from dipendente where username=? and password=?");
			ps.setString(1,user);
			ps.setString(2,password);
			ResultSet rs=ps.executeQuery();
			String tipo=null;
			while(rs.next()){
				tipo=rs.getString("tipo");
			}
			ps.close();
			DbConnect.close();
			return tipo;
		}catch(SQLException e){
			System.out.println("Connesione fallita");
			e.printStackTrace();
		}
		return null;
	}


	public ArrayList<Dipendente> getStipendiP(String data) {
		DbConnect.connect();
		dipendenti=new ArrayList<Dipendente>();
		try{
			PreparedStatement ps=DbConnect.con.prepareStatement("select D.*,S.data from Dipendente D join StipendiPagati S on D.idDipendente=S.idDipendente where data<? order by data");
			ps.setString(1, data);
			ResultSet rs=ps.executeQuery();
			while(rs.next()){
				Dipendente d=new Dipendente();
				d.setId(rs.getString("idDipendente"));
				d.setNome(rs.getString("nome"));
				d.setCognome(rs.getString("cognome"));
				d.setCodiceFiscale(rs.getString("codiceFiscale"));
				d.setStipendio(rs.getDouble("stipendio"));
				d.setTipo(rs.getString("tipo"));
				d.setUsername(rs.getString("username"));
				d.setPassword(rs.getString("password"));
				d.setDataP(rs.getString("data"));
				dipendenti.add(d);
			}
			ps.close();
			DbConnect.close();
		}catch(SQLException e){
			System.out.println("Connessione Fallita");
			e.printStackTrace();
		}
		return dipendenti;
	}

}
