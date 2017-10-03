package model;

import java.io.Serializable;

public class Ordine implements Serializable{
	
	private static final long serialVersionUID = 1L;
	String stato,indirizzoSpedizione,metodoP,pagamento;
	double totale;
	String data,cap;
	int idOrdine,idCliente;
	
	public Ordine(){
		
	}
	
	public int getIdOrdine(){
		return idOrdine;
	}
	
	public void setIdOrdine(int idOrdine){
		this.idOrdine=idOrdine;
	}
	
	public double getTotale(){
		return totale;
	}
	public String getIndirizzoSpedizione(){
		return indirizzoSpedizione;
	}
	
	public void setIndirizzoSpedizione(String indirizzoSpedizione){
		this.indirizzoSpedizione=indirizzoSpedizione;
	}
	
	public void setTotale(double totale){
		this.totale=totale;
	}
	
	public String getStato(){
		return stato;
	}
	
	public void setStato(String stato){
		this.stato=stato;
	}
	
	public int getIdCliente(){
		return idCliente;
	}
	
	public void setIdCliente(int idCliente){
		this.idCliente=idCliente;
	}
	
	public String getMetodoP(){
		return metodoP;
	}
	
	public void setMetodoP(String metodoP){
		this.metodoP=metodoP;
	}
	
	public void setCap(String cap){
		this.cap=cap;
	}
	
	public String getCap(){
		return cap;
	}
	
	public String getData(){
		return data;
	}
	
	public void setData(String data){
		this.data=data;
	}
	
	public void setPagamento(String pagamento){
		this.pagamento=pagamento;
	}
	
	public String getPagamento(){
		return pagamento;
	}

	@Override
	public String toString() {
		return "Ordine [idOrdine=" + idOrdine + ", data=" + data + ", indirizzoSpedizione=" + indirizzoSpedizione
				+ ", totale=" + totale + ", stato=" + stato + "]";
	}
	
	public String toString2(){
		return "Ordine : "+idOrdine+", data : " + data +", totale : " + totale ; 
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Ordine other = (Ordine) obj;
		if (cap == null) {
			if (other.cap != null)
				return false;
		} else if (!cap.equals(other.cap))
			return false;
		if (data == null) {
			if (other.data != null)
				return false;
		} else if (!data.equals(other.data))
			return false;
		if (idCliente != other.idCliente)
			return false;
		if (idOrdine != other.idOrdine)
			return false;
		if (indirizzoSpedizione == null) {
			if (other.indirizzoSpedizione != null)
				return false;
		} else if (!indirizzoSpedizione.equals(other.indirizzoSpedizione))
			return false;
		if (metodoP == null) {
			if (other.metodoP != null)
				return false;
		} else if (!metodoP.equals(other.metodoP))
			return false;
		if (pagamento == null) {
			if (other.pagamento != null)
				return false;
		} else if (!pagamento.equals(other.pagamento))
			return false;
		if (stato == null) {
			if (other.stato != null)
				return false;
		} else if (!stato.equals(other.stato))
			return false;
		if (Double.doubleToLongBits(totale) != Double.doubleToLongBits(other.totale))
			return false;
		return true;
	}
	
	

}
