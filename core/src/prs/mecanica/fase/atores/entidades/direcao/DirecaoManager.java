package prs.mecanica.fase.atores.entidades.direcao;

import static com.badlogic.gdx.Input.Keys.LEFT;
import static com.badlogic.gdx.Input.Keys.DOWN;
import static com.badlogic.gdx.Input.Keys.RIGHT;
import static com.badlogic.gdx.Input.Keys.UP;
import static prs.mecanica.fase.atores.entidades.direcao.Direcoes.BAIXO;
import static prs.mecanica.fase.atores.entidades.direcao.Direcoes.CIMA;
import static prs.mecanica.fase.atores.entidades.direcao.Direcoes.DIREITA;
import static prs.mecanica.fase.atores.entidades.direcao.Direcoes.ESQUERDA;

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
        switch (keyCode){
            case UP   : return CIMA;
            case DOWN : return BAIXO;
            case LEFT : return ESQUERDA;
            case RIGHT: return DIREITA;
        }
        return CIMA;
    }
}
