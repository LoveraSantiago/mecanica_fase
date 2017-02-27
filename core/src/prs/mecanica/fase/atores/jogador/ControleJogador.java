package prs.mecanica.fase.atores.jogador;

interface ControleJogador {

    void iniciarMovimentacao(int keyCode);
    void pararMovimentacao();
    PosJog getPosicaoJogador();
}
