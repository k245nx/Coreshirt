package control.manage;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import model.Fattura;

public class ManageFattura {
	

	public ManageFattura(){}
	
	public synchronized void insertFattura(Fattura f){
		DbConnect.connect();
		Connection connection = DbConnect.con;
		try{
			String insert="insert into fattura(idordine,indirizzospedizione,totale,iva) values(?,?,?,?);";
		    PreparedStatement ps=connection.prepareStatement(insert);
		    ps.setInt(1, f.getOrdine().getIdOrdine());
		    ps.setString(2,f.getIndirizzoSpedizione());
		    ps.setDouble(3, f.getTotale());
		    ps.setString(4,""+f.getIva());
		    if(ps.executeUpdate()>0) System.out.println("inserito");
		    ps.close();
		    DbConnect.close();
		}
		catch(SQLException e){
			e.printStackTrace();
		}
	}


}
