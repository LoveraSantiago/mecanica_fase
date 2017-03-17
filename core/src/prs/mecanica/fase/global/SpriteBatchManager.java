package prs.mecanica.fase.global;

import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.Disposable;

import prs.mecanica.fase.telas.jogo.atores.camera.MyCamera;
import prs.mecanica.fase.telas.jogo.comuns.contratos.tipo.TipoAtualizavel;

public class SpriteBatchManager implements Disposable, TipoAtualizavel<OrthographicCamera> {

    private static final SpriteBatchManager SPRITE_BATCH_MANAGER;

    private final SpriteBatch spriteBatch;

    static{
        SPRITE_BATCH_MANAGER = new SpriteBatchManager();
    }

    private SpriteBatchManager(){
        this.spriteBatch = new SpriteBatch();
        atualizar(MyCamera.getInstance().getCamera());
    }

    public static SpriteBatchManager getInstance() {
        return SPRITE_BATCH_MANAGER;
    }

    public SpriteBatch getSpriteBatch(){
        return this.spriteBatch;
    }

    @Override
    public void atualizar(OrthographicCamera camera) {
        this.spriteBatch.setProjectionMatrix(camera.combined);
    }

    @Override
    public void dispose() {
        this.spriteBatch.dispose();
    }
}
