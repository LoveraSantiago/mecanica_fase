package prs.mecanica.fase.atores.entidades.controle;

import com.badlogic.gdx.InputProcessor;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.utils.Disposable;
import com.badlogic.gdx.utils.viewport.StretchViewport;
import com.badlogic.gdx.utils.viewport.Viewport;

import prs.mecanica.fase.comuns.MySpriteBatch;
import prs.mecanica.fase.comuns.contratos.ViewPortUser;
import prs.mecanica.fase.comuns.contratos.tipo.TipoControlavel;
import prs.mecanica.fase.comuns.contratos.tipo.TipoDesenhavel;

public class Controle implements TipoDesenhavel, ViewPortUser, Disposable, TipoControlavel{

    private final Viewport viewport;
    private final Stage stage;

    public Controle() {
        this.viewport = new StretchViewport(300, 200);
        this.stage = new Stage(this.viewport, MySpriteBatch.getInstance().getSpriteBatch());

        this.stage.addActor(new Parser().parsear());
    }

    @Override
    public void meDesenhar() {
        this.stage.draw();
    }

    @Override
    public void resize(int width, int height) {
        this.stage.getViewport().update(width, height, true);
    }

    @Override
    public InputProcessor getControle() {
        return this.stage;
    }

    @Override
    public void dispose() {
        this.stage.dispose();
    }
}
