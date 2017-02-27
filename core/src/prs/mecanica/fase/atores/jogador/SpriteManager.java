package prs.mecanica.fase.atores.jogador;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.utils.Array;

import prs.mecanica.fase.atores.mapas.MapaCasa;
import prs.mecanica.fase.comuns.ImgLeitor;
import prs.mecanica.fase.comuns.MyCamera;

public class SpriteManager {

    private int contadorSprites;
    private float resultTemp;

    private final Sprite spriteCima;
    private final Sprite spriteBaixo;
    private final Sprite spriteEsq;
    private final Sprite spriteDir;
    private final Array<Sprite> arraySprites;

    private Rectangle limitesTela;

    public SpriteManager() {
        ImgLeitor imgLeitor = ImgLeitor.getInstance();
        this.spriteCima = imgLeitor.getImg (Imagens.PERSONAGEM_CIMA);
        this.spriteBaixo = imgLeitor.getImg(Imagens.PERSONAGEM_BAIXO);
        this.spriteDir = imgLeitor.getImg  (Imagens.PERSONAGEM_DIR);
        this.spriteEsq = imgLeitor.getImg  (Imagens.PERSONAGEM_ESQ);

        this.arraySprites = new Array<Sprite>();
        this.arraySprites.addAll(this.spriteCima, this.spriteBaixo, this.spriteDir, this.spriteEsq);

        configurarSprites();
        limitesTela = MapaCasa.getInstance().getOrthogonalTiledMapRenderer().getViewBounds();
    }

    public Sprite getSprite(int keyCode){
        switch (keyCode){
            case Input.Keys.UP:
                return this.spriteCima;
            case Input.Keys.DOWN:
                return this.spriteBaixo;
            case Input.Keys.LEFT:
                return this.spriteEsq;
            case Input.Keys.RIGHT:
                return this.spriteDir;
        }
        return this.spriteCima;
    }

    //Todo melhorar performance realizando calculo de limites da tela a cada movimentacao. O tamanho verdadeiro do mapa casa so e definido apos set view passando camera
    public void movimentar(Sprite sprite){
        if(!this.limitesTela.contains(sprite.getBoundingRectangle())) return;

        this.resultTemp = 5f * Gdx.graphics.getDeltaTime();

        if(sprite == spriteCima){
            this.resultTemp = sprite.getY() + this.resultTemp;
            sprite.setPosition(sprite.getX(), Math.min(this.resultTemp, (this.limitesTela.getHeight() - (sprite.getHeight() * MyCamera.ESCALA)) - .1f));
        }
        else if(sprite == spriteBaixo){
            this.resultTemp = sprite.getY() - this.resultTemp;
            sprite.setPosition(sprite.getX(), Math.max(this.resultTemp, this.limitesTela.getY() + .1f));
        }
        else if(sprite == spriteDir){
            this.resultTemp = sprite.getX() + this.resultTemp;
            sprite.setPosition(Math.min(this.resultTemp, this.limitesTela.getWidth() - (sprite.getWidth() * MyCamera.ESCALA) - .1f), sprite.getY());
        }
        else if(sprite == spriteEsq){
            this.resultTemp = sprite.getX() - this.resultTemp;
            sprite.setPosition(Math.max(this.resultTemp, this.limitesTela.getX() + .1f), sprite.getY());
        }
        updatePosicaoSprite(sprite);
    }

    private void configurarSprites(){
        for(this.contadorSprites = 0; this.contadorSprites < this.arraySprites.size; this.contadorSprites++){
            this.arraySprites.get(this.contadorSprites).setOrigin(.1f, .1f);
            this.arraySprites.get(this.contadorSprites).setScale(MyCamera.ESCALA);
        }
    }

    public void updatePosicaoSprite(Sprite sprite){
        for(this.contadorSprites = 0; this.contadorSprites < this.arraySprites.size; this.contadorSprites++){
            this.arraySprites.get(this.contadorSprites).setPosition(sprite.getX(), sprite.getY());
        }
    }
}
