package prs.mecanica.fase.atores.jogador;

import com.badlogic.gdx.utils.Array;

import prs.mecanica.fase.atores.entidades.direcao.Direcoes;

import static com.badlogic.gdx.Input.Keys.LEFT;
import static com.badlogic.gdx.Input.Keys.DOWN;
import static com.badlogic.gdx.Input.Keys.RIGHT;
import static com.badlogic.gdx.Input.Keys.UP;
import static prs.mecanica.fase.atores.entidades.direcao.Direcoes.BAIXO;
import static prs.mecanica.fase.atores.entidades.direcao.Direcoes.CIMA;
import static prs.mecanica.fase.atores.entidades.direcao.Direcoes.DIREIRA_SUPERIOR;
import static prs.mecanica.fase.atores.entidades.direcao.Direcoes.DIREITA;
import static prs.mecanica.fase.atores.entidades.direcao.Direcoes.DIREITA_INFERIOR;
import static prs.mecanica.fase.atores.entidades.direcao.Direcoes.ESQUERDA;
import static prs.mecanica.fase.atores.entidades.direcao.Direcoes.ESQUERDA_INFERIOR;
import static prs.mecanica.fase.atores.entidades.direcao.Direcoes.ESQUERDA_SUPERIOR;

public class DirecaoManager {

    private static DirecaoManager direcaoManager;

    private Direcoes direcaoU;
    private Direcoes direcaoP;

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

    public Direcoes getDirecaoFromSomaDirecao(Array<Direcoes> direcoes){
        this.direcaoP = direcoes.get(direcoes.size - 2);
        this.direcaoU = direcoes.get(direcoes.size - 1);

        if(isOpostos()){
            return this.direcaoU;
        }
        if(isEsquerdaSuperior()){
            return ESQUERDA_SUPERIOR;
        }
        if(isDireitaSuperior()){
            return DIREIRA_SUPERIOR;
        }
        if(isEsquerdaInferior()){
            return ESQUERDA_INFERIOR;
        }
        if(isDireitaInferior()){
            return DIREITA_INFERIOR;
        }

        throw new IllegalArgumentException("Tecla não detectada.");
    }

    private boolean isOpostos(){
        if((this.direcaoP == CIMA && this.direcaoU == BAIXO) ||
           (this.direcaoP == BAIXO && this.direcaoU == CIMA)){
            return true;
        }
        if((this.direcaoP == ESQUERDA && this.direcaoU == DIREITA) ||
           (this.direcaoP == DIREITA && this.direcaoU == ESQUERDA)){
            return true;
        }
        return false;
    }

    private boolean isEsquerdaSuperior(){
        if((this.direcaoP == CIMA && this.direcaoU == ESQUERDA) ||
           (this.direcaoP == ESQUERDA && this.direcaoU == CIMA)){
            return true;
        }
        return false;
    }

    private boolean isEsquerdaInferior(){
        if((this.direcaoP == BAIXO && this.direcaoU == ESQUERDA) ||
           (this.direcaoP == ESQUERDA && this.direcaoU == BAIXO)){
            return true;
        }
        return false;
    }

    private boolean isDireitaSuperior(){
        if((this.direcaoP == CIMA && this.direcaoU == DIREITA) ||
           (this.direcaoP == DIREITA && this.direcaoU == CIMA)){
            return true;
        }
        return false;
    }

    private boolean isDireitaInferior(){
        if((this.direcaoP == BAIXO && this.direcaoU == DIREITA) ||
           (this.direcaoP == DIREITA && this.direcaoU == BAIXO)){
            return true;
        }
        return false;
    }
}
