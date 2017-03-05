package prs.mecanica.fase.telas.jogo.atores.controle;

import com.badlogic.gdx.InputProcessor;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.utils.Disposable;
import com.badlogic.gdx.utils.viewport.StretchViewport;
import com.badlogic.gdx.utils.viewport.Viewport;

import prs.mecanica.fase.global.SpriteBatchManager;
import prs.mecanica.fase.telas.jogo.atores.jogador.ControleJogador;
import prs.mecanica.fase.telas.jogo.comuns.contratos.usuario.ViewPortUser;
import prs.mecanica.fase.telas.jogo.comuns.contratos.tipo.TipoControlavel;


//TODO padronizar singleton
public class Controle implements prs.mecanica.fase.telas.jogo.comuns.contratos.tipo.TipoDesenhavel, ViewPortUser, Disposable, TipoControlavel{

    private static Controle controle;

    private final Viewport viewport;
    private Stage stage;

    private final int LARGURA_TELA = 150;
    private final int HALTURA_TELA = 100;

    private HelperControle helperAtual;
    private final HelperControle helperNaoMobile;
    private final HelperControle helperMobile;

    public Controle() {
        this.viewport = new StretchViewport(LARGURA_TELA, HALTURA_TELA);

        controle = this;

        helperNaoMobile  = new HelperNaoMobile();
        helperMobile     = new HelperMobile();
        this.helperAtual = helperNaoMobile;
    }

    public void registrarControleJogador(ControleJogador controleJogador){
        this.stage = new Stage(this.viewport, SpriteBatchManager.getInstance().getSpriteBatch());

        this.stage.addActor(new LayoutBtns().getLayout());
    }

    @Override
    public void meDesenhar() {
        helperAtual.controlando();
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

    public static Controle getInstance() {
        return controle;
    }

    private interface HelperControle {
        void controlando();
    }

    private class HelperNaoMobile implements HelperControle {
        @Override
        public void controlando() {

        }
    }

    private class HelperMobile implements HelperControle {
        @Override
        public void controlando() {
            stage.draw();
        }
    }
}
