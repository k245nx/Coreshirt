package test;

import static org.junit.Assert.*;

import org.junit.Test;

import model.Dipendente;

public class TestDipendente {

	@Test
	public void testSetDataP() {
		Dipendente d=new Dipendente();
		d.setDataP("prova");
		assertEquals(d.getDataP(),"prova");
	}

	@Test
	public void testSetNome() {
		Dipendente d=new Dipendente();
		d.setNome("prova");
		assertEquals(d.getNome(),"prova");
	}

	@Test
	public void testSetCognome() {
		Dipendente d=new Dipendente();
		d.setCognome("prova");
		assertEquals(d.getCognome(),"prova");
	}

	@Test
	public void testSetCodiceFiscale() {
		Dipendente d=new Dipendente();
		d.setCodiceFiscale("prova");
		assertEquals(d.getCodiceFiscale(),"prova");
	}

	@Test
	public void testSetId() {
		Dipendente d=new Dipendente();
		d.setId("1");
		assertEquals(d.getId(),"1");
	}

	@Test
	public void testSetTipo() {
		Dipendente d=new Dipendente();
		d.setTipo("prova");
		assertEquals(d.getTipo(),"prova");
	}

	@Test
	public void testSetStipendio() {
		Dipendente d=new Dipendente();
		d.setStipendio(1500);
		assertEquals(d.getStipendio(),1500.0,0);
	}

	@Test
	public void testSetUsername() {
		Dipendente d=new Dipendente();
		d.setUsername("prova");
		assertEquals(d.getUsername(),"prova");
	}

	@Test
	public void testSetPassword() {
		Dipendente d=new Dipendente();
		d.setPassword("prova");
		assertEquals(d.getPassword(),"prova");
	}

	@Test
	public void testToString2() {
		String nome="prova",cognome="prova",codiceFiscale="prova";
		Dipendente d=new Dipendente();
		d.setCodiceFiscale(codiceFiscale);
		d.setCognome(cognome);
		d.setNome(nome);
		d.setStipendio(1500);
		String test="Dipendente: " + nome + " " + cognome + ", codiceFiscale : "
				+ codiceFiscale + ", stipendio : " + 1500.0;
		assertEquals(d.toString2(),test);
	}

	@Test
	public void testToString() {
		String nome="prova",cognome="prova",codiceFiscale="prova",tipo="prova",id="0";
		Dipendente d=new Dipendente();
		d.setCodiceFiscale(codiceFiscale);
		d.setCognome(cognome);
		d.setNome(nome);
		d.setStipendio(1500);
		d.setTipo(tipo);
		d.setUsername(tipo);
		d.setPassword(tipo);
		d.setId(id);
		String test="Dipendente [nome=" + nome + ", cognome=" + cognome + ", codiceFiscale=" + codiceFiscale + ", tipo="
				+ tipo + ", username=" + tipo + ", password=" + tipo+ ", id=" + id + ", stipendio=" + 1500.0
				+ "]";
		assertEquals(d.toString(),test);
	}

}
