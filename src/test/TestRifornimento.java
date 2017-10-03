package test;

import static org.junit.Assert.*;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.junit.Test;

import model.Rifornimento;
import model.TShirt;

public class TestRifornimento {

	@Test
	public void testRifornimentoStringDoubleStringStringStringDateDate() {
		String idRifornimento,stato,idDipendente,dataRichiesta;
		idRifornimento=stato=idDipendente=dataRichiesta="prova";
		double totale=120.0;
		Rifornimento x=new Rifornimento(idRifornimento, totale, stato, idDipendente, dataRichiesta, null, null);
	    assertEquals(x.getIdRifornimento(),idRifornimento);
	    assertEquals(x.getTotale(),totale,0);
	    assertEquals(x.getStato(),idRifornimento);
	    assertEquals(x.getIdDipendente(),idRifornimento);
	    assertEquals(x.getDataRichiesta(),idRifornimento);
	    assertEquals(x.getDataConsegna(),null);
	    assertEquals(x.getDataEffettuazione(),null);
	}

	@Test
	public void testRifornimentoStringStringStringStringStringString() {
		String idDipendente="prova";
		Rifornimento x=new Rifornimento(idDipendente, "12", idDipendente, idDipendente, idDipendente, "12");
	    assertEquals(x.getTotale(),12*7.0,0);
	    assertEquals(x.getStato(),"inevaso");
	    assertEquals(x.getIdDipendente(),idDipendente);
	    assertEquals(x.getDataRichiesta(),new SimpleDateFormat("yyyy-MM-dd").format(new Date()));
	    assertEquals(x.getDataConsegna(),null);
	    assertEquals(x.getDataEffettuazione(),null);
	    TShirt t=new TShirt(Integer.parseInt("12"), idDipendente, "", idDipendente, idDipendente, Integer.parseInt("12"));
	    assertEquals(x.getTshirt(),t);
	}

	@Test
	public void testSetIdRifornimento() {
		Rifornimento r=new Rifornimento();
		r.setIdRifornimento("12");
		assertEquals(r.getIdRifornimento(),"12");
	}

	@Test
	public void testSetTotale() {
		Rifornimento r=new Rifornimento();
		r.setTotale(12);
		assertEquals(r.getTotale(),12.0,0);
	}

	@Test
	public void testSetStato() {
		Rifornimento r=new Rifornimento();
		r.setStato("12");
		assertEquals(r.getStato(),"12");
	}

	@Test
	public void testSetIdDipendete() {
		Rifornimento r=new Rifornimento();
		r.setIdDipendete("12");
		assertEquals(r.getIdDipendente(),"12");
	}

	@Test
	public void testSetDataRichiesta() {
		Rifornimento r=new Rifornimento();
		r.setDataRichiesta("12");
		assertEquals(r.getDataRichiesta(),"12");
	}

	@Test
	public void testSetDataEffettuazione() {
		Rifornimento r=new Rifornimento();
		r.setDataEffettuazione(null);
		assertEquals(r.getDataEffettuazione(),null);
	}

	@Test
	public void testSetDataConsegna() {
		Rifornimento r=new Rifornimento();
		r.setDataConsegna(null);
		assertEquals(r.getDataConsegna(),null);
	}

	@Test
	public void testSetTshirt() {
		String idDipendente="prova";
		Rifornimento r=new Rifornimento();
	    TShirt t=new TShirt(Integer.parseInt("12"), idDipendente, "", idDipendente, idDipendente, Integer.parseInt("12"));
		r.setTshirt(t);
		assertEquals(r.getTshirt(),t);
	}


	@Test
	public void testToString() {
		String idDipendente="prova";
		Rifornimento x=new Rifornimento(idDipendente, "12", idDipendente, idDipendente, idDipendente, "12");
	    TShirt t=new TShirt(Integer.parseInt("12"), idDipendente, "", idDipendente, idDipendente, Integer.parseInt("12"));
		String test="Rifornimento [tshirt=" + t + ", totale=" + 12*7.0 + ", dataRichiesta=" + new SimpleDateFormat("yyyy-MM-dd").format(new Date())
				+ ", dataEffettuazione=" + null + ", dataConsegna=" + null + "]";
        assertEquals(x.toString(),test);
	}

	@Test
	public void testToString2() {
		String idDipendente="prova";
		Rifornimento x=new Rifornimento(idDipendente, "12", idDipendente, idDipendente, idDipendente, "12");
		String test="Richiesta : "+0+", data richiesta : " + new SimpleDateFormat("yyyy-MM-dd").format(new Date())
				+ ", data accettazione : " + null + ", totale : " + 12*7.0;
		assertEquals(x.toString2(0),test);
	}

}
