package prs.mecanica.fase.atores.entidades.controle;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.ui.Button;
import com.badlogic.gdx.scenes.scene2d.ui.ImageButton;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.badlogic.gdx.scenes.scene2d.utils.SpriteDrawable;

import prs.mecanica.fase.comuns.imagens.Imagens;
import prs.mecanica.fase.comuns.imagens.ImgLeitor;

class Parser {

    public Table parsear(){
        Skin skin = new Skin(Gdx.files.internal("skins/uiskin.json"));
        skin.addRegions(ImgLeitor.getInstance().getTextureAtlas());

        ImageButton.ImageButtonStyle style = new ImageButton.ImageButtonStyle(skin.get(Button.ButtonStyle.class));
        style.imageUp = skin.getDrawable(Imagens.BTN_CIMA.getNomeArquivo());
        style.imageDown = skin.getDrawable(Imagens.BTN_BAIXO.getNomeArquivo());

        ImageButton btn = new ImageButton(style);
        btn.addListener(new ClickListener(){
            @Override
            public void clicked(InputEvent event, float x, float y) {
                super.clicked(event, x, y);
                System.out.println("cricado");
            }
        });
        btn.scaleBy(.01f);

        Table table = new Table();
        table.setDebug(true);
        table.setFillParent(true);
//        table.bottom();
//        table.left();

        table.add(btn);
        return table;
    }

}
