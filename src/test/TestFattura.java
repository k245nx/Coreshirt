package test;

import static org.junit.Assert.*;

import java.util.Date;

import org.junit.Test;

import model.Fattura;
import model.Ordine;

public class TestFattura {

	@Test
	public void testSetIdFattura() {
		Fattura f=new Fattura(null, null,null,0,new Date(),22);
		f.setIdFattura("12");
		assertEquals(f.getIdFattura(),"12");
	}

	@Test
	public void testSetIndirizzoSpedizione() {
		Fattura f=new Fattura(null, null,null,0,new Date(),22);
		f.setIndirizzoSpedizione("12");
		assertEquals(f.getIndirizzoSpedizione(),"12");
	}

	@Test
	public void testSetTotale() {
		Fattura f=new Fattura(null, null,null,0,new Date(),22);
		f.setTotale(120);
		assertEquals(f.getTotale(),120.0,0);
	}

	@Test
	public void testSetIva() {
		Fattura f=new Fattura(null, null,null,0,new Date(),22);
		f.setIva(12);
		assertEquals(f.getIva(),12.0,0);
	}

	@Test
	public void testSetOrdine() {
		Fattura f=new Fattura(null, null,null,0,new Date(),22);
		f.setOrdine(new Ordine());
		assertEquals(f.getOrdine(),new Ordine());
	}

	@Test
	public void testSetData() {
		Fattura f=new Fattura(null, null,null,0,new Date(),22);
		f.setData(new Date());
		assertEquals(f.getData(),new Date());
	}
	
	@Test
	public void testFattura() {
		Fattura f=new Fattura("12",new Ordine(),"12",0,new Date(),22);
		assertEquals(f.getIdFattura(),"12");
		assertEquals(f.getOrdine(),new Ordine());
		assertEquals(f.getIndirizzoSpedizione(),"12");
		assertEquals(f.getTotale(),0,0);
		assertEquals(f.getData(),new Date());
		assertEquals(f.getIva(),22.0,0);
	}

}
