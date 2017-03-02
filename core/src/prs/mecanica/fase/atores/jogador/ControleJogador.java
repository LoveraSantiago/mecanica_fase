package prs.mecanica.fase.atores.jogador;

import prs.mecanica.fase.atores.entidades.direcao.Direcoes;


//todo diminuir nomes dos metodos
interface ControleJogador {

//    void iniciarMovimentacaoTecla(int keyCode);
    void iniciarMovimentacaoTecla(Direcoes direcao);
//    void iniciarMovimentacaoToque(int keyCode, float limite);
    void iniciarMovimentacaoToque(Direcoes direcao, float limite);
    void pararMovimentacao();

    PosJog getPosicaoJogador();
}
