package prs.mecanica.fase.telas.jogo.atores.controle.mobile;

import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.ui.Button;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.badlogic.gdx.scenes.scene2d.utils.SpriteDrawable;

import prs.mecanica.fase.telas.jogo.atores.controle.CacheDirecao;
import prs.mecanica.fase.telas.jogo.atores.entidades.DirecaoEstado;
import prs.mecanica.fase.telas.jogo.atores.entidades.Direcoes;
import prs.mecanica.fase.telas.jogo.comuns.contratos.geral.ControleJogador;
import prs.mecanica.fase.telas.jogo.comuns.imagens.Imagens;
import prs.mecanica.fase.telas.jogo.comuns.imagens.ImgLeitor;

import static prs.mecanica.fase.telas.jogo.atores.entidades.DirecaoEstado.ANDANDO;
import static prs.mecanica.fase.telas.jogo.atores.entidades.DirecaoEstado.CORRENDO;
import static prs.mecanica.fase.telas.jogo.atores.entidades.DirecaoEstado.PARADO;

class FactoryBtnsDirecao {

    private final ControleJogador controleJogador;
    private final CacheDirecao cacheDirecao;

    public FactoryBtnsDirecao(ControleJogador controleJogador) {
        this.controleJogador = controleJogador;
        this.cacheDirecao = CacheDirecao.getInstance();
    }

    public Button gerarBotao(Imagens imgU, Imagens imgD, final Direcoes direcao){
        Button.ButtonStyle style = new Button.ButtonStyle();
        style.up = new SpriteDrawable(ImgLeitor.getInstance().getImg(imgU));
        style.down = new SpriteDrawable(ImgLeitor.getInstance().getImg(imgD));
        style.over = new SpriteDrawable(ImgLeitor.getInstance().getImg(imgD));
        style.checked = new SpriteDrawable(ImgLeitor.getInstance().getImg(imgD));
        style.checkedOver = new SpriteDrawable(ImgLeitor.getInstance().getImg(imgD));

        Button btn = new Button(style);
        btn.addListener(new ClickListener(){

            @Override
            public void enter(InputEvent event, float x, float y, int pointer, Actor fromActor) {
                if(cacheDirecao.isMesmaUltimaDirecao(direcao) && getTapCount() > 1){
                    controleJogador.initMov2(direcao, CORRENDO);
                }
                else{
                    controleJogador.initMov2(direcao, ANDANDO);
                }
            }

            @Override
            public void exit(InputEvent event, float x, float y, int pointer, Actor toActor) {
                controleJogador.initMov2(direcao, PARADO);
            }
        });
        return btn;
    }
}
