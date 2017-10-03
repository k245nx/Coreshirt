package test;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Suite.class)
@SuiteClasses({ TestArticolo.class, TestCart.class, TestCliente.class, TestDipendente.class, TestFattura.class,
		TestOrdine.class, TestRifornimento.class, TestSpesa.class, TestTShirt.class })
public class AllTestsModel {

}
