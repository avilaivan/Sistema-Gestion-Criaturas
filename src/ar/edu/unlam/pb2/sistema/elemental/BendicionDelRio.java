package ar.edu.unlam.pb2.sistema.elemental;

public class BendicionDelRio extends CriaturaDecorador {

    public BendicionDelRio(Criatura criaturaAEnvolver) {
        super(criaturaAEnvolver);
    }

    @Override
    public Integer getEnergia() {
        Integer energiaBase = criaturaDecorada.getEnergia();
        Integer nuevaEnergia = energiaBase * 2;
        
        if (nuevaEnergia > 180) {
            return Integer.valueOf(180);
        }
        return nuevaEnergia;
    }
  
    
    
    
    
    
    
    
}
