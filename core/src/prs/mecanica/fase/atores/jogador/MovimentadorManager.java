package prs.mecanica.fase.atores.jogador;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.math.Rectangle;

import prs.mecanica.fase.atores.mapas.MapaCasa;

import static java.lang.Math.max;
import static java.lang.Math.min;

public class MovimentadorManager {

    private final ControleSprite controleSprite;

    private Rectangle limitesTelaSprite;
    private Rectangle limitesTela;

    private float resultTemp;
    private float limite;
    private       Movimentador movimentadorAtual;
    private final Movimentador movimentadorTecla;
    private final Movimentador movimentadorToque;

    public MovimentadorManager(ControleSprite controleSprite) {
        this.controleSprite = controleSprite;

        this.limitesTela = MapaCasa.getInstance().getOrthogonalTiledMapRenderer().getViewBounds();
        this.limitesTelaSprite = new Rectangle();

        this.movimentadorTecla = new MovimentadorTecla();
        this.movimentadorToque = new MovimentadorToque();

        configurarLimites();
    }

    private void configurarLimites(){
        this.limitesTelaSprite.set(MapaCasa.getInstance().getOrthogonalTiledMapRenderer().getViewBounds());

        this.limitesTelaSprite.setX(this.limitesTelaSprite.getX() + .01f);
        this.limitesTelaSprite.setY(this.limitesTelaSprite.getY() + .01f);
        this.limitesTelaSprite.setWidth(this.limitesTelaSprite.getWidth() - this.controleSprite.getWidth() - .1f);
        this.limitesTelaSprite.setHeight(this.limitesTelaSprite.getHeight() - this.controleSprite.getHeigth() - .1f);
    }

    public void movimentar(Sprite sprite){
        this.movimentadorAtual.movimentando(sprite);
    }

    public void configurarTecla() {
        this.movimentadorAtual = this.movimentadorTecla;
    }

    public void configurarToque(float limite) {
        this.movimentadorAtual = this.movimentadorToque;
        this.limite = limite;
    }

    private interface Movimentador{
        void movimentando(Sprite sprite);
    }

    private class MovimentadorTecla implements Movimentador {

        @Override
        public void movimentando(Sprite sprite) {
            if(!limitesTela.contains(sprite.getBoundingRectangle())) return;

            resultTemp = 5f * Gdx.graphics.getDeltaTime();

            if(controleSprite.isSpriteCima(sprite)){
                resultTemp = sprite.getY() + resultTemp;
                sprite.setPosition(sprite.getX(), min(resultTemp, limitesTelaSprite.getHeight()));
            }
            else if(controleSprite.isSpriteBaixo(sprite)){
                resultTemp = sprite.getY() - resultTemp;
                sprite.setPosition(sprite.getX(), max(resultTemp, limitesTelaSprite.getY()));
            }
            else if(controleSprite.isSpriteDireita(sprite)){
                resultTemp = sprite.getX() + resultTemp;
                sprite.setPosition(min(resultTemp, limitesTelaSprite.getWidth()), sprite.getY());
            }
            else if(controleSprite.isSpriteEsquerda(sprite)){
                resultTemp = sprite.getX() - resultTemp;
                sprite.setPosition(max(resultTemp, limitesTelaSprite.getX()), sprite.getY());
            }
            controleSprite.updatePosicaoSprite(sprite);
        }
    }

    private class MovimentadorToque implements Movimentador {

        @Override
        public void movimentando(Sprite sprite) {
            if(!limitesTela.contains(sprite.getBoundingRectangle())) return;

            resultTemp = 5f * max(Gdx.graphics.getDeltaTime(), .1f);

            if(controleSprite.isSpriteCima(sprite)){
                resultTemp = sprite.getY() + resultTemp;
                resultTemp = min(resultTemp, min(limite - (controleSprite.getHeigth() / 2f), limitesTelaSprite.getHeight()));
                sprite.setPosition(sprite.getX(), resultTemp);
            }
            else if(controleSprite.isSpriteBaixo(sprite)){
                resultTemp = sprite.getY() - resultTemp;
                resultTemp = max(resultTemp, max(limite - (controleSprite.getHeigth() / 2f), limitesTelaSprite.getY()));
                sprite.setPosition(sprite.getX(), resultTemp);
            }
            else if(controleSprite.isSpriteDireita(sprite)){
                resultTemp = sprite.getX() + resultTemp;
                resultTemp = min(resultTemp, min(limite - (controleSprite.getWidth() / 2f), limitesTelaSprite.getWidth()));
                sprite.setPosition(resultTemp, sprite.getY());
            }
            else if(controleSprite.isSpriteEsquerda(sprite)){
                resultTemp = sprite.getX() - resultTemp;
                resultTemp = max(resultTemp, max(limite - (controleSprite.getWidth() / 2f), limitesTelaSprite.getX()));
                sprite.setPosition(resultTemp, sprite.getY());
            }
            controleSprite.updatePosicaoSprite(sprite);
        }
    }
}
