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


    @Test
    public void queUnMaestroPuedaAgregarUnaCriaturaASuColeccion() {
        Maestro maestro = new Maestro("Aang", 50, Tipo.AIRE);
        CriaturaSalvaje criatura = new CriaturaSalvaje("Appa", 100, Tipo.AIRE);
        maestro.agregarCriatura(criatura);
        Criatura encontrada = maestro.buscarCriatura("Appa");
        assertNotNull(encontrada);
        assertEquals(criatura, encontrada);
    }

    @Test(expected = MaestriaInsuficienteException.class)
    public void queUnMaestroNovatoNoPuedaEntrenarYLanceExcepcion() throws Exception {
        Maestro novato = new Maestro("Sokka", 1, Tipo.AGUA);
        CriaturaSalvaje criatura = new CriaturaSalvaje("Pez", 10, Tipo.AGUA);       
        novato.agregarCriatura(criatura);
        novato.entrenar("Pez"); 
    }
    
    @Test
    public void queSePuedaTransformarUnaCriaturaConBendicionDelRio() {
        Criatura criatura = new CriaturaSalvaje("Nami", 50, Tipo.AGUA);
        criatura = new BendicionDelRio(criatura);
        assertEquals(Integer.valueOf(100), criatura.getEnergia());
    }
    
    @Test
    public void queLaBendicionDelRioNoSupereElTope() { 
        Criatura criatura = new CriaturaSalvaje("Tsunami", 100, Tipo.AGUA);
        criatura = new BendicionDelRio(criatura);     
        assertEquals(Integer.valueOf(180), criatura.getEnergia());
    }
    
    
    
    
    
}