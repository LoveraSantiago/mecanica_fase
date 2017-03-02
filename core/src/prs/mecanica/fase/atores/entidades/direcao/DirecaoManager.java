package prs.mecanica.fase.atores.entidades.direcao;

public class DirecaoManager {

    private static DirecaoManager direcaoManager;

    static{
        direcaoManager = new DirecaoManager();
    }

    private DirecaoManager(){
    }

    public static DirecaoManager getInstance() {
        return direcaoManager;
    }

    public Direcoes getDirecaoFromKeyCode(int keyCode){
        return null;
    }
}
