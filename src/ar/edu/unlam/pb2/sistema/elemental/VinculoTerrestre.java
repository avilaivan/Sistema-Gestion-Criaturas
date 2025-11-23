package ar.edu.unlam.pb2.sistema.elemental;

public class VinculoTerrestre extends CriaturaDecorador {
	

    public VinculoTerrestre(Criatura criaturaAEnvolver) {
        super(criaturaAEnvolver);
    }

    @Override
    public Integer getEnergia() {
        Integer energiaReal = criaturaDecorada.getEnergia();
        
        if (energiaReal < 50) {
            return Integer.valueOf(50);
        }
        return energiaReal;
    }
}
