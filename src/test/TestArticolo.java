package test;

import static org.junit.Assert.*;

import org.junit.Test;

import model.Articolo;

public class TestArticolo {

	@Test
	public void testArticoloIntStringDoubleIntString() {
		Articolo x=new Articolo(1,"prova",12.0,10,"geek");
		assertEquals(x.getidArticolo(),1);
		assertEquals(x.getnome(),"prova");
		assertEquals(x.getprezzo(),12.0,0);
		assertEquals(x.getquantita(),10,0);
		assertEquals(x.getcategoria(),"geek");
	}

	@Test
	public void testArticoloSetter() {
		Articolo x=new Articolo();
		assertEquals(x.getidArticolo(),-1);
		assertEquals(x.getnome(),"");
		assertEquals(x.getprezzo(),12,0);
		assertEquals(x.getquantita(),0,0);
		assertEquals(x.getcategoria(),"");
		assertEquals(x.getSesso(),"");
		x.setId(1);
		x.setnome("prova");
		x.setquantita(10);
		x.setcategoria("geek");
		assertEquals(x.getidArticolo(),1);
		assertEquals(x.getnome(),"prova");
		assertEquals(x.getprezzo(),12.0,0);
		assertEquals(x.getquantita(),10,0);
		assertEquals(x.getcategoria(),"geek");
	}

	@Test
	public void testArticoloStringDoubleIntString() {
		Articolo x=new Articolo("prova", 12.0, 10, "geek");
		assertEquals(x.getnome(),"prova");
		assertEquals(x.getprezzo(),12.0,0);
		assertEquals(x.getquantita(),10,0);
		assertEquals(x.getcategoria(),"geek");
	}

	@Test
	public void testGetidArticolo() {
		Articolo x=new Articolo();
		assertEquals(x.getidArticolo(),-1);
	}

	@Test
	public void testGetquantita() {
		Articolo x=new Articolo();
		assertEquals(x.getquantita(),0,0);
	}

	@Test
	public void testGetnome() {
		Articolo x=new Articolo();
		assertEquals(x.getnome(),"");
	}

	@Test
	public void testGetSesso() {
		Articolo x=new Articolo();
		assertEquals(x.getSesso(),"");
	}

	@Test
	public void testGetprezzo() {
		Articolo x=new Articolo();
		assertEquals(x.getprezzo(),12,0);
	}

	@Test
	public void testGetcategoria() {
		Articolo x=new Articolo();
		assertEquals(x.getcategoria(),"");
	}

	@Test
	public void testToString() {
		String nome="prova";
		int idArticolo=1;
		Articolo x=new Articolo(idArticolo,nome,12.0,10,"geek");
		String test=nome + " (" + idArticolo +" "+"null"+ "), "+ 12.0+" "+10;
		assertEquals(x.toString(),test);
	}

}
