package ar.edu.unlam.pb2.sistema.elemental;

public class CriaturaSalvaje extends Criatura {

    public CriaturaSalvaje(String nombre, Integer energia, Tipo tipo) {
        super(nombre, energia, tipo);
    }

    @Override
    public void entrenar() throws EnergiaDesbordadaException {
        this.energia = this.energia + 50; 
        
        if (this.energia > 200) {
            throw new EnergiaDesbordadaException("¡La criatura " + nombre + " se ha descontrolado!");
        }
    }
  
    @Override
    public void disminuirEnergia(Integer cantidad) {
        this.energia = this.energia - cantidad;
    }
    
    
    
    
}