package prs.mecanica.fase.atores.jogador;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.utils.Array;

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

    public SpriteManager() {
        ImgLeitor imgLeitor = ImgLeitor.getInstance();
        this.spriteCima = imgLeitor.getImg (Imagens.PERSONAGEM_CIMA);
        this.spriteBaixo = imgLeitor.getImg(Imagens.PERSONAGEM_BAIXO);
        this.spriteDir = imgLeitor.getImg  (Imagens.PERSONAGEM_DIR);
        this.spriteEsq = imgLeitor.getImg  (Imagens.PERSONAGEM_ESQ);

        this.arraySprites = new Array<Sprite>();
        this.arraySprites.addAll(this.spriteCima, this.spriteBaixo, this.spriteDir, this.spriteEsq);
        configurarSprites();
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

    public void movimentar(Sprite sprite){
        this.resultTemp = 5f * Gdx.graphics.getDeltaTime();

        if(sprite == spriteCima){
            sprite.setPosition(sprite.getX(), sprite.getY() + this.resultTemp);
        }
        else if(sprite == spriteBaixo){
            sprite.setPosition(sprite.getX(), sprite.getY() - this.resultTemp);
        }
        else if(sprite == spriteDir){
            sprite.setPosition(sprite.getX() + this.resultTemp, sprite.getY());
        }
        else if(sprite == spriteEsq){
            sprite.setPosition(sprite.getX() - this.resultTemp, sprite.getY());
        }
        updatePosicaoSprite(sprite);
    }

    private void configurarSprites(){
        for(this.contadorSprites = 0; this.contadorSprites < this.arraySprites.size; this.contadorSprites++){
            this.arraySprites.get(this.contadorSprites).setScale(MyCamera.ESCALA);
        }
    }

    public void updatePosicaoSprite(Sprite sprite){
        for(this.contadorSprites = 0; this.contadorSprites < this.arraySprites.size; this.contadorSprites++){
            this.arraySprites.get(this.contadorSprites).setPosition(sprite.getX(), sprite.getY());
        }
    }
}
