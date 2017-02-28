package prs.mecanica.fase.atores.jogador;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.utils.Array;

import prs.mecanica.fase.atores.mapas.MapaCasa;
import prs.mecanica.fase.comuns.ImgLeitor;

import static com.badlogic.gdx.Input.Keys.DOWN;
import static com.badlogic.gdx.Input.Keys.LEFT;
import static com.badlogic.gdx.Input.Keys.RIGHT;
import static com.badlogic.gdx.Input.Keys.UP;
import static java.lang.Math.max;
import static java.lang.Math.min;
import static prs.mecanica.fase.comuns.MyCamera.ESCALA;

public class SpriteManager {

    private int contadorSprites;
    private float resultTemp;

    private final Sprite spriteCima;
    private final Sprite spriteBaixo;
    private final Sprite spriteEsq;
    private final Sprite spriteDir;
    private final Array<Sprite> arraySprites;

    private Rectangle limitesTelaSprite;
    private Rectangle limitesTela;

    private float limite;
    private       Movimentador movimentadorAtual;
    private final Movimentador movimentadorTecla;
    private final Movimentador movimentadorToque;

    public SpriteManager() {
        ImgLeitor imgLeitor = ImgLeitor.getInstance();
        this.spriteCima = imgLeitor.getImg (Imagens.PERSONAGEM_CIMA);
        this.spriteBaixo = imgLeitor.getImg(Imagens.PERSONAGEM_BAIXO);
        this.spriteDir = imgLeitor.getImg  (Imagens.PERSONAGEM_DIR);
        this.spriteEsq = imgLeitor.getImg  (Imagens.PERSONAGEM_ESQ);

        this.arraySprites = new Array<Sprite>();
        this.arraySprites.addAll(this.spriteCima, this.spriteBaixo, this.spriteDir, this.spriteEsq);

        this.limitesTela = MapaCasa.getInstance().getOrthogonalTiledMapRenderer().getViewBounds();
        this.limitesTelaSprite = new Rectangle();

        this.movimentadorTecla = new MovimentadorTecla();
        this.movimentadorToque = new MovimentadorToque();

        configurarSprites();
        configurarLimites();
    }

    public Sprite getSprite(int keyCode){
        switch (keyCode){
            case UP:
                return this.spriteCima;
            case DOWN:
                return this.spriteBaixo;
            case LEFT:
                return this.spriteEsq;
            case RIGHT:
                return this.spriteDir;
        }
        return this.spriteCima;
    }

    public void movimentar(Sprite sprite){
        this.movimentadorAtual.movimentando(sprite);
    }

    private void configurarSprites(){
        for(this.contadorSprites = 0; this.contadorSprites < this.arraySprites.size; this.contadorSprites++){
            this.arraySprites.get(this.contadorSprites).setOrigin(.1f, .1f);
            this.arraySprites.get(this.contadorSprites).setScale(ESCALA);
        }
    }

    public void configurarTecla() {
        this.movimentadorAtual = this.movimentadorTecla;
    }

    public void configurarToque(float limite) {
        this.movimentadorAtual = this.movimentadorToque;
        this.limite = limite;
    }

    private void configurarLimites(){
        this.limitesTelaSprite.set(MapaCasa.getInstance().getOrthogonalTiledMapRenderer().getViewBounds());

        this.limitesTelaSprite.setX(this.limitesTelaSprite.getX() + .01f);
        this.limitesTelaSprite.setY(this.limitesTelaSprite.getY() + .01f);
        this.limitesTelaSprite.setWidth(this.limitesTelaSprite.getWidth() - (this.spriteCima.getWidth() * ESCALA) - .1f);
        this.limitesTelaSprite.setHeight(this.limitesTelaSprite.getHeight() - (this.spriteCima.getHeight() * ESCALA) - .1f);
    }

    public void updatePosicaoSprite(Sprite sprite){
        for(this.contadorSprites = 0; this.contadorSprites < this.arraySprites.size; this.contadorSprites++){
            this.arraySprites.get(this.contadorSprites).setPosition(sprite.getX(), sprite.getY());
        }
    }

    private interface Movimentador{
        void movimentando(Sprite sprite);
    }

    private class MovimentadorTecla implements Movimentador{

        @Override
        public void movimentando(Sprite sprite) {
            if(!limitesTela.contains(sprite.getBoundingRectangle())) return;

            resultTemp = 5f * Gdx.graphics.getDeltaTime();

            if(sprite == spriteCima){
                resultTemp = sprite.getY() + resultTemp;
                sprite.setPosition(sprite.getX(), min(resultTemp, limitesTelaSprite.getHeight()));
            }
            else if(sprite == spriteBaixo){
                resultTemp = sprite.getY() - resultTemp;
                sprite.setPosition(sprite.getX(), max(resultTemp, limitesTelaSprite.getY()));
            }
            else if(sprite == spriteDir){
                resultTemp = sprite.getX() + resultTemp;
                sprite.setPosition(min(resultTemp, limitesTelaSprite.getWidth()), sprite.getY());
            }
            else if(sprite == spriteEsq){
                resultTemp = sprite.getX() - resultTemp;
                sprite.setPosition(max(resultTemp, limitesTelaSprite.getX()), sprite.getY());
            }
            updatePosicaoSprite(sprite);
        }
    }

    private class MovimentadorToque implements Movimentador{

        @Override
        public void movimentando(Sprite sprite) {
            if(!limitesTela.contains(sprite.getBoundingRectangle())) return;

            resultTemp = 5f * max(Gdx.graphics.getDeltaTime(), .1f);

            if(sprite == spriteCima){
                resultTemp = sprite.getY() + resultTemp;
                resultTemp = min(resultTemp, min(limite - ((sprite.getHeight() * ESCALA) / 2f), limitesTelaSprite.getHeight()));
                sprite.setPosition(sprite.getX(), resultTemp);
            }
            else if(sprite == spriteBaixo){
                resultTemp = sprite.getY() - resultTemp;
                resultTemp = max(resultTemp, max(limite - ((sprite.getHeight() * ESCALA) / 2f), limitesTelaSprite.getY()));
                sprite.setPosition(sprite.getX(), resultTemp);
            }
            else if(sprite == spriteDir){
                resultTemp = sprite.getX() + resultTemp;
                resultTemp = min(resultTemp, min(limite - ((sprite.getWidth() * ESCALA) / 2f), limitesTelaSprite.getWidth()));
                sprite.setPosition(resultTemp, sprite.getY());
            }
            else if(sprite == spriteEsq){
                resultTemp = sprite.getX() - resultTemp;
                resultTemp = max(resultTemp, max(limite - ((sprite.getWidth() * ESCALA) / 2f), limitesTelaSprite.getX()));
                sprite.setPosition(resultTemp, sprite.getY());
            }
            updatePosicaoSprite(sprite);
        }
    }
}
