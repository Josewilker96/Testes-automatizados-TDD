package br.com.alura.tdd.service;

import static org.junit.Assert.assertEquals;

import java.math.BigDecimal;
import java.time.LocalDate;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import br.com.alura.tdd.modelo.Desempenho;
import br.com.alura.tdd.modelo.Funcionario;

public class ReajusteServiceTest {

	private ReajusteService service;
	private Funcionario funcionario;
	
	@Before
	public void inicializar() {
		System.out.println("Inicializar");
		this.service = new ReajusteService();
		this.funcionario = new Funcionario("Manoel", LocalDate.now(), new BigDecimal("1000.00"));
	}
	
	@BeforeClass
	public static void antesDeTodos(){ 
		System.out.println("Antes de todos");
	}
	
	@AfterClass
	public static void depoisDeTodos() {
		System.out.println("Depois de todos");
	}

	@After
	public void finalizar() {
		System.out.println("Fim");
	}
	
	@Test
	public void reajusteDeveriaSerDeTresPorCentoQuandoDesempenhoForADesejar() {
		
		service.consederReajuste(funcionario, Desempenho.A_DESEJAR);
		assertEquals(new BigDecimal("1030.00"), funcionario.getSalario());
	}
	
	@Test
	public void reajusteDeveriaSerDeQuinzePorCentoQuandoDesempenhoForADesejar() {
		service.consederReajuste(funcionario, Desempenho.BOM);
		assertEquals(new BigDecimal("1150.00"), funcionario.getSalario());
	}
	
	@Test
	public void reajusteDeveriaSerDeVintePorCentoQuandoDesempenhoForADesejar() {
		service.consederReajuste(funcionario, Desempenho.OTIMO);
		assertEquals(new BigDecimal("1200.00"), funcionario.getSalario());
	}
}
