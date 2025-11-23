package ar.edu.unlam.pb2.sistema.elemental;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Consejo {
    
    private List<Maestro> maestros;

    public Consejo() {
        this.maestros = new ArrayList<>();
    }

    public void registrarMaestro(Maestro maestro) {
        this.maestros.add(maestro);
    }

    // Lista todas las criaturas
    public List<Criatura> obtenerTodasLasCriaturas() {
        List<Criatura> todas = new ArrayList<>();
        
        // indice i de indiceMaestro
        for (int i = 0; i < this.maestros.size(); i++) {
            Maestro maestroActual = this.maestros.get(i);
            // Obtenemos las criaturas del map y las agregamos a la lista general
            todas.addAll(maestroActual.getCriaturas().values());
        }
        return todas;
    }

    // Criaturas con mayor energía
    public Criatura obtenerCriaturaMasPoderosa() {
        Criatura criaturaMasPoderosa = null;
        Integer maxEnergia = -1;
        
        //lista auxiliar para recorrer por índice
        
        List<Criatura> listaDeCriaturas = obtenerTodasLasCriaturas();
        // indice c de criatura
        for (int c = 0; c < listaDeCriaturas.size(); c++) {
            Criatura criaturaActual = listaDeCriaturas.get(c);
            
            
            if (criaturaActual.getEnergia() > maxEnergia) {
                maxEnergia = criaturaActual.getEnergia();
                criaturaMasPoderosa = criaturaActual;
            }
        }
        return criaturaMasPoderosa;
    }

    // lista para obtener por Tipo
    public Map<Tipo, Integer> obtenerCantidadPorTipo() {
        Map<Tipo, Integer> reporte = new HashMap<>();
        
        Tipo[] tiposDisponibles = Tipo.values();
        // indice t por tipo
        for (int t = 0; t < tiposDisponibles.length; t++) {
            Tipo tipoActual = tiposDisponibles[t];
            reporte.put(tipoActual, 0);
        }

        // contador de criaturas
        
        List<Criatura> listaDeCriaturas = obtenerTodasLasCriaturas();
        for (int indiceCriatura = 0; indiceCriatura < listaDeCriaturas.size(); indiceCriatura++) {
            Criatura criaturaActual = listaDeCriaturas.get(indiceCriatura);
            
            Tipo tipoDeLaCriatura = criaturaActual.getTipo();
            Integer cantidadActual = reporte.get(tipoDeLaCriatura);
            
            reporte.put(tipoDeLaCriatura, cantidadActual + 1);
        }
        return reporte;
    }
}