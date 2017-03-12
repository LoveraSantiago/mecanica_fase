package prs.mecanica.fase.telas.jogo.atores.jogador;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.math.Rectangle;

import prs.mecanica.fase.telas.jogo.atores.entidades.DirecaoEstado;
import prs.mecanica.fase.telas.jogo.atores.entidades.Direcoes;
import prs.mecanica.fase.telas.jogo.atores.mapas.MapaRenderer;

import static java.lang.Math.max;
import static java.lang.Math.min;

public class Movimentador {

    private final ControleSprite controleSprite;

    private Rectangle limitesTelaSprite;
    private Rectangle limitesTela;

    private float resultTemp;

    private DirecaoEstado acaoAtual;

    public Movimentador(ControleSprite controleSprite) {
        this.controleSprite = controleSprite;

        this.limitesTela = MapaRenderer.getInstance().getOrthogonalTiledMapRenderer().getViewBounds();
        this.limitesTelaSprite = new Rectangle();

        configurarLimites();

        this.acaoAtual = DirecaoEstado.PARADO;
    }

    private void configurarLimites(){
        this.limitesTelaSprite.set(MapaRenderer.getInstance().getOrthogonalTiledMapRenderer().getViewBounds());

        this.limitesTelaSprite.setX(this.limitesTelaSprite.getX() + .01f);
        this.limitesTelaSprite.setY(this.limitesTelaSprite.getY() + .01f);
        this.limitesTelaSprite.setWidth(this.limitesTelaSprite.getWidth() - this.controleSprite.getWidth() - .1f);
        this.limitesTelaSprite.setHeight(this.limitesTelaSprite.getHeight() - this.controleSprite.getHeigth() - .1f);
    }

    public void movimentar(Sprite sprite, Direcoes direcaoAtual){
        if(!this.limitesTela.contains(sprite.getBoundingRectangle())) return;

        this.resultTemp = this.acaoAtual.getVelocidade() * Gdx.graphics.getDeltaTime();

        switch (direcaoAtual){
            case CIMA              :
                this.resultTemp = sprite.getY() + this.resultTemp;
                sprite.setPosition(sprite.getX(), min(this.resultTemp, this.limitesTelaSprite.getHeight()));
                break;
            case BAIXO             :
                this.resultTemp = sprite.getY() - this.resultTemp;
                sprite.setPosition(sprite.getX(), max(this.resultTemp, this.limitesTelaSprite.getY()));
                break;
            case ESQUERDA          :
                this.resultTemp = sprite.getX() - this.resultTemp;
                sprite.setPosition(max(this.resultTemp, this.limitesTelaSprite.getX()), sprite.getY());
                break;
            case ESQUERDA_INFERIOR :
                sprite.setPosition(max(sprite.getX() - this.resultTemp, this.limitesTelaSprite.getX()), max(sprite.getY() - this.resultTemp, this.limitesTelaSprite.getY()));
                break;
            case ESQUERDA_SUPERIOR :
                sprite.setPosition(max(sprite.getX() - this.resultTemp, this.limitesTelaSprite.getX()), min(sprite.getY() + this.resultTemp, this.limitesTelaSprite.getHeight()));
                break;
            case DIREITA           :
                this.resultTemp = sprite.getX() + this.resultTemp;
                sprite.setPosition(min(this.resultTemp, this.limitesTelaSprite.getWidth()), sprite.getY());
                break;
            case DIREIRA_SUPERIOR  :
                sprite.setPosition(min(sprite.getX() + this.resultTemp, this.limitesTelaSprite.getWidth()), min(sprite.getY() + this.resultTemp, this.limitesTelaSprite.getHeight()));
                break;
            case DIREITA_INFERIOR  :
                sprite.setPosition(min(sprite.getX() + this.resultTemp, this.limitesTelaSprite.getWidth()), max(sprite.getY() - this.resultTemp, this.limitesTelaSprite.getY()));
                break;
        }
        this.controleSprite.updatePosicaoSprite(sprite);
    }

    public void setAcaoAtual(DirecaoEstado acao){
//        System.out.println("Setado acao " + acao);
        this.acaoAtual = acao;
    }
}
