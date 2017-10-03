package test;

import static org.junit.Assert.*;

import org.junit.Test;

import model.Articolo;
import model.TShirt;

public class TestTShirt {

	@Test
	public void testToString() {
		String nome="prova",sesso="M",colore="blu",taglia="M";
		int idArticolo=1,quantita=10;
		int prezzo=12;
		TShirt t=new TShirt(idArticolo, sesso, nome, colore, taglia, prezzo, quantita);
		String test=nome + " (" + idArticolo +" "+sesso+ "), "+colore+" "+taglia+" "+ 12.0+" "+quantita;
	    assertEquals(t.toString(),test);
	}

	@Test
	public void testTShirtIntStringStringStringStringInt() {
		String nome="prova",sesso="M",colore="blu",taglia="M";
		int idArticolo=1,quantita=10;
		TShirt t=new TShirt(idArticolo, sesso, nome, colore, taglia, quantita);
		assertEquals(t.getidArticolo(),idArticolo);
		assertEquals(t.getnome(),nome);
		assertEquals(t.getSesso(),sesso);
		assertEquals(t.getColore(),colore);
		assertEquals(t.getTaglia(),taglia);
		assertEquals(t.getquantita(),quantita);
		assertEquals(t.getprezzo(),12.0,0);
	}

	@Test
	public void testTShirtIntStringStringStringStringIntInt() {
		String nome="prova",sesso="M",colore="blu",taglia="M";
		int idArticolo=1,quantita=10;
		int prezzo=12;
		TShirt t=new TShirt(idArticolo, sesso, nome, colore, taglia, prezzo, quantita);
		assertEquals(t.getidArticolo(),idArticolo);
		assertEquals(t.getnome(),nome);
		assertEquals(t.getSesso(),sesso);
		assertEquals(t.getColore(),colore);
		assertEquals(t.getTaglia(),taglia);
		assertEquals(t.getquantita(),quantita);
		assertEquals(t.getprezzo(),12.0,0);
	}

	@Test
	public void testTShirtArticoloStringStringStringInt() {
		String nome="prova",sesso="M",colore="blu",taglia="M";
		int idArticolo=0,quantita=10;
		int prezzo=12;
		Articolo articolo=new Articolo(nome, prezzo, quantita, "geek");
		TShirt t=new TShirt(articolo, sesso, taglia, colore, quantita);
		assertEquals(t.getidArticolo(),idArticolo);
		assertEquals(t.getnome(),nome);
		assertEquals(t.getSesso(),sesso);
		assertEquals(t.getColore(),colore);
		assertEquals(t.getTaglia(),taglia);
		assertEquals(t.getquantita(),quantita);
		assertEquals(t.getprezzo(),12.0,0);
	}

	@Test
	public void testGetTaglia() {
		String nome="prova",sesso="M",colore="blu",taglia="M";
		int idArticolo=1,quantita=10;
		int prezzo=12;
		TShirt t=new TShirt(idArticolo, sesso, nome, colore, taglia, prezzo, quantita);
		assertEquals(t.getTaglia(),taglia);
	}

	@Test
	public void testSetTaglia() {
		String taglia="M";
		TShirt t=new TShirt();
		t.setTaglia(taglia);
		assertEquals(t.getTaglia(),taglia);
	}

	@Test
	public void testGetColore() {
		String nome="prova",sesso="M",colore="blu",taglia="M";
		int idArticolo=1,quantita=10;
		int prezzo=12;
		TShirt t=new TShirt(idArticolo, sesso, nome, colore, taglia, prezzo, quantita);
		assertEquals(t.getColore(),colore);
	}

	@Test
	public void testSetColore() {
		String colore="blu";
		TShirt t=new TShirt();
		t.setColore(colore);
		assertEquals(t.getColore(),colore);
	}

}
