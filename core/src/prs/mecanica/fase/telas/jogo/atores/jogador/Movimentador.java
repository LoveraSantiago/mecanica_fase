package prs.mecanica.fase.telas.jogo.atores.jogador;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.Sprite;

import prs.mecanica.fase.telas.jogo.atores.entidades.DirecaoEstado;
import prs.mecanica.fase.telas.jogo.atores.entidades.Direcoes;

public class Movimentador implements PosicaoJogador{

    private float posX;
    private float posY;
    private float resultTemp;

    private DirecaoEstado acaoAtual;

    public Movimentador() {
        this.acaoAtual = DirecaoEstado.PARADO;

        this.posX = .1f;
        this.posY = .1f;
    }

    public void movimentar(Sprite spriteAtual, Direcoes direcaoAtual){
        this.resultTemp = this.acaoAtual.getVelocidade() * Gdx.graphics.getDeltaTime();

        switch (direcaoAtual){
            case CIMA              :
                this.posY += this.resultTemp;
                break;
            case BAIXO             :
                this.posY -= this.resultTemp;
                break;
            case ESQUERDA          :
                this.posX -= this.resultTemp;
                break;
            case ESQUERDA_INFERIOR :
                this.posX -= this.resultTemp;
                this.posY -= this.resultTemp;
                break;
            case ESQUERDA_SUPERIOR :
                this.posX -= this.resultTemp;
                this.posY += this.resultTemp;
                break;
            case DIREITA           :
                this.posX += this.resultTemp;
                break;
            case DIREIRA_SUPERIOR  :
                this.posX += this.resultTemp;
                this.posY += this.resultTemp;
                break;
            case DIREITA_INFERIOR  :
                this.posX += this.resultTemp;
                this.posY -= this.resultTemp;
                break;
        }
        spriteAtual.setPosition(this.posX, this.posY);
    }

    public void setAcaoAtual(DirecaoEstado acao){
        this.acaoAtual = acao;
    }

    @Override
    public float getPosX() {
        return this.posX;
    }

    @Override
    public float getPosY() {
        return this.posY;
    }
}
