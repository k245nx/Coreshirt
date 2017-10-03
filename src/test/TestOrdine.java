package test;

import static org.junit.Assert.*;

import org.junit.Test;

import model.Ordine;

public class TestOrdine {

	@Test
	public void testSetIdOrdine() {
		Ordine x=new Ordine();
		x.setIdOrdine(12);
		assertEquals(x.getIdOrdine(),12);
	}

	@Test
	public void testSetIndirizzoSpedizione() {
		Ordine x=new Ordine();
		x.setIndirizzoSpedizione("prova");
		assertEquals(x.getIndirizzoSpedizione(),"prova");
	}

	@Test
	public void testSetTotale() {
		Ordine x=new Ordine();
		x.setTotale(0);
		assertEquals(x.getTotale(),0.0,0);
	}

	@Test
	public void testSetStato() {
		Ordine x=new Ordine();
		x.setStato("prova");
		assertEquals(x.getStato(),"prova");
	}

	@Test
	public void testSetIdCliente() {
		Ordine x=new Ordine();
		x.setIdCliente(12);
		assertEquals(x.getIdCliente(),12);
	}

	@Test
	public void testSetMetodoP() {
		Ordine x=new Ordine();
		x.setMetodoP("prova");
		assertEquals(x.getMetodoP(),"prova");
	}

	@Test
	public void testSetCap() {
		Ordine x=new Ordine();
		x.setCap("prova");
		assertEquals(x.getCap(),"prova");
	}

	@Test
	public void testSetData() {
		Ordine x=new Ordine();
		x.setData("prova");
		assertEquals(x.getData(),"prova");
	}

	@Test
	public void testSetPagamento() {
		Ordine x=new Ordine();
		x.setPagamento("prova");
		assertEquals(x.getPagamento(),"prova");
	}

	@Test
	public void testToString() {
		int idOrdine=0,totale=0;
		String data="prova";
		Ordine x=new Ordine();
		x.setIdOrdine(idOrdine);
		x.setTotale(totale);
		x.setData(data);
		x.setStato(data);
		x.setIndirizzoSpedizione(data);
		String test="Ordine [idOrdine=" + idOrdine + ", data=" + data + ", indirizzoSpedizione=" + data
				+ ", totale=" + 0.0 + ", stato=" + data + "]";
	    assertEquals(x.toString(),test);
	}

	@Test
	public void testToString2() {
		int idOrdine=0,totale=0;
		String data="prova";
		Ordine x=new Ordine();
		x.setIdOrdine(idOrdine);
		x.setTotale(totale);
		x.setData(data);
		String test="Ordine : "+idOrdine+", data : " + data +", totale : " + 0.0 ;
	    assertEquals(x.toString2(),test);
	}

}
