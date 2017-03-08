package prs.mecanica.fase.telas.jogo.atores.controle;

import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.ui.Button;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.badlogic.gdx.scenes.scene2d.utils.SpriteDrawable;

import prs.mecanica.fase.telas.jogo.atores.entidades.Direcoes;
import prs.mecanica.fase.telas.jogo.comuns.contratos.geral.ControleJogador;
import prs.mecanica.fase.telas.jogo.comuns.imagens.Imagens;
import prs.mecanica.fase.telas.jogo.comuns.imagens.ImgLeitor;

class GeradorBtnsDirecao {

    private final ControleJogador controleJogador;

    public GeradorBtnsDirecao(ControleJogador controleJogador) {
        this.controleJogador = controleJogador;
    }

    public Button gerarBotao(Imagens imgU, Imagens imgD, final Direcoes direcao){
        Button.ButtonStyle style = new Button.ButtonStyle();
        style.up = new SpriteDrawable(ImgLeitor.getInstance().getImg(imgU));
        style.down = new SpriteDrawable(ImgLeitor.getInstance().getImg(imgD));

        Button btn = new Button(style);
        btn.addListener(new ClickListener(){

            private boolean result;

            @Override
            public boolean touchDown(InputEvent event, float x, float y, int pointer, int button) {
                this.result  = super.touchDown(event, x, y, pointer, button);
                controleJogador.initMovTecla(direcao);
                return true;
            }

            @Override
            public void touchUp(InputEvent event, float x, float y, int pointer, int button) {
                super.touchUp(event, x, y, pointer, button);
                controleJogador.pararMov();
            }

            @Override
            public void enter(InputEvent event, float x, float y, int pointer, Actor fromActor) {
                controleJogador.initMovTecla(direcao);
            }

            @Override
            public void exit(InputEvent event, float x, float y, int pointer, Actor toActor) {
                super.exit(event, x, y, pointer, toActor);
                controleJogador.pararMov();
            }
        });
        return btn;
    }
}
