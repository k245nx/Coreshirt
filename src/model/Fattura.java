package model;
import java.io.Serializable;
import java.util.Date;
public class Fattura implements Serializable{
	
	private static final long serialVersionUID = 1L;
	private String idFattura,indirizzoSpedizione;
	Ordine ordine;
	private double iva,totale;
	private Date data;
	
	public Fattura(String idFattura,Ordine ordine,String indirizzoSpedizione,double totale,Date data,double iva){
		this.idFattura=idFattura; //numero fattura
		this.ordine=ordine;
		this.indirizzoSpedizione=indirizzoSpedizione;
		this.totale=totale;
		this.iva=iva;
		this.data=data;
	}
	
	public String getIdFattura(){
		return idFattura;
	}
	
	public void setIdFattura(String idFattura){
		this.idFattura=idFattura;
	}
	

	public String getIndirizzoSpedizione(){
		return indirizzoSpedizione;
	}
	
	public void setIndirizzoSpedizione(String indirizzoSpedizione){
		this.indirizzoSpedizione=indirizzoSpedizione;
	}
	
	public double getTotale(){
		return totale;
	}
	
	public void setTotale(double totale){
		this.totale=totale;
	}
	
	
	public double getIva(){
		return iva;
	}
	
	public void setIva(double iva){
		this.iva=iva;
	}
	

	public Ordine getOrdine() {
		return ordine;
	}

	public void setOrdine(Ordine ordine) {
		this.ordine = ordine;
	}

	public Date getData() {
		return data;
	}

	public void setData(Date data) {
		this.data = data;
	}

}
