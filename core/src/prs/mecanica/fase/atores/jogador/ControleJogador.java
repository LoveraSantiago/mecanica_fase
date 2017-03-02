package prs.mecanica.fase.atores.jogador;

import prs.mecanica.fase.atores.entidades.direcao.Direcoes;


//todo diminuir nomes dos metodos
interface ControleJogador {

    void initMovTecla(Direcoes direcao);
    void initMovToque(Direcoes direcao, float limite);
    void pararMov();

    PosJog getPosicaoJogador();
}
