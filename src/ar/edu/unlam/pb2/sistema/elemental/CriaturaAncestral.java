package ar.edu.unlam.pb2.sistema.elemental;

public class CriaturaAncestral extends Criatura {

    public CriaturaAncestral(String nombre, Integer energia, Tipo tipo) {
        super(nombre, energia, tipo);
    }

    @Override
    public void entrenar() {
        this.energia = this.energia + 20;
    }

    @Override
    public void disminuirEnergia(Integer cantidad) {
        Integer energiaEsperada = this.energia - cantidad;
        
        if (energiaEsperada < 100) {
            this.energia = 100;
        	} else {
        		this.energia = energiaEsperada;
        }
    }
}