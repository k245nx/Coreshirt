package control.manage;
import java.util.Date;

import model.Spesa;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
public class ManageSpesa {
	public ArrayList<Spesa> spese=new ArrayList<Spesa>();
	
	public ManageSpesa(){}
	
	public ArrayList<Spesa> getSpese(){
		DbConnect.connect();
		spese=new ArrayList<Spesa>();
		try{
			PreparedStatement ps=DbConnect.con.prepareStatement("select * from spesa");
			ResultSet rs=ps.executeQuery();
			while(rs.next()){
				Spesa s=new Spesa(rs.getDouble("ammontare"),rs.getDate("data"),rs.getString("descrizione"));
				spese.add(s);
			}
			ps.close();
			DbConnect.close();
		}catch(SQLException e){
			System.out.println("Connessione Fallita");
			e.printStackTrace();
		}
		return spese;
	}
	
	public boolean insertSpesa(Spesa s){
		DbConnect.connect();
		boolean flag=false;
		try{
			PreparedStatement ps=DbConnect.con.prepareStatement("insert into spesa (ammontare,data,descrizione) values(?,?,?)");
			ps.setDouble(1,s.getAmmontare());
			ps.setString(2,""+s.getData());
			ps.setString(3,s.getDescrizione());
			if(ps.executeUpdate()>0) {
				flag=true;
				int anno=Integer.parseInt(
						new SimpleDateFormat("yyyy").format(
								new Date()
								)
						);
				new ManageTotale().sottraiTotale(anno, s.getAmmontare());					  
			}
			ps.close();
		}catch(SQLException e){
			System.out.println("Connessione Fallita");
			e.printStackTrace();
		}
		DbConnect.close();
		return flag;
	}
	
	public boolean deleteIdSpesa(int idSpesa){
		DbConnect.connect();
		boolean flag=false;
		try{
			PreparedStatement ps=DbConnect.con.prepareStatement("delete from spesa where idspesa=?");
			ps.setInt(1,idSpesa);
			if(ps.executeUpdate()>0) flag=true;
			ps.close();
			DbConnect.close();
		}catch(SQLException e){
			System.out.println("Connessione fallita");
			e.printStackTrace();
		}
		return flag;
	}
	
	public boolean updateDescrizione(String descrizione,String idSpesa){
		DbConnect.connect();
		boolean flag=false;
		try{
			PreparedStatement ps=DbConnect.con.prepareStatement("update dipendente set descrizione=? where idspesa=?");
			ps.setString(1,descrizione);
			ps.setString(2,idSpesa);
			if(ps.executeUpdate()>0) flag=true;
			ps.close();
			DbConnect.close();
		}catch(SQLException e){
			System.out.println("Connesione fallita");
			e.printStackTrace();
		}
		return flag;
	}
	
	public boolean updateAmmontare(Double ammontare,String idSpesa){
		DbConnect.connect();
		boolean flag=false;
		try{
			PreparedStatement ps=DbConnect.con.prepareStatement("update dipendente set ammontare=? where idspesa=?");
			ps.setDouble(1,ammontare);
			ps.setString(2,idSpesa);
			if(ps.executeUpdate()>0) flag=true;
			ps.close();
			DbConnect.close();
		}catch(SQLException e){
			System.out.println("Connesione fallita");
			e.printStackTrace();
		}
		return flag;
	}
	
	public boolean updateData(String data,String idSpesa){
		DbConnect.connect();
		boolean flag=false;
		try{
			PreparedStatement ps=DbConnect.con.prepareStatement("update dipendente set data=? where idspesa=?");
			ps.setString(1,data);
			ps.setString(2,idSpesa);
			if(ps.executeUpdate()>0) flag=true;
			ps.close();
			DbConnect.close();
		}catch(SQLException e){
			System.out.println("Connesione fallita");
			e.printStackTrace();
		}
		return flag;
	}

}
