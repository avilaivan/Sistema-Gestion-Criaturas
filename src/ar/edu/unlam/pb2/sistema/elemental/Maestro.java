package ar.edu.unlam.pb2.sistema.elemental;

import java.util.HashMap;
import java.util.Map;

public class Maestro {
    private String nombre;
    private Integer nivelMaestria; 
    private Tipo afinidad;
    
    private Map<String, Criatura> criaturas;

    public Maestro(String nombre, Integer nivelMaestria, Tipo afinidad) {
        this.nombre = nombre;
        this.nivelMaestria = nivelMaestria;
        this.afinidad = afinidad;
        this.criaturas = new HashMap<>(); 
    }

    public void agregarCriatura(Criatura criatura) {
        
        this.criaturas.put(criatura.getNombre(), criatura);
    }

    public Criatura buscarCriatura(String nombre) {
        return this.criaturas.get(nombre);
    }

    // Método que puede fallar (throws)
    public void entrenar(String nombreCriatura) throws MaestriaInsuficienteException, EnergiaDesbordadaException {
        Criatura criatura = this.criaturas.get(nombreCriatura);
        
        if (criatura != null) {
            
            if (this.nivelMaestria < 5) { 
                throw new MaestriaInsuficienteException("Nivel insuficiente para entrenar.");
            }
            
            
            criatura.entrenar();
        }
    }
}