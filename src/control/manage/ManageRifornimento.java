package control.manage;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

import model.Rifornimento;
import model.TShirt;
public class ManageRifornimento {
	private ArrayList<Rifornimento> rifornimenti=new ArrayList<Rifornimento>();
	
	public ManageRifornimento(){}
	public ArrayList<Rifornimento> getOrdini(){
		DbConnect.connect();
		rifornimenti=new ArrayList<Rifornimento>();
		try{
			PreparedStatement ps=DbConnect.con.prepareStatement("select * from rifornimento");
			ResultSet rs=ps.executeQuery();
			while(rs.next()){
				Rifornimento r=new Rifornimento(rs.getString("idRifornimento"),rs.getDouble("totale"),rs.getString("stato"),rs.getString("idDipendente"),""+rs.getDate("dataRichiesta"),rs.getDate("dataEffettuazione"),rs.getDate("dataConsegnaPrevista"));
				TShirt tshirt=new ManageTshirt().getTShirtR(r.getIdRifornimento()); 
				r.setTshirt(tshirt);
				rifornimenti.add(r);
			}
			ps.close();
			DbConnect.close();
		}catch(SQLException e){
			System.out.println("Connessione Fallita");
			e.printStackTrace();
		}
		return rifornimenti;
	}
	
	
	public boolean insertRifornimento(Rifornimento r){
		int id=getOrdini().size()+1;
		DbConnect.connect();
		boolean flag=false;
		try{
			PreparedStatement ps=DbConnect.con.prepareStatement("insert into rifornimento (idDipendente,dataRichiesta,dataEffettuazione,dataConsegnaPrevista,stato,totale) values(?,?,?,?,?,?)");
			ps.setString(1,r.getIdDipendente());
			ps.setString(2,r.getDataRichiesta());
			ps.setString(3,r.getDataRichiesta());
			ps.setString(4,r.getDataRichiesta());
			ps.setString(5,r.getStato());
			ps.setDouble(6,r.getTotale());	
			if(ps.executeUpdate()>0) {
				flag=true;
				int anno=Integer.parseInt(
						new SimpleDateFormat("yyyy").format(
								new Date()
								)
						);
				new ManageTotale().sottraiTotale(anno,r.getTotale());	
			}
			TShirt t=r.getTshirt();
			String tshirt=new ManageTshirt().getIdTshirt(t.getidArticolo(),t.getSesso(), t.getTaglia(), t.getColore());
			insertComposizione(id,tshirt,t.getquantita());
			ps.close();
		}catch(SQLException e){
			System.out.println("Connessione Fallita");
			e.printStackTrace();
		}
		DbConnect.close();
		return flag;
	}
	
	private boolean insertComposizione(int id, String tshirt,int pezzi) {
		DbConnect.connect();
		boolean flag=false;
		try{
			PreparedStatement ps=DbConnect.con.prepareStatement("insert into composizionerifornimento values(?,?,?)");
			ps.setInt(1,id);
			ps.setString(2,tshirt);
			ps.setInt(3, pezzi);
			if(ps.executeUpdate()>0) flag=true;
			ps.close();
		}catch(SQLException e){
			System.out.println("Connessione Fallita");
			e.printStackTrace();
		}
		DbConnect.close();
		return flag;
	}
	public boolean deleteRifornimento(String idRifornimento){
		DbConnect.connect();
		boolean flag=false;
		try{
			PreparedStatement ps=DbConnect.con.prepareStatement("delete from rifornimento where idrifornimento=?");
			ps.setString(1,idRifornimento);
			if(ps.executeUpdate()>0) flag=true;
			ps.close();
			DbConnect.close();
		}catch(SQLException e){
			System.out.println("Connessione fallita");
			e.printStackTrace();
		}
		return flag;
	}
	
	public boolean updateDataEffettuazione(String dataEffettuazione,String idRifornimento){
		DbConnect.connect();
		boolean flag=false;
		try{
			PreparedStatement ps=DbConnect.con.prepareStatement("update rifornimento set dataEffettuazione=? where idrifornimento=?");
			ps.setString(1,dataEffettuazione);
			ps.setString(2,idRifornimento);
			if(ps.executeUpdate()>0) flag=true;
			ps.close();
			DbConnect.close();
		}catch(SQLException e){
			System.out.println("Connesione fallita");
			e.printStackTrace();
		}
		return flag;
	}
	
	public boolean updateDataRichiesta(String data,String idRifornimento){
		DbConnect.connect();
		boolean flag=false;
		try{
			PreparedStatement ps=DbConnect.con.prepareStatement("update rifornimento set dataRichiesta=? where idrifornimento=?");
			ps.setString(1,data);
			ps.setString(2,idRifornimento);
			if(ps.executeUpdate()>0) flag=true;
			ps.close();
			DbConnect.close();
		}catch(SQLException e){
			System.out.println("Connesione fallita");
			e.printStackTrace();
		}
		return flag;
	}
	
	public boolean updateDataConsegna(String dataConsegna,String idRifornimento){
		DbConnect.connect();
		boolean flag=false;
		try{
			PreparedStatement ps=DbConnect.con.prepareStatement("update rifornimento set dataConsegnaPrevista=? where idrifornimento=?");
			ps.setString(1,dataConsegna);
			ps.setString(2,idRifornimento);
			if(ps.executeUpdate()>0) flag=true;
			ps.close();
			DbConnect.close();
		}catch(SQLException e){
			System.out.println("Connesione fallita");
			e.printStackTrace();
		}
		return flag;
	}
	
	public boolean evadi(String id){
		String data=new SimpleDateFormat("yyyy-MM-dd").format(new Date());
		updateDataEffettuazione(data, id);
		try {
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			Calendar c = Calendar.getInstance();
			c.setTime(sdf.parse(data));
			c.add(Calendar.DATE, 3);  // number of days to add
			data = sdf.format(c.getTime());  // dt is now the new date
		} catch (ParseException e1) {
			e1.printStackTrace();
		}
		updateDataConsegna(data, id);
		DbConnect.connect();
		boolean flag=false;
		try{
			PreparedStatement ps=DbConnect.con.prepareStatement("update rifornimento set stato=? where idrifornimento=?");
			ps.setString(1,"evaso");
			ps.setString(2,id);
			if(ps.executeUpdate()>0) flag=true;
			ps.close();
			DbConnect.close();
		}catch(SQLException e){
			System.out.println("Connesione fallita");
			e.printStackTrace();
		}
		return flag;
	}
	
	public ArrayList<Rifornimento> getInevasi(){
		DbConnect.connect();
		rifornimenti=new ArrayList<Rifornimento>();
		try{
			PreparedStatement ps=DbConnect.con.prepareStatement("select * from rifornimento where stato='inevaso'");
			ResultSet rs=ps.executeQuery();
			while(rs.next()){
				Rifornimento r=new Rifornimento(rs.getString("idRifornimento"),rs.getDouble("totale"),rs.getString("stato"),rs.getString("idDipendente"),""+rs.getDate("dataRichiesta"),rs.getDate("dataEffettuazione"),rs.getDate("dataConsegnaPrevista"));
				TShirt tshirt=new ManageTshirt().getTShirtR(r.getIdRifornimento()); 
				r.setTshirt(tshirt);
				rifornimenti.add(r);
			}
			ps.close();
			DbConnect.close();
		}catch(SQLException e){
			System.out.println("Connessione Fallita");
			e.printStackTrace();
		}
		return rifornimenti;
	}
	public boolean insertRifornimento(Rifornimento r, String string) {
		int id=getOrdini().size()+1;
		DbConnect.connect();
		boolean flag=false;
		try{
			PreparedStatement ps=DbConnect.con.prepareStatement("insert into rifornimento (idDipendente,dataRichiesta,dataEffettuazione,dataConsegnaPrevista,stato,totale) values(?,?,?,?,?,?)");
			ps.setString(1,r.getIdDipendente());
			ps.setString(2,r.getDataRichiesta());
			ps.setString(3,r.getDataRichiesta());
			ps.setString(4,r.getDataRichiesta());
			ps.setString(5,string);
			ps.setDouble(6,r.getTotale());	
			if(ps.executeUpdate()>0) {
				flag=true;
				int anno=Integer.parseInt(
						new SimpleDateFormat("yyyy").format(
								new Date()
								)
						);
				new ManageTotale().sottraiTotale(anno,r.getTotale());	
			}
			TShirt t=r.getTshirt();
			String tshirt=new ManageTshirt().getIdTshirt(t.getidArticolo(),t.getSesso(), t.getTaglia(), t.getColore());
			insertComposizione(id,tshirt,t.getquantita());
			ps.close();
		}catch(SQLException e){
			System.out.println("Connessione Fallita");
			e.printStackTrace();
		}
		DbConnect.close();
		return flag;
	}

}
