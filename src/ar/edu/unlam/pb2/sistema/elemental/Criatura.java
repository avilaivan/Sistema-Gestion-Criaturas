package ar.edu.unlam.pb2.sistema.elemental;

public abstract class Criatura {
    protected String nombre;
    protected Integer energia;
    protected Tipo tipo;
    protected Boolean inestable;

    public Criatura(String nombre, Integer energia, Tipo tipo) {
        this.nombre = nombre;
        this.energia = energia;
        this.tipo = tipo;
        this.inestable = Boolean.FALSE;
    }

    public String getNombre() {
        return nombre;
    }

    public Integer getEnergia() {
        return energia;
    }

    public Tipo getTipo() {
        return tipo;
    }


    public Boolean esInestable() {
        return inestable;
    }

    public abstract void entrenar() throws EnergiaDesbordadaException;
    public abstract void disminuirEnergia(Integer cantidad);

    public void interactuarCon(Criatura otra) {
        if (this.tipo.equals(otra.getTipo())) {
            this.energia = this.energia + 10;
            otra.recibirEnergia(10);
        }
    }
    protected void recibirEnergia(Integer cantidad) {
        this.energia = this.energia + cantidad;
    }
}















