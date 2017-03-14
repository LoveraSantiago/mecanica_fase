package prs.mecanica.fase.telas.jogo.atores.jogador;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.Sprite;

import prs.mecanica.fase.telas.jogo.atores.entidades.DirecaoEstado;
import prs.mecanica.fase.telas.jogo.atores.entidades.Direcoes;

public class Movimentador {

    private final ControleSprite controleSprite;
    private float resultTemp;

    private DirecaoEstado acaoAtual;

    public Movimentador(ControleSprite controleSprite) {
        this.controleSprite = controleSprite;
        this.acaoAtual = DirecaoEstado.PARADO;
    }

    public void movimentar(Sprite sprite, Direcoes direcaoAtual){
        this.resultTemp = this.acaoAtual.getVelocidade() * Gdx.graphics.getDeltaTime();

        switch (direcaoAtual){
            case CIMA              :
                sprite.setPosition(sprite.getX(), sprite.getY() + this.resultTemp);
                break;
            case BAIXO             :
                sprite.setPosition(sprite.getX(), sprite.getY() - this.resultTemp);
                break;
            case ESQUERDA          :
                sprite.setPosition(sprite.getX() - this.resultTemp, sprite.getY());
                break;
            case ESQUERDA_INFERIOR :
                sprite.setPosition(sprite.getX() - this.resultTemp, sprite.getY() - this.resultTemp);
                break;
            case ESQUERDA_SUPERIOR :
                sprite.setPosition(sprite.getX() - this.resultTemp, sprite.getY() + this.resultTemp);
                break;
            case DIREITA           :
                sprite.setPosition(sprite.getX() + this.resultTemp, sprite.getY());
                break;
            case DIREIRA_SUPERIOR  :
                sprite.setPosition(sprite.getX() + this.resultTemp, sprite.getY() + this.resultTemp);
                break;
            case DIREITA_INFERIOR  :
                sprite.setPosition(sprite.getX() + this.resultTemp, sprite.getY() - this.resultTemp);
                break;
        }
        this.controleSprite.updatePosicaoSprite(sprite);
    }

    public void setAcaoAtual(DirecaoEstado acao){
        this.acaoAtual = acao;
    }
}
