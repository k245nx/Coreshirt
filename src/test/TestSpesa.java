package test;

import static org.junit.Assert.*;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.junit.Test;

import model.Spesa;

public class TestSpesa {

	@Test
	public void testSpesa() {
		Date data=new Date();
		Spesa s=new Spesa(0, data, "prova");
		assertEquals(s.getAmmontare(),0,0);
		assertEquals(s.getData(),new SimpleDateFormat("yyyy-MM-dd").format(data));
		assertEquals(s.getDescrizione(),"prova");
	}

	@Test
	public void testSetIdSpesa() {
		Date data=new Date();
		Spesa s=new Spesa(0, data, "prova");
		s.setIdSpesa("12");
		assertEquals(s.getIdSpesa(),"12");
	}

	@Test
	public void testSetAmmontare() {
		Date data=new Date();
		Spesa s=new Spesa(0, data, "prova");
		s.setAmmontare(120);
		assertEquals(s.getAmmontare(),120.0,0);
	}

	@Test
	public void testSetDescrizione() {
		Date data=new Date();
		Spesa s=new Spesa(0, data, "prova");
		s.setDescrizione("prova2");
		assertEquals(s.getDescrizione(),"prova2");
	}

	@Test
	public void testSetDate() {
		Date data=new Date(),data2=new Date();
		Spesa s=new Spesa(0, data, "prova");
		s.setDate(data2);
		assertEquals(s.getData(),new SimpleDateFormat("yyyy-MM-dd").format(data));
	}

	@Test
	public void testToString2() {
		Date data=new Date();
		Spesa s=new Spesa(0, data, "prova");
		String test="Spesa : " + 0 + ", data : " +new SimpleDateFormat("yyyy-MM-dd").format(data)+ ", ammontare : " + 0.0;
		assertEquals(s.toString2(0),test);
	}

}
