package control.manage;
import java.sql.*;
public class  DbConnect {
	public static  Connection con;
	private static String url="jdbc:mysql://localhost:3306/coreshirt2";
	

	
	public static void connect(){
		try{
			Class.forName("com.mysql.jdbc.Driver").newInstance();
			con=DriverManager.getConnection(url,"root","Freitag22*");
			System.out.println("Connessione effettuata");
		}catch(Exception e){
			System.out.println("Connessione fallita");
			e.printStackTrace();
		}
	}
	
	public static void close(){
		try{
			con.close();
			System.out.println("Connessione chiusa");
		}catch(SQLException e){
			e.printStackTrace();
		}
	}
	

}



