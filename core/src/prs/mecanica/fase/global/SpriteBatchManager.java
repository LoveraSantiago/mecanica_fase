package prs.mecanica.fase.global;

import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.Disposable;

import prs.mecanica.fase.telas.jogo.comuns.MyCamera;

public class SpriteBatchManager implements Disposable, prs.mecanica.fase.telas.jogo.comuns.contratos.tipo.TipoAtualizavel {

    private static final SpriteBatchManager SPRITE_BATCH_MANAGER;

    private final SpriteBatch spriteBatch;

    static{
        SPRITE_BATCH_MANAGER = new SpriteBatchManager();
    }

    private SpriteBatchManager(){
        this.spriteBatch = new SpriteBatch();
        atualizar();
    }

    public static SpriteBatchManager getInstance() {
        return SPRITE_BATCH_MANAGER;
    }

    public SpriteBatch getSpriteBatch(){
        return this.spriteBatch;
    }

    @Override
    public void atualizar() {
        this.spriteBatch.setProjectionMatrix(MyCamera.getInstance().getCamera().combined);
    }

    @Override
    public void dispose() {
        this.spriteBatch.dispose();
    }

    public void desenharSprite(Sprite sprite){
        this.spriteBatch.begin();
        sprite.draw(this.spriteBatch);
        this.spriteBatch.end();
    }
}
