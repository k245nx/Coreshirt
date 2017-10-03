package test;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Test;

import model.Cart;
import model.TShirt;

public class TestCart {

	@Test
	public void testCart() {
		Cart c=new Cart();
		assertEquals(c.getProducts(),new ArrayList<TShirt>());
		assertEquals(c.getTotal(),0,0);
		assertEquals(c.getShipment(),0,0);
	}

	@Test
	public void testAddItem() {
		int id=1;
		String sesso="M", tg="M", col="red";
		TShirt t=new TShirt();
		t.setId(id);
		t.setSesso(sesso);
		t.setTaglia(tg);
		t.setColore(col);
		t.setquantita(1);
		Cart c=new Cart();
		c.addItem(t);
		assertEquals(c.getTotal(),15,0);
	}

	@Test
	public void testDeleteItem() {
		int id=1;
		String sesso="M", tg="M", col="red";
		TShirt t=new TShirt();
		t.setId(id);
		t.setSesso(sesso);
		t.setTaglia(tg);
		t.setColore(col);
		t.setquantita(1);
		Cart c=new Cart();
		c.addItem(t);
		c.deleteItem(t.getidArticolo(), t.getSesso(), t.getColore(), t.getTaglia());
	    assertEquals(c.getTotal(),0,0);
	}

	@Test
	public void testModifyT() {
		int id=1;
		String sesso="M", tg="M", col="red", tg1="L";
		TShirt t=new TShirt();
		t.setId(id);
		t.setSesso(sesso);
		t.setTaglia(tg);
		t.setColore(col);
		t.setquantita(1);
		Cart c=new Cart();
		c.addItem(t);
		c.modifyT(id, sesso, tg1, col, tg);
		TShirt x=c.getProducts().get(0);
		assertEquals("L",x.getTaglia());
	}

	@Test
	public void testModifyQ() {
		int id=1,q=10;
		String sesso="M", tg="M", col="red";
		TShirt t=new TShirt();
		t.setId(id);
		t.setSesso(sesso);
		t.setTaglia(tg);
		t.setColore(col);
		t.setquantita(1);
		Cart c=new Cart();
		c.addItem(t);
		c.modifyQ(id, sesso, q, col, tg);
		TShirt x=c.getProducts().get(0);
		assertEquals(x.getquantita(),10,0);
	}

	@Test
	public void testDelete() {
		int id=1;
		String sesso="M", tg="M", col="red";
		TShirt t=new TShirt();
		t.setId(id);
		t.setSesso(sesso);
		t.setTaglia(tg);
		t.setColore(col);
		t.setquantita(1);
		Cart c=new Cart();
		c.addItem(t);
        c.delete();
        assertEquals(c.getProducts(),new ArrayList<TShirt>());
        assertEquals(c.getTotal(),0,0);
	}

	@Test
	public void testGetProducts() {
		Cart c=new Cart();
		assertEquals(c.getProducts(),new ArrayList<TShirt>());
	}

	@Test
	public void testGetTotal() {
		Cart c=new Cart();
		assertEquals(c.getTotal(),0,0);
	}

	@Test
	public void testGetShipment() {
		Cart c=new Cart();
		assertEquals(c.getShipment(),0,0);
	}

	@Test
	public void testGetShipmentString() {
		Cart c=new Cart();
		assertEquals(c.getShipmentString(),"Gratis!");
	}

}
