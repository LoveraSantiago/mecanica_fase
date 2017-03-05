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
    private float limite;
    private SubMovimentador subMovimentadorAtual;
    private final SubMovimentador subMovimentadorTecla;
    private final SubMovimentador subMovimentadorToque;
    private final SubMovimentador subMovimentadorParado;

    public Movimentador(ControleSprite controleSprite) {
        this.controleSprite = controleSprite;

        this.limitesTela = MapaCasa.getInstance().getOrthogonalTiledMapRenderer().getViewBounds();
        this.limitesTelaSprite = new Rectangle();

        this.subMovimentadorTecla = new SubMovimentadorTecla();
        this.subMovimentadorToque = new SubMovimentadorToque();
        this.subMovimentadorParado = new SubMovimentadorParado();
        this.subMovimentadorAtual = this.subMovimentadorParado;

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
        this.subMovimentadorAtual.movimentando(sprite, direcaoAtual);
    }

    public void configurarTecla() {
        this.subMovimentadorAtual = this.subMovimentadorTecla;
    }

    public void configurarToque(float limite) {
        this.subMovimentadorAtual = this.subMovimentadorToque;
        this.limite = limite;
    }

    public void configurarParado(){
        this.subMovimentadorAtual = subMovimentadorParado;
    }

    private interface SubMovimentador {
        void movimentando(Sprite sprite, Direcoes direcaoAtual);
    }

    //Todo unificar movimentadortecla e toque utilizando os limites. Aguardar se mapa tera as propriedade de tamanho.
    private class SubMovimentadorTecla implements SubMovimentador {

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


    //TODO IMPLEMENTAR DIAGONAIS
    private class SubMovimentadorToque implements SubMovimentador {

        @Override
        public void movimentando(Sprite sprite, Direcoes direcaoAtual) {
            if(!limitesTela.contains(sprite.getBoundingRectangle())) return;

            resultTemp = 5f * max(Gdx.graphics.getDeltaTime(), .1f);

            switch (direcaoAtual){
                case CIMA              :
                    resultTemp = sprite.getY() + resultTemp;
                    resultTemp = min(resultTemp, min(limite - (controleSprite.getHeigth() / 2f), limitesTelaSprite.getHeight()));
                    sprite.setPosition(sprite.getX(), resultTemp);
                    break;
                case BAIXO             :
                    resultTemp = sprite.getY() - resultTemp;
                    resultTemp = max(resultTemp, max(limite - (controleSprite.getHeigth() / 2f), limitesTelaSprite.getY()));
                    sprite.setPosition(sprite.getX(), resultTemp);
                    break;
                case ESQUERDA          :
                    resultTemp = sprite.getX() - resultTemp;
                    resultTemp = max(resultTemp, max(limite - (controleSprite.getWidth() / 2f), limitesTelaSprite.getX()));
                    sprite.setPosition(resultTemp, sprite.getY());
                    break;
                case ESQUERDA_INFERIOR :
                    break;
                case ESQUERDA_SUPERIOR :
                    break;
                case DIREITA           :
                    resultTemp = sprite.getX() + resultTemp;
                    resultTemp = min(resultTemp, min(limite - (controleSprite.getWidth() / 2f), limitesTelaSprite.getWidth()));
                    sprite.setPosition(resultTemp, sprite.getY());
                    break;
                case DIREIRA_SUPERIOR  :
                    break;
                case DIREITA_INFERIOR  :
                    break;
            }
            controleSprite.updatePosicaoSprite(sprite);
        }
    }

    private class SubMovimentadorParado implements SubMovimentador {

        @Override
        public void movimentando(Sprite sprite, Direcoes direcaoAtual) {
            controleSprite.updatePosicaoSprite(sprite);
        }
    }
}
