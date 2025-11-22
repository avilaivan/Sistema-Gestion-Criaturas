package ar.edu.unlam.pb2.sistema.elemental;

public class BendicionDelRio extends CriaturaDecorador {

    public BendicionDelRio(Criatura criaturaAEnvolver) {
        super(criaturaAEnvolver);
    }

    @Override
    public Integer getEnergia() {
        // 1. Obtenemos la energía original
        Integer energiaBase = criaturaDecorada.getEnergia();
        
        // 2. Aplicamos la magia (Duplicar)
        Integer nuevaEnergia = energiaBase * 2;
        
        // 3. Aplicamos el límite (Tope 180)
        if (nuevaEnergia > 180) {
            return Integer.valueOf(180);
        }
        return nuevaEnergia;
    }
    
    // Nota: Solo sobrescribimos getEnergia porque es lo único que cambia esta magia.
    // El resto (Tipo, Nombre, etc.) sigue delegando al padre.
    
    
    
    
    
    
    
    
}
