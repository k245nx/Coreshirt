package model;
import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;
public class Spesa implements Serializable{

	private static final long serialVersionUID = 1L;
	public String idSpesa;
	public String descrizione;
	public String data;
	public double ammontare;
	
	public Spesa(double ammontare,Date data,String descrizione){
		this.ammontare=ammontare;
		this.data=new SimpleDateFormat("yyyy-MM-dd").format(data);
		this.descrizione=descrizione;
	}
	
	public String getIdSpesa(){
		return idSpesa;
	}
	
	public void setIdSpesa(String idSpesa){
		this.idSpesa=idSpesa;
	}
	
	public double getAmmontare(){
		return ammontare;
	}
	
	public void setAmmontare(double ammontare){
		this.ammontare=ammontare;
	}
	
	public String getDescrizione(){
		return descrizione;
	}
	
	public void setDescrizione(String descrizione){
		this.descrizione=descrizione;
	}
	
	public String getData(){
		return data;
	}
	
	public void setDate(Date data){
		this.data=new SimpleDateFormat("yyyy-MM-dd").format(data);
	}

	public String toString2(int i) {
		return "Spesa : " + i + ", data : " + data + ", ammontare : " + ammontare;
	}

	
}
