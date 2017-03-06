package prs.mecanica.fase.telas.jogo.atores.controle;

import com.badlogic.gdx.scenes.scene2d.ui.Button;
import com.badlogic.gdx.scenes.scene2d.ui.Table;

import prs.mecanica.fase.telas.jogo.atores.entidades.Direcoes;
import prs.mecanica.fase.telas.jogo.comuns.contratos.geral.ControleJogador;
import prs.mecanica.fase.telas.jogo.comuns.imagens.Imagens;

class LayoutBtns {

    private final int LARGURA_BTN = 10;
    private final int HALTURA_BTN = 11;

    private final GeradorBtnsDirecao gerador;
    
    public LayoutBtns(ControleJogador controleJogador) {
        this.gerador = new GeradorBtnsDirecao(controleJogador);
    }

    public Table getLayout(){

        Table table = new Table();
        table.setTransform(true);
//        table.setDebug(true);
        table.setFillParent(true);

        adicionarBotoes(table);
        table.bottom().left().padBottom(HALTURA_BTN / 2).padLeft(LARGURA_BTN);

        table.rotateBy(5);
        table.setRotation(7.5f);
        return table;
    }

    private void adicionarBotoes(Table table){
        Button btn = null;
        
        //botao esquerda superior
        btn = this.gerador.gerarBotao(Imagens.BTN_ESQ_SUP_U, Imagens.BTN_ESQ_SUP_D, Direcoes.ESQUERDA_SUPERIOR);
        table.add(btn).width(LARGURA_BTN).height(HALTURA_BTN);

        //botao cima
        btn = this.gerador.gerarBotao(Imagens.BTN_CIMA_U, Imagens.BTN_CIMA_D, Direcoes.CIMA);
        table.add(btn).width(LARGURA_BTN).height(HALTURA_BTN);

        //botao direita superior
        btn = this.gerador.gerarBotao(Imagens.BTN_DIR_SUP_U, Imagens.BTN_DIR_SUP_D, Direcoes.DIREIRA_SUPERIOR);
        table.add(btn).width(LARGURA_BTN).height(HALTURA_BTN);

        table.row();

        //botao esquerda
        btn = this.gerador.gerarBotao(Imagens.BTN_ESQ_U, Imagens.BTN_ESQ_D, Direcoes.ESQUERDA);
        table.add(btn).width(LARGURA_BTN).height(HALTURA_BTN);

        table.add().width(LARGURA_BTN).height(HALTURA_BTN);

        //botao direita
        btn = this.gerador.gerarBotao(Imagens.BTN_DIR_U, Imagens.BTN_DIR_D, Direcoes.DIREITA);
        table.add(btn).width(LARGURA_BTN).height(HALTURA_BTN);

        table.row();

        //botao esquerda inferior
        btn = this.gerador.gerarBotao(Imagens.BTN_ESQ_INF_U, Imagens.BTN_ESQ_INF_D, Direcoes.ESQUERDA_INFERIOR);
        table.add(btn).width(LARGURA_BTN).height(HALTURA_BTN);

        //botao baixo
        btn = this.gerador.gerarBotao(Imagens.BTN_BAIXO_U, Imagens.BTN_BAIXO_D, Direcoes.BAIXO);
        table.add(btn).width(LARGURA_BTN).height(HALTURA_BTN);

        //botao direita inferior
        btn = this.gerador.gerarBotao(Imagens.BTN_DIR_INF_U, Imagens.BTN_DIR_INF_D, Direcoes.DIREITA_INFERIOR);
        table.add(btn).width(LARGURA_BTN).height(HALTURA_BTN);
    }

}
