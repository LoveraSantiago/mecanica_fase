package prs.mecanica.fase.telas.jogo.atores.controle.mobile;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.InputProcessor;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.utils.viewport.StretchViewport;
import com.badlogic.gdx.utils.viewport.Viewport;

import prs.mecanica.fase.global.SpriteBatchManager;
import prs.mecanica.fase.telas.jogo.atores.controle.ControlerModelo;
import prs.mecanica.fase.telas.jogo.comuns.contratos.geral.ControleJogador;

public class ControleMobile extends ControlerModelo {

    private final Viewport viewport;
    private final Stage stage;

    //Talvez as dimensoes estejam erradas
    private final int LARGURA_TELA = 150;
    private final int HALTURA_TELA = 100;

    public ControleMobile(ControleJogador controleJogador) {
        this.viewport = new StretchViewport(LARGURA_TELA, HALTURA_TELA);

        this.stage = new Stage(this.viewport, SpriteBatchManager.getInstance().getSpriteBatch());
//        this.stage = new Stage();
        this.stage.addActor(new LayoutBtns(controleJogador).getLayout());
    }

    @Override
    public void meDesenhar() {
        this.stage.act(Math.min(Gdx.graphics.getDeltaTime(), 1 / 30f));
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
        if(this.stage != null){
            this.stage.dispose();
        }
    }
}
