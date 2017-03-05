package prs.mecanica.fase.telas.jogo.atores.jogador;

import static com.badlogic.gdx.Input.Keys.DOWN;
import static com.badlogic.gdx.Input.Keys.LEFT;
import static com.badlogic.gdx.Input.Keys.RIGHT;
import static com.badlogic.gdx.Input.Keys.UP;

public class KeyCodeFilter {

    public boolean isKeyCodeMovimentacao(int keyCode){
        switch (keyCode){
            case UP   :
            case DOWN :
            case LEFT :
            case RIGHT: return true;
            default   : return false;
        }
    }

}
