package prs.mecanica.fase.atores.jogador;

import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.utils.Array;

import prs.mecanica.fase.comuns.ImgLeitor;

import static com.badlogic.gdx.Input.Keys.DOWN;
import static com.badlogic.gdx.Input.Keys.LEFT;
import static com.badlogic.gdx.Input.Keys.RIGHT;
import static com.badlogic.gdx.Input.Keys.UP;
import static prs.mecanica.fase.comuns.MyCamera.ESCALA;

public class SpriteManager implements ControleSprite{

    private int contadorSprites;

    private float widthSprite;
    private float heightSprite;

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
        configurarTamanhoSprite();
    }

    public Sprite getSprite(int keyCode){
        switch (keyCode){
            case UP   : return this.spriteCima;
            case DOWN : return this.spriteBaixo;
            case LEFT : return this.spriteEsq;
            case RIGHT: return this.spriteDir;
        }
        return this.spriteCima;
    }

    private void configurarSprites(){
        for(this.contadorSprites = 0; this.contadorSprites < this.arraySprites.size; this.contadorSprites++){
            this.arraySprites.get(this.contadorSprites).setOrigin(.1f, .1f);
            this.arraySprites.get(this.contadorSprites).setScale(ESCALA);
        }
    }

    public void configurarTamanhoSprite(){
        this.widthSprite = this.spriteCima.getWidth() * ESCALA;
        this.heightSprite = this.spriteCima.getHeight() * ESCALA;
    }

    @Override
    public boolean isSpriteBaixo(Sprite sprite) {
        return sprite == this.spriteBaixo;
    }

    @Override
    public boolean isSpriteCima(Sprite sprite) {
        return sprite == this.spriteCima;
    }

    @Override
    public boolean isSpriteDireita(Sprite sprite) {
        return sprite == this.spriteDir;
    }

    @Override
    public boolean isSpriteEsquerda(Sprite sprite) {
        return sprite == this.spriteEsq;
    }

    @Override
    public float getWidth() {
        return this.widthSprite;
    }

    @Override
    public float getHeigth() {
        return this.heightSprite;
    }

    @Override
    public void updatePosicaoSprite(Sprite sprite){
        for(this.contadorSprites = 0; this.contadorSprites < this.arraySprites.size; this.contadorSprites++){
            this.arraySprites.get(this.contadorSprites).setPosition(sprite.getX(), sprite.getY());
        }
    }
}
