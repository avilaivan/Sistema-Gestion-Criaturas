package ar.edu.unlam.pb2.sistema.elemental;

import static org.junit.Assert.*;
import org.junit.Test;

public class SistemaElementalTest {

	@Test
	public void queSePuedaCrearUnaCriaturaSalvaje() {
		
		CriaturaSalvaje criatura = new CriaturaSalvaje("Pyros", 100, Tipo.FUEGO);
		assertEquals("Pyros", criatura.getNombre());
		assertEquals(Integer.valueOf(100), criatura.getEnergia());
	}
}