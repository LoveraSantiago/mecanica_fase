package prs.mecanica.fase.telas.jogo.atores.controle;

import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.ui.Button;
import com.badlogic.gdx.scenes.scene2d.ui.ImageButton;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.badlogic.gdx.scenes.scene2d.utils.SpriteDrawable;

import prs.mecanica.fase.telas.jogo.comuns.imagens.Imagens;
import prs.mecanica.fase.telas.jogo.comuns.imagens.ImgLeitor;

class GeneratorBtnsDirecao {



    public Button gerarBotao(Imagens imgU, Imagens imgD){
        Button.ButtonStyle style = new ImageButton.ImageButtonStyle();
        style.up = new SpriteDrawable(ImgLeitor.getInstance().getImg(imgU));
        style.down = new SpriteDrawable(ImgLeitor.getInstance().getImg(imgD));

        Button btn = new Button(style);
        btn.addListener(new ClickListener(){

            @Override
            public void clicked(InputEvent event, float x, float y) {
                super.clicked(event, x, y);
                System.out.println("cricado");
            }
        });
        return btn;
    }
}
