package prs.mecanica.fase.telas.jogo.comuns.imagens;

import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.utils.Disposable;

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

    public TextureAtlas.AtlasRegion getRegiao(Imagens img){
        TextureAtlas.AtlasRegion region = this.textureAtlas.findRegion(img.getNomeArquivo());
        return region;
    }

    public TextureAtlas getTextureAtlas() {
        return textureAtlas;
    }
}
