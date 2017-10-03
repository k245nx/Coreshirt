package control.manage;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.LinkedList;

import model.Cart;
import model.TShirt;
import model.Articolo;

public class DatabaseConnection {
	private static final   String driver = "com.mysql.jdbc.Driver";
	private static final     String url = "jdbc:mysql://localhost:3306/coreshirt2?user=root&password=Freitag22*"; 

	static{try {
		Class.forName(driver);
	} catch(ClassNotFoundException e) {
		System.err.print("ClassNotFoundException: ");
		System.err.println(e.getMessage());
	}}
	
	public synchronized String insert(String title,String categoria){
		String query="select max(codice) from t_shirt;";
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		try {
			connection = DriverManager.getConnection(url);
			preparedStatement = connection.prepareStatement(query);
			ResultSet rs=preparedStatement.executeQuery();
			String x="";
			while(rs.next()){
				x=rs.getString(1);
			}
			if(x==null)
				x=""+0;
			else{
			int k=Integer.parseInt(x)+1;
			x=""+k;}
			query="insert into t_shirt (codice,sesso,nome,categoria) values("+x+",'M','"+title+"','"+categoria+"');";
			preparedStatement = connection.prepareStatement(query);
			preparedStatement.execute();
			query="insert into t_shirt (codice,sesso,nome,categoria) values("+x+",'F','"+title+"','"+categoria+"');";
			preparedStatement = connection.prepareStatement(query);
			preparedStatement.execute();
			return x;
		} catch (SQLException e) {
			e.printStackTrace();
			return ""+0;
		}
	}
	public synchronized void delete(String id){
		String query="delete from t_shirt where codice="+id+";";
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		try {
			connection = DriverManager.getConnection(url);
			preparedStatement = connection.prepareStatement(query);
			preparedStatement.execute();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}