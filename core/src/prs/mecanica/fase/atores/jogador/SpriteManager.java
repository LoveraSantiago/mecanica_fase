package prs.mecanica.fase.atores.jogador;

import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.utils.Array;

import prs.mecanica.fase.atores.entidades.direcao.Direcoes;
import prs.mecanica.fase.comuns.imagens.ImgLeitor;

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

    public Sprite getSprite(Direcoes direcao){
        switch (direcao){
            case CIMA              : return this.spriteCima;
            case BAIXO             : return this.spriteBaixo;
            case ESQUERDA          :
            case ESQUERDA_INFERIOR :
            case ESQUERDA_SUPERIOR : return this.spriteEsq;
            case DIREITA           :
            case DIREIRA_SUPERIOR  :
            case DIREITA_INFERIOR  : return this.spriteDir;
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
