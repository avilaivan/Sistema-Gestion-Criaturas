package ar.edu.unlam.pb2.sistema.elemental;

public abstract class Criatura {
    
    
    private static final Integer BONUS_ANCESTRAL = 20;
    private static final Integer PENALIZACION_ANCESTRAL = 15;
    private static final Integer BONUS_MISMO_TIPO = 10;

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
        
        // Si es ancestral y el otro no, gana ancestral 
        if (this instanceof CriaturaAncestral && !(otra instanceof CriaturaAncestral)) {
            this.recibirEnergia(BONUS_ANCESTRAL); // + 20 
            otra.disminuirEnergia(PENALIZACION_ANCESTRAL); // - 15
            return; 
        }
        
        // Si el otro es ancestral y yo no, gana el otro
        if (!(this instanceof CriaturaAncestral) && otra instanceof CriaturaAncestral) {
            this.disminuirEnergia(PENALIZACION_ANCESTRAL);
            otra.recibirEnergia(BONUS_ANCESTRAL);
            return;
        }

        // Si son del mismo tipo, ambos ganaran energia
        if (this.tipo == otra.getTipo()) {
            this.recibirEnergia(BONUS_MISMO_TIPO); //ambos + 10
            otra.recibirEnergia(BONUS_MISMO_TIPO);
            return;
        }

        // Si son opuestos, ambos se vuelven inestables
        if (sonOpuestos(this.tipo, otra.getTipo())) {
            this.setInestable(Boolean.TRUE);
            otra.setInestable(Boolean.TRUE);
        }
    }

    protected void recibirEnergia(Integer cantidad) {
        this.energia = this.energia + cantidad;
    }
    
    public void setInestable(Boolean estado) {
        this.inestable = estado;
    }

    private Boolean sonOpuestos(Tipo tipo1, Tipo tipo2) {
        if ((tipo1 == Tipo.AGUA && tipo2 == Tipo.FUEGO) || (tipo1 == Tipo.FUEGO && tipo2 == Tipo.AGUA)) {
            return true;
        }
        if ((tipo1 == Tipo.AIRE && tipo2 == Tipo.TIERRA) || (tipo1 == Tipo.TIERRA && tipo2 == Tipo.AIRE)) {
            return true;
        }
        return false;
    }
}










