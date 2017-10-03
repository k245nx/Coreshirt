package model;

public class TShirt extends Articolo{

	private static final long serialVersionUID = 1L;
	private String taglia;
	private String colore;
	public TShirt(int id,String sesso,String nome,String colore,String taglia,int quantity){
		this.taglia = taglia;
		this.colore = colore;
		this.idArticolo= id;
		this.sesso = sesso;
		this.nome = nome;
		this.prezzo = 12.0;
		this.quantita=quantity;
	}

	public TShirt(int id, String sesso, String nome, String colore, String taglia, int prezzo, int quantity) {
		this.taglia = taglia;
		this.colore = colore;
		this.idArticolo= id;
		this.sesso = sesso;
		this.nome = nome;
		this.prezzo = prezzo;
		this.quantita=quantity;
	}

	public TShirt(Articolo x,String sesso,String taglia,String colore,int quantita){
		this.taglia = taglia;
		this.colore = colore;
		this.idArticolo= x.getidArticolo();
		this.sesso = sesso;
		this.nome = x.getnome();
		this.prezzo = x.getprezzo();
		this.quantita=quantita;
	}

	public TShirt() {
		// TODO Auto-generated constructor stub
	}

	public String getTaglia() {
		return taglia;
	}
	public void setTaglia(String taglia) {
		this.taglia = taglia;
	}
	public String getColore() {
		return colore;
	}
	public void setColore(String colore) {
		this.colore = colore;
	}
	public boolean equals(Object i){
		TShirt x=(TShirt)i;
		return((x.getidArticolo()==idArticolo)&&(x.getSesso().equals(sesso))&&(x.getTaglia().equals(taglia))&&(x.getColore().equalsIgnoreCase(colore)));
	}
	@Override
	public String toString() {
		return nome + " (" + idArticolo +" "+sesso+ "), "+colore+" "+taglia+" "+ prezzo+" "+quantita;
	}
}
