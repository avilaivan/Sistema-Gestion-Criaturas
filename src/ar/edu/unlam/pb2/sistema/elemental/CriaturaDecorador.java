package ar.edu.unlam.pb2.sistema.elemental;

public abstract class CriaturaDecorador extends Criatura {
   
    protected Criatura criaturaDecorada;

    public CriaturaDecorador(Criatura criaturaAEnvolver) {
        super(criaturaAEnvolver.getNombre(), criaturaAEnvolver.getEnergia(), criaturaAEnvolver.getTipo()); 
        this.criaturaDecorada = criaturaAEnvolver;
    }

    
    @Override
    public String getNombre() {
        return criaturaDecorada.getNombre();
    }

    @Override
    public Integer getEnergia() {
        return criaturaDecorada.getEnergia();
    }

    @Override
    public Tipo getTipo() {
        return criaturaDecorada.getTipo();
    }

    @Override
    public Boolean esInestable() {
        return criaturaDecorada.esInestable();
    }
    
    @Override
    public void entrenar() throws EnergiaDesbordadaException {
        criaturaDecorada.entrenar();
    }
    
    @Override
    public void disminuirEnergia(Integer cantidad) {
        criaturaDecorada.disminuirEnergia(cantidad);
    }
}