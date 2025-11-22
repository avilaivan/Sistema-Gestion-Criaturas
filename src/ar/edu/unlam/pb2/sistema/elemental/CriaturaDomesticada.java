package ar.edu.unlam.pb2.sistema.elemental;

public class CriaturaDomesticada extends Criatura {

    public CriaturaDomesticada(String nombre, Integer energia, Tipo tipo) {
        super(nombre, energia, tipo);
    }

    @Override
    public void entrenar() {
        this.energia = this.energia + 10;
    }

    @Override
    public void disminuirEnergia(Integer cantidad) {
        this.energia = this.energia - cantidad;
    }
}
