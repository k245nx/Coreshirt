package model;

import java.io.Serializable;

public class Dipendente implements Serializable{
	
	private static final long serialVersionUID = 1L;
	private String nome,cognome,codiceFiscale,tipo,username,password,id,dataP;
	double stipendio;
	public String getDataP() {
		return dataP;
	}

	public void setDataP(String dataP) {
		this.dataP = dataP;
	}
	
	public Dipendente(){}
	
	public String getNome(){
		return nome;
	}
	
	public void setNome(String nome){
		this.nome=nome;
	}
	
	public String getCognome(){
		return cognome;
	}
	
	public void setCognome(String cognome){
		this.cognome=cognome;
	}
	
	public String getCodiceFiscale(){
		return codiceFiscale;
	}
	
	public void setCodiceFiscale(String codiceFiscale){
		this.codiceFiscale=codiceFiscale;
	}
	
	public String getId(){
		return id;
	}
	
	public void setId(String id){
		this.id=id;
	}
	
	public String getTipo(){
		return tipo;
	}
	
	public void setTipo(String tipo){
		this.tipo=tipo;
	}
	
	public double getStipendio(){
		return stipendio;
	}
	
	public void setStipendio(double stipendio){
		this.stipendio=stipendio;
	}
	
	public String getUsername(){
		return username;
	}
	
	public void setUsername(String username){
		this.username=username;
	}
	
	public String getPassword(){
		return password;
	}
	
	public void setPassword(String password){
		this.password=password;
	}

	public String toString2() {
		return "Dipendente: " + nome + " " + cognome + ", codiceFiscale : "
				+ codiceFiscale + ", stipendio : " + stipendio;
	}

	@Override
	public String toString() {
		return "Dipendente [nome=" + nome + ", cognome=" + cognome + ", codiceFiscale=" + codiceFiscale + ", tipo="
				+ tipo + ", username=" + username + ", password=" + password + ", id=" + id + ", stipendio=" + stipendio
				+ "]";
	}
	
	
}
