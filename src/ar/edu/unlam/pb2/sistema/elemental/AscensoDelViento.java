package ar.edu.unlam.pb2.sistema.elemental;

public class AscensoDelViento extends CriaturaDecorador {

    public AscensoDelViento(Criatura criaturaAEnvolver) {
        super(criaturaAEnvolver);
    }

    @Override
    public Tipo getTipo() {
  
        return Tipo.AIRE;
    }
}
