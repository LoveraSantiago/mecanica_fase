package prs.mecanica.fase.telas.jogo.atores.jogador;

import prs.mecanica.fase.telas.jogo.atores.entidades.Direcoes;

interface ControleJogador {

    void initMovTecla(Direcoes direcao);
    void initMovToque(Direcoes direcao, float limite);
    void pararMov();

    PosJog getPosicaoJogador();
}
