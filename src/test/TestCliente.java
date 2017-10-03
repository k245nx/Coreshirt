package test;

import static org.junit.Assert.*;

import org.junit.Test;

import model.Cliente;

public class TestCliente {

	@Test
	public void testClienteStringStringStringStringString() {
		String idCliente="0",nome="prova",cognome="prova",email="prova",recapito="prova";
		Cliente c=new Cliente(idCliente, nome, cognome, email, recapito);
		assertEquals(c.getIdCliente(),"0");
		assertEquals(c.getNome(),nome);
		assertEquals(c.getCognome(),cognome);
		assertEquals(c.getEmail(),email);
		assertEquals(c.getRecapito(),recapito);
	}

	@Test
	public void testSetIdCliente() {
		String idCliente="0";
		Cliente c=new Cliente();
		c.setIdCliente(idCliente);
		assertEquals(c.getIdCliente(),idCliente);
	}

	@Test
	public void testSetNome() {
		String nome="prova";
		Cliente c=new Cliente();
		c.setNome(nome);
		assertEquals(c.getNome(),nome);
	}

	@Test
	public void testSetCognome() {
		String cognome="prova";
		Cliente c=new Cliente();
		c.setCognome(cognome);
		assertEquals(c.getCognome(),cognome);
	}

	@Test
	public void testSetEmail() {
		String email="prova";
		Cliente c=new Cliente();
		c.setEmail(email);
		assertEquals(c.getEmail(),email);
	}

	@Test
	public void testSetRecapito() {
		String recapito="prova";
		Cliente c=new Cliente();
		c.setRecapito(recapito);
		assertEquals(c.getRecapito(),recapito);
	}

}
