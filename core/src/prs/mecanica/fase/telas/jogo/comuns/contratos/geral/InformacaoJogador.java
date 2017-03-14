package prs.mecanica.fase.telas.jogo.comuns.contratos.geral;

import com.badlogic.gdx.math.Rectangle;

import prs.mecanica.fase.telas.jogo.atores.jogador.PosicaoJogador;

public interface InformacaoJogador extends PosicaoJogador{

    float getHaltura();
    float getLargura();

    Rectangle getBounds();

}
