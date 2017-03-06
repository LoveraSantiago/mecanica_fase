package prs.mecanica.fase.telas.jogo.atores.jogador;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.math.Rectangle;

import prs.mecanica.fase.telas.jogo.atores.entidades.Direcoes;
import prs.mecanica.fase.telas.jogo.atores.mapas.MapaCasa;

import static java.lang.Math.max;
import static java.lang.Math.min;

public class Movimentador {

    private final ControleSprite controleSprite;

    private Rectangle limitesTelaSprite;
    private Rectangle limitesTela;

    private float resultTemp;
    private       SubMovimentadorHelper helperAtual;
    private final SubMovimentadorHelper helperTecla;
    private final SubMovimentadorHelper helperParado;

    public Movimentador(ControleSprite controleSprite) {
        this.controleSprite = controleSprite;

        this.limitesTela = MapaCasa.getInstance().getOrthogonalTiledMapRenderer().getViewBounds();
        this.limitesTelaSprite = new Rectangle();

        this.helperTecla  = new SubMovimentadorHelperTecla();
        this.helperParado = new SubMovimentadorHelperParado();
        this.helperAtual  = this.helperParado;

        configurarLimites();
    }

    private void configurarLimites(){
        this.limitesTelaSprite.set(MapaCasa.getInstance().getOrthogonalTiledMapRenderer().getViewBounds());

        this.limitesTelaSprite.setX(this.limitesTelaSprite.getX() + .01f);
        this.limitesTelaSprite.setY(this.limitesTelaSprite.getY() + .01f);
        this.limitesTelaSprite.setWidth(this.limitesTelaSprite.getWidth() - this.controleSprite.getWidth() - .1f);
        this.limitesTelaSprite.setHeight(this.limitesTelaSprite.getHeight() - this.controleSprite.getHeigth() - .1f);
    }

    public void movimentar(Sprite sprite, Direcoes direcaoAtual){
        this.helperAtual.movimentando(sprite, direcaoAtual);
    }

    public void configurarTecla() {
        this.helperAtual = this.helperTecla;
    }

    public void configurarParado(){
        this.helperAtual = helperParado;
    }

    private interface SubMovimentadorHelper {
        void movimentando(Sprite sprite, Direcoes direcaoAtual);
    }

    private class SubMovimentadorHelperTecla implements SubMovimentadorHelper {

        @Override
        public void movimentando(Sprite sprite, Direcoes direcaoAtual) {
            if(!limitesTela.contains(sprite.getBoundingRectangle())) return;

            resultTemp = 5f * Gdx.graphics.getDeltaTime();

            switch (direcaoAtual){
                case CIMA              :
                    resultTemp = sprite.getY() + resultTemp;
                    sprite.setPosition(sprite.getX(), min(resultTemp, limitesTelaSprite.getHeight()));
                    break;
                case BAIXO             :
                    resultTemp = sprite.getY() - resultTemp;
                    sprite.setPosition(sprite.getX(), max(resultTemp, limitesTelaSprite.getY()));
                    break;
                case ESQUERDA          :
                    resultTemp = sprite.getX() - resultTemp;
                    sprite.setPosition(max(resultTemp, limitesTelaSprite.getX()), sprite.getY());
                    break;
                case ESQUERDA_INFERIOR :
                    sprite.setPosition(max(sprite.getX() - resultTemp, limitesTelaSprite.getX()), max(sprite.getY() - resultTemp, limitesTelaSprite.getY()));
                    break;
                case ESQUERDA_SUPERIOR :
                    sprite.setPosition(max(sprite.getX() - resultTemp, limitesTelaSprite.getX()), min(sprite.getY() + resultTemp, limitesTelaSprite.getHeight()));
                    break;
                case DIREITA           :
                    resultTemp = sprite.getX() + resultTemp;
                    sprite.setPosition(min(resultTemp, limitesTelaSprite.getWidth()), sprite.getY());
                    break;
                case DIREIRA_SUPERIOR  :
                    sprite.setPosition(min(sprite.getX() + resultTemp, limitesTelaSprite.getWidth()), min(sprite.getY() + resultTemp, limitesTelaSprite.getHeight()));
                    break;
                case DIREITA_INFERIOR  :
                    sprite.setPosition(min(sprite.getX() + resultTemp, limitesTelaSprite.getWidth()), max(sprite.getY() - resultTemp, limitesTelaSprite.getY()));
                    break;
            }
            controleSprite.updatePosicaoSprite(sprite);
        }
    }

    private class SubMovimentadorHelperParado implements SubMovimentadorHelper {

        @Override
        public void movimentando(Sprite sprite, Direcoes direcaoAtual) {
            controleSprite.updatePosicaoSprite(sprite);
        }
    }
}
