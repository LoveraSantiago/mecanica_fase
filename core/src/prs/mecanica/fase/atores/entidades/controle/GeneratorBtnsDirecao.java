package prs.mecanica.fase.atores.entidades.controle;

import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.ui.ImageButton;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.badlogic.gdx.scenes.scene2d.utils.SpriteDrawable;

import prs.mecanica.fase.comuns.imagens.Imagens;
import prs.mecanica.fase.comuns.imagens.ImgLeitor;

class GeneratorBtnsDirecao {

    public ImageButton gerarBotao(Imagens imgU, Imagens imgD){
        ImageButton.ImageButtonStyle style = new ImageButton.ImageButtonStyle();
        style.imageUp   = new SpriteDrawable(ImgLeitor.getInstance().getImg(imgU));
        style.imageDown = new SpriteDrawable(ImgLeitor.getInstance().getImg(imgD));

        ImageButton btn = new ImageButton(style);
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
