package control.manage;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


public class ManageTotale {
     Connection con;
     
     public double getTotale(int anno){
    	DbConnect.connect();
    	con=DbConnect.con;
 		double totale=0;
 		try{
 			PreparedStatement ps=DbConnect.con.prepareStatement("select * from totale where anno=?");
 			ps.setInt(1, anno);
 			ResultSet rs=ps.executeQuery();
 			while(rs.next()){
 				totale=rs.getDouble("totale");
 			}
 			ps.close();
 			DbConnect.close();
 		}catch(SQLException e){
 			System.out.println("Connessione Fallita");
 			e.printStackTrace();
 		}
 		return totale;
     }
     
     public boolean aggiungiTotale(int anno,double somma){
    	somma+=getTotale(anno);
    	DbConnect.connect();
    	con=DbConnect.con;
 		boolean flag=false;
 		try{
 			PreparedStatement ps=con.prepareStatement("update totale set totale=? where anno=?");
 			ps.setDouble(1,somma);
 			ps.setInt(2,anno);
 			if(ps.executeUpdate()>0) flag=true;
 			ps.close();
 			DbConnect.close();
 		}catch(SQLException e){
 			System.out.println("Connesione fallita");
 			e.printStackTrace();
 		}
 		return flag;
     }
     
     public boolean sottraiTotale(int anno,double somma){
     	somma=getTotale(anno)-somma;
     	DbConnect.connect();
     	con=DbConnect.con;
  		boolean flag=false;
  		try{
  			PreparedStatement ps=con.prepareStatement("update totale set totale=? where anno=?");
  			ps.setDouble(1,somma);
  			ps.setInt(2,anno);
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
