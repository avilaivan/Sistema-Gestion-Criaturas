package ar.edu.unlam.pb2.sistema.elemental;

public class CriaturaSalvaje extends Criatura {

    // Numeros sueltos o magicos a constantes
    private static final Integer POTENCIA_ENTRENAMIENTO = 50;
    private static final Integer ENERGIA_DESCONTROL = 200;

    public CriaturaSalvaje(String nombre, Integer energia, Tipo tipo) {
        super(nombre, energia, tipo);
    }

    @Override
    public void entrenar() throws EnergiaDesbordadaException {
        
        this.energia = this.energia + POTENCIA_ENTRENAMIENTO; 
        
        
        if (this.energia > ENERGIA_DESCONTROL) {
            throw new EnergiaDesbordadaException("¡La criatura " + nombre + " se ha descontrolado!");
        }
    }
  
    @Override
    public void disminuirEnergia(Integer cantidad) {
        this.energia = this.energia - cantidad;
    }
}
