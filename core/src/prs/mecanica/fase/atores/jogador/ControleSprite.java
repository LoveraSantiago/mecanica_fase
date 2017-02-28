package prs.mecanica.fase.atores.jogador;

import com.badlogic.gdx.graphics.g2d.Sprite;

interface ControleSprite {

    float getWidth();
    float getHeigth();

    boolean isSpriteCima(Sprite sprite);
    boolean isSpriteBaixo(Sprite sprite);
    boolean isSpriteDireita(Sprite sprite);
    boolean isSpriteEsquerda(Sprite sprite);

    void updatePosicaoSprite(Sprite sprite);

}
