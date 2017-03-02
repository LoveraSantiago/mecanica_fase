package prs.mecanica.fase.atores.jogador;

import prs.mecanica.fase.atores.entidades.direcao.Direcoes;


//todo diminuir nomes dos metodos
interface ControleJogador {

    void iniciarMovimentacaoTecla(Direcoes direcao);
    void iniciarMovimentacaoToque(Direcoes direcao, float limite);
    void pararMovimentacao();

    PosJog getPosicaoJogador();
}
