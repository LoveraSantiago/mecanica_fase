package prs.mecanica.fase.atores.jogador;

import prs.mecanica.fase.atores.entidades.direcao.Direcoes;

interface ControleJogador {

    void initMovTecla(Direcoes direcao);
    void initMovToque(Direcoes direcao, float limite);
    void pararMov();

    PosJog getPosicaoJogador();
}
