package prs.mecanica.fase.atores.entidades.controle;

import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.ui.Button;
import com.badlogic.gdx.scenes.scene2d.ui.ImageButton;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.badlogic.gdx.scenes.scene2d.utils.SpriteDrawable;

import prs.mecanica.fase.comuns.imagens.Imagens;
import prs.mecanica.fase.comuns.imagens.ImgLeitor;

class Parser {

    private final int LARGURA_BTN = 10;
    private final int HALTURA_BTN = 10;

    public Table parsear(){

        Table table = new Table();
        table.setDebug(true);
        table.setFillParent(true);

        adicionarBotoes(table);

        table.bottom().left().padBottom(HALTURA_BTN / 2).padLeft(LARGURA_BTN / 2).rotateBy(45);


        return table;
    }

    private void adicionarBotoes(Table table){
        Button btn = null;

        GeneratorBtnsDirecao generator = new GeneratorBtnsDirecao();

        //botao esquerda superior
        btn = generator.gerarBotao(Imagens.BTN_ESQ_SUP_U, Imagens.BTN_ESQ_SUP_D);
        table.add(btn).width(LARGURA_BTN).height(HALTURA_BTN);

        //botao cima
        btn = generator.gerarBotao(Imagens.BTN_CIMA_U, Imagens.BTN_CIMA_D);
        table.add(btn).width(LARGURA_BTN).height(HALTURA_BTN);

        //botao direita superior
        btn = generator.gerarBotao(Imagens.BTN_DIR_SUP_U, Imagens.BTN_DIR_SUP_D);
        table.add(btn).width(LARGURA_BTN).height(HALTURA_BTN);

        table.row();

        //botao esquerda
        btn = generator.gerarBotao(Imagens.BTN_ESQ_U, Imagens.BTN_ESQ_D);
        table.add(btn).width(LARGURA_BTN).height(HALTURA_BTN);

        table.add().width(LARGURA_BTN).height(HALTURA_BTN);

        //botao direita
        btn = generator.gerarBotao(Imagens.BTN_DIR_U, Imagens.BTN_DIR_D);
        table.add(btn).width(LARGURA_BTN).height(HALTURA_BTN);

        table.row();

        //botao esquerda inferior
        btn = generator.gerarBotao(Imagens.BTN_ESQ_INF_U, Imagens.BTN_ESQ_INF_D);
        table.add(btn).width(LARGURA_BTN).height(HALTURA_BTN);

        //botao baixo
        btn = generator.gerarBotao(Imagens.BTN_BAIXO_U, Imagens.BTN_BAIXO_D);
        table.add(btn).width(LARGURA_BTN).height(HALTURA_BTN);

        //botao direita inferior
        btn = generator.gerarBotao(Imagens.BTN_DIR_INF_U, Imagens.BTN_DIR_INF_D);
        table.add(btn).width(LARGURA_BTN).height(HALTURA_BTN);
    }

}
