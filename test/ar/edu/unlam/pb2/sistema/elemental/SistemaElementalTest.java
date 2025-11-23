package ar.edu.unlam.pb2.sistema.elemental;

import static org.junit.Assert.*;
import java.util.Map;
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
    
    @Test
    public void queElConsejoDevuelvaNullSiNoHayCriaturasRegistradas() {
        Consejo consejo = new Consejo();
        
        // No se registran maestros
        
        Criatura poderosa = consejo.obtenerCriaturaMasPoderosa();
        
        assertNull(poderosa);
    }

    @Test(expected = MaestriaInsuficienteException.class)
    public void queUnMaestroNovatoNoPuedaEntrenarYLanceExcepcion() throws Exception {
        Maestro novato = new Maestro("Sokka", 1, Tipo.AGUA);
        CriaturaSalvaje criatura = new CriaturaSalvaje("Pez", 10, Tipo.AGUA);       
        novato.agregarCriatura(criatura);
        novato.entrenar("Pez"); 
       
   }

    @Test
    public void queElMaestroDevuelvaSusAtributosCorrectamente() {
        Maestro maestro = new Maestro("Toph", 80, Tipo.TIERRA);
        
        assertEquals("Toph", maestro.getNombre()); 
        assertEquals(Integer.valueOf(80), maestro.getNivelMaestria());
        assertEquals(Tipo.TIERRA, maestro.getAfinidad());
        assertNotNull(maestro.getCriaturas());
    }

    @Test(expected = EnergiaDesbordadaException.class)
    public void queUnaCriaturaSalvajeExploteSiEntrenaDemasiado() throws EnergiaDesbordadaException {
        // Validamos la regla de negocio (limite 200)
        CriaturaSalvaje salvaje = new CriaturaSalvaje("Boom", 190, Tipo.FUEGO);
        
        salvaje.entrenar();         // Entrena y Sube a 200 o más y Lanza Excepción

        salvaje.entrenar(); 
    }

    @Test
    public void queUnaCriaturaAncestralNoBajeDeCienDeEnergia() {
        CriaturaAncestral dragon = new CriaturaAncestral("Shenlong", 150, Tipo.AIRE);
        dragon.disminuirEnergia(100); // 150 - 100 = 50
        // Debe clavarse en 100
        assertEquals(Integer.valueOf(100), dragon.getEnergia());
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

    @Test
    public void queLlamaInternaAumenteEnergiaSoloAFuego() {
        Criatura pyros = new CriaturaSalvaje("Pyros", 100, Tipo.FUEGO);
        pyros = new LlamaInterna(pyros);
        // Fuego gana +30 = 130
        assertEquals(Integer.valueOf(130), pyros.getEnergia());
    }

    @Test
    public void queAscensoDelVientoCambieElTipoAAire() {
        Criatura roca = new CriaturaSalvaje("Roca", 50, Tipo.TIERRA);
        roca = new AscensoDelViento(roca);
        
        assertEquals(Tipo.AIRE, roca.getTipo());
        assertEquals("Roca", roca.getNombre());
    }


    @Test
    public void queCriaturasDelMismoTipoGanenEnergiaAlInteractuar() {
        Criatura criatura1 = new CriaturaDomesticada("A", 100, Tipo.AGUA);
        Criatura criatura2 = new CriaturaDomesticada("B", 100, Tipo.AGUA);
        
        criatura1.interactuarCon(criatura2);
        

        assertEquals(Integer.valueOf(110), criatura1.getEnergia());// Ambas ganan + 10
        assertEquals(Integer.valueOf(110), criatura2.getEnergia());
    }

    @Test
    public void queCriaturasOpuestasSeVuelvanInestables() {
        Criatura agua = new CriaturaSalvaje("Agua", 100, Tipo.AGUA);
        Criatura fuego = new CriaturaSalvaje("Fuego", 100, Tipo.FUEGO);
        
        agua.interactuarCon(fuego);
        
        // Ambas criaturas se vuelven inestables
        assertTrue(agua.esInestable());
        assertTrue(fuego.esInestable());
        
    }


    @Test
    public void queElConsejoGenereElReporteDeTiposCorrectamente() {
        Consejo consejo = new Consejo();
        Maestro maestro = new Maestro("Aang", 50, Tipo.AIRE);
        
        maestro.agregarCriatura(new CriaturaSalvaje("Dragon", 100, Tipo.FUEGO));
        maestro.agregarCriatura(new CriaturaDomesticada("Antorcha", 50, Tipo.FUEGO));
        maestro.agregarCriatura(new CriaturaAncestral("Appa", 200, Tipo.AIRE));
        
        consejo.registrarMaestro(maestro);
       
        Map<Tipo, Integer> reporte = consejo.obtenerCantidadPorTipo();
        
        assertEquals(Integer.valueOf(2), reporte.get(Tipo.FUEGO));
        assertEquals(Integer.valueOf(1), reporte.get(Tipo.AIRE));
        assertEquals(Integer.valueOf(0), reporte.get(Tipo.AGUA));
    }
    
    @Test
    public void queElConsejoDetecteLaCriaturaMasPoderosa() {
        Consejo consejo = new Consejo();
        Maestro yi = new Maestro("X", 10, Tipo.TIERRA);
        
        yi.agregarCriatura(new CriaturaSalvaje("Debil", 10, Tipo.TIERRA));
        yi.agregarCriatura(new CriaturaAncestral("Fuerte", 500, Tipo.TIERRA));
        
        consejo.registrarMaestro(yi);
        
        Criatura top = consejo.obtenerCriaturaMasPoderosa();
        assertEquals("Fuerte", top.getNombre());
    }
    
    @Test
    public void queUnaCriaturaAncestralGaneElCombateContraOtra() {
        // Ancestral (Tierra) vs Salvaje (Aire). 
        // serían opuestos, pero el Ancestral tiene prioridad.
        Criatura ancestral = new CriaturaAncestral("Gaia", 100, Tipo.TIERRA);
        Criatura salvaje = new CriaturaSalvaje("Viento", 100, Tipo.AIRE);
        
        ancestral.interactuarCon(salvaje);
        
        
      
        assertEquals(Integer.valueOf(120), ancestral.getEnergia()); //Ancestral gana 20 es 100 + 20 = 120
        
       
        assertEquals(Integer.valueOf(85), salvaje.getEnergia()); // el otro pierde 15 es 100 - 15 = 85
        
        assertFalse(ancestral.esInestable());
        assertFalse(salvaje.esInestable());
    }
    
    
}