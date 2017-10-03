package control.manage;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import model.Dipendente;

public class ManageStipendi {
    
	private Connection con;
	public ManageStipendi() {

	}

	public boolean inserisciStipendiP(String id,String data,double stipendio){
 	DbConnect.connect();
 	con=DbConnect.con;
		boolean flag=false;
		try{
			boolean c=true;
			PreparedStatement check=con.prepareStatement("select data from stipendipagati "
					+ "where iddipendente=?");
			check.setString(1,id);
			ResultSet rs=check.executeQuery();
			String mese="";
			try {
				mese=new SimpleDateFormat("MM")
						.format(new SimpleDateFormat("yyyy-MM-dd").parse(data));
			} catch (ParseException e) {
				e.printStackTrace();
			}
			int m=Integer.parseInt(mese);
			while(rs.next()){
				String data2=new SimpleDateFormat("MM").format(rs.getDate("data"));
				int M=Integer.parseInt(data2);
				if(m>M) c=true;
				else c=false;
			}
			if(c){
			PreparedStatement ps=con.prepareStatement("insert into stipendipagati values(?,?)");
			ps.setString(1,id);
			ps.setString(2,data);
			if(ps.executeUpdate()>0) {
				flag=true;
				String date=new SimpleDateFormat("yyyy").format(new Date());
				int anno=Integer.parseInt(date);
				new ManageTotale().sottraiTotale(anno,stipendio);
			}
			ps.close();
			}
			else{
				System.out.println("Stipendio già presente");
			}
			DbConnect.close();
		}catch(SQLException e){
			System.out.println("Connesione fallita");
			e.printStackTrace();
		}
		return flag;
	}
	
	public void inserisciStipendiP(ArrayList<Dipendente> dipendenti,String data){
	 	for(Dipendente d:dipendenti){
	 		inserisciStipendiP(d.getId(), data, d.getStipendio());
	 	}
	}
}
