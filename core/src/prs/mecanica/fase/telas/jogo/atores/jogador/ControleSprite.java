package prs.mecanica.fase.telas.jogo.atores.jogador;

import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.math.Rectangle;

interface ControleSprite {

    float getWidth();
    float getHeigth();

    void updatePosicaoSprite(Sprite sprite);

}
