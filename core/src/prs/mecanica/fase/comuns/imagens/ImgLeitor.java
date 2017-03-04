package prs.mecanica.fase.comuns.imagens;

import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.utils.Disposable;

import prs.mecanica.fase.atores.jogador.Imagens;

public class ImgLeitor implements Disposable{

    private static final ImgLeitor imgLeitor;

    private final TextureAtlas textureAtlas;

    static{
        imgLeitor = new ImgLeitor();
    }

    private ImgLeitor(){
        this.textureAtlas = new TextureAtlas("imgs/imgs_gerais.atlas");
    }

    public static ImgLeitor getInstance() {
        return imgLeitor;
    }

    @Override
    public void dispose() {
        this.textureAtlas.dispose();
    }

    public Sprite getImg(Imagens img){
        return this.textureAtlas.createSprite(img.getNomeArquivo());
    }
}
