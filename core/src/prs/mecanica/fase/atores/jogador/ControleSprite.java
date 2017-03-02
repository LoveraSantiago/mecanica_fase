package prs.mecanica.fase.atores.jogador;

import com.badlogic.gdx.graphics.g2d.Sprite;

interface ControleSprite {

    float getWidth();
    float getHeigth();

    void updatePosicaoSprite(Sprite sprite);

}
