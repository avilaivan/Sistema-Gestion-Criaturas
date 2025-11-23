package ar.edu.unlam.pb2.sistema.elemental;

public class LlamaInterna extends CriaturaDecorador {

    public LlamaInterna(Criatura criaturaAEnvolver) {
        super(criaturaAEnvolver);
    }

    @Override
    public Integer getEnergia() {
        if (getTipo() == Tipo.FUEGO) {
            return criaturaDecorada.getEnergia() + 30;
        }
        return criaturaDecorada.getEnergia();
    }

    @Override
    public Boolean esInestable() {
        if (getTipo() != Tipo.FUEGO) {
            return Boolean.TRUE;
        }
        return criaturaDecorada.esInestable();
    }
}
