package prs.mecanica.fase.telas.jogo.atores.jogador;

import com.badlogic.gdx.graphics.g2d.Sprite;

interface ControleSprite {

    float getWidth();
    float getHeigth();

    void updatePosicaoSprite(Sprite sprite);

}
