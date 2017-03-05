package prs.mecanica.fase.telas.jogo.atores.controle;

import com.badlogic.gdx.scenes.scene2d.ui.Button;
import com.badlogic.gdx.scenes.scene2d.ui.Table;

class LayoutBtns {

    private final int LARGURA_BTN = 10;
    private final int HALTURA_BTN = 11;

    public Table getLayout(){

        Table table = new Table();
        table.setTransform(true);
//        table.setDebug(true);
        table.setFillParent(true);

        adicionarBotoes(table);
        table.bottom().left().padBottom(HALTURA_BTN / 2).padLeft(LARGURA_BTN);

        table.rotateBy(5);
        table.setRotation(5);
        return table;
    }

    private void adicionarBotoes(Table table){
        Button btn = null;

        GeneratorBtnsDirecao generator = new GeneratorBtnsDirecao();

        //botao esquerda superior
        btn = generator.gerarBotao(prs.mecanica.fase.telas.jogo.comuns.imagens.Imagens.BTN_ESQ_SUP_U, prs.mecanica.fase.telas.jogo.comuns.imagens.Imagens.BTN_ESQ_SUP_D);
        table.add(btn).width(LARGURA_BTN).height(HALTURA_BTN);

        //botao cima
        btn = generator.gerarBotao(prs.mecanica.fase.telas.jogo.comuns.imagens.Imagens.BTN_CIMA_U, prs.mecanica.fase.telas.jogo.comuns.imagens.Imagens.BTN_CIMA_D);
        table.add(btn).width(LARGURA_BTN).height(HALTURA_BTN);

        //botao direita superior
        btn = generator.gerarBotao(prs.mecanica.fase.telas.jogo.comuns.imagens.Imagens.BTN_DIR_SUP_U, prs.mecanica.fase.telas.jogo.comuns.imagens.Imagens.BTN_DIR_SUP_D);
        table.add(btn).width(LARGURA_BTN).height(HALTURA_BTN);

        table.row();

        //botao esquerda
        btn = generator.gerarBotao(prs.mecanica.fase.telas.jogo.comuns.imagens.Imagens.BTN_ESQ_U, prs.mecanica.fase.telas.jogo.comuns.imagens.Imagens.BTN_ESQ_D);
        table.add(btn).width(LARGURA_BTN).height(HALTURA_BTN);

        table.add().width(LARGURA_BTN).height(HALTURA_BTN);

        //botao direita
        btn = generator.gerarBotao(prs.mecanica.fase.telas.jogo.comuns.imagens.Imagens.BTN_DIR_U, prs.mecanica.fase.telas.jogo.comuns.imagens.Imagens.BTN_DIR_D);
        table.add(btn).width(LARGURA_BTN).height(HALTURA_BTN);

        table.row();

        //botao esquerda inferior
        btn = generator.gerarBotao(prs.mecanica.fase.telas.jogo.comuns.imagens.Imagens.BTN_ESQ_INF_U, prs.mecanica.fase.telas.jogo.comuns.imagens.Imagens.BTN_ESQ_INF_D);
        table.add(btn).width(LARGURA_BTN).height(HALTURA_BTN);

        //botao baixo
        btn = generator.gerarBotao(prs.mecanica.fase.telas.jogo.comuns.imagens.Imagens.BTN_BAIXO_U, prs.mecanica.fase.telas.jogo.comuns.imagens.Imagens.BTN_BAIXO_D);
        table.add(btn).width(LARGURA_BTN).height(HALTURA_BTN);

        //botao direita inferior
        btn = generator.gerarBotao(prs.mecanica.fase.telas.jogo.comuns.imagens.Imagens.BTN_DIR_INF_U, prs.mecanica.fase.telas.jogo.comuns.imagens.Imagens.BTN_DIR_INF_D);
        table.add(btn).width(LARGURA_BTN).height(HALTURA_BTN);
    }

}
