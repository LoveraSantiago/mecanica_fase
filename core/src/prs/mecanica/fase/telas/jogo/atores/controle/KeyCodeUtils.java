package prs.mecanica.fase.telas.jogo.atores.controle;

import com.badlogic.gdx.utils.Array;

import prs.mecanica.fase.telas.jogo.atores.entidades.Direcoes;

import static com.badlogic.gdx.Input.Keys.LEFT;
import static com.badlogic.gdx.Input.Keys.DOWN;
import static com.badlogic.gdx.Input.Keys.RIGHT;
import static com.badlogic.gdx.Input.Keys.UP;

class KeyCodeUtils {

    private static KeyCodeUtils keyCodeUtils;

    private Direcoes direcaoU;
    private Direcoes direcaoP;

    static{
        keyCodeUtils = new KeyCodeUtils();
    }

    private KeyCodeUtils(){
    }

    public static KeyCodeUtils getInstance() {
        return keyCodeUtils;
    }

    public Direcoes getDirecaoFromKeyCode(int keyCode){
        switch (keyCode){
            case UP   : return Direcoes.CIMA;
            case DOWN : return Direcoes.BAIXO;
            case LEFT : return Direcoes.ESQUERDA;
            case RIGHT: return Direcoes.DIREITA;
        }
        return Direcoes.CIMA;
    }

    public Direcoes getDirecaoFromSomaDirecao(Array<Direcoes> direcoes){
        this.direcaoP = direcoes.get(direcoes.size - 2);
        this.direcaoU = direcoes.get(direcoes.size - 1);

        if(isOpostos()){
            return this.direcaoU;
        }
        if(isEsquerdaSuperior()){
            return Direcoes.ESQUERDA_SUPERIOR;
        }
        if(isDireitaSuperior()){
            return Direcoes.DIREIRA_SUPERIOR;
        }
        if(isEsquerdaInferior()){
            return Direcoes.ESQUERDA_INFERIOR;
        }
        if(isDireitaInferior()){
            return Direcoes.DIREITA_INFERIOR;
        }

        throw new IllegalArgumentException("Tecla não detectada.");
    }

    private boolean isOpostos(){
        if((this.direcaoP == Direcoes.CIMA && this.direcaoU == Direcoes.BAIXO) ||
           (this.direcaoP == Direcoes.BAIXO && this.direcaoU == Direcoes.CIMA)){
            return true;
        }
        if((this.direcaoP == Direcoes.ESQUERDA && this.direcaoU == Direcoes.DIREITA) ||
           (this.direcaoP == Direcoes.DIREITA && this.direcaoU == Direcoes.ESQUERDA)){
            return true;
        }
        return false;
    }

    private boolean isEsquerdaSuperior(){
        if((this.direcaoP == Direcoes.CIMA && this.direcaoU == Direcoes.ESQUERDA) ||
           (this.direcaoP == Direcoes.ESQUERDA && this.direcaoU == Direcoes.CIMA)){
            return true;
        }
        return false;
    }

    private boolean isEsquerdaInferior(){
        if((this.direcaoP == Direcoes.BAIXO && this.direcaoU == Direcoes.ESQUERDA) ||
           (this.direcaoP == Direcoes.ESQUERDA && this.direcaoU == Direcoes.BAIXO)){
            return true;
        }
        return false;
    }

    private boolean isDireitaSuperior(){
        if((this.direcaoP == Direcoes.CIMA && this.direcaoU == Direcoes.DIREITA) ||
           (this.direcaoP == Direcoes.DIREITA && this.direcaoU == Direcoes.CIMA)){
            return true;
        }
        return false;
    }

    private boolean isDireitaInferior(){
        if((this.direcaoP == Direcoes.BAIXO && this.direcaoU == Direcoes.DIREITA) ||
           (this.direcaoP == Direcoes.DIREITA && this.direcaoU == Direcoes.BAIXO)){
            return true;
        }
        return false;
    }

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
