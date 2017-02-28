package prs.mecanica.fase.atores.jogador;

interface ControleJogador {

    void iniciarMovimentacaoTecla(int keyCode);
    void iniciarMovimentacaoToque(int keyCode, float limite);
    void pararMovimentacao();
    PosJog getPosicaoJogador();

}
