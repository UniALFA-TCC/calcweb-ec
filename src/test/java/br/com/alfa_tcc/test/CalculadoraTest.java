package br.com.alfa_tcc.test;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import br.com.alfa_tcc.controle.CalculadoraMB;

@RunWith(JUnit4.class)
public class CalculadoraTest {
	
	CalculadoraMB mb;
	
	@Before
	public void setUp() throws Exception{
		mb = new CalculadoraMB();
		mb.getBean().setN1(2);
		mb.getBean().setN2(1);
		
	}

	@Test
	public void testCalcularSoma() {
		
		mb.getBean().setOperador('+');
		
		assertEquals(true, mb.calcular() == 3);
	}
	
	@Test
	public void testCalcularSubtracao() {
		
		mb.getBean().setOperador('-');
		
		assertEquals(true, mb.calcular() == 1);
	}
	
	@Test
	public void testCalcularDivisao() {

		mb.getBean().setOperador('/');
		
		assertEquals(true, mb.calcular() == 2);
	}
	
	@Test
	public void testCalcularMultiplicacao() {
		
		mb.getBean().setOperador('*');
		
		assertEquals(true, mb.calcular() == 2);
	}

}
