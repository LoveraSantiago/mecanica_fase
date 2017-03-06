package prs.mecanica.fase.telas.jogo.comuns.contratos.geral;

import prs.mecanica.fase.telas.jogo.atores.entidades.Direcoes;
import prs.mecanica.fase.telas.jogo.atores.jogador.PosJog;

public interface ControleJogador {

    void initMovTecla(Direcoes direcao);
    void initMovToque(Direcoes direcao, float limite);
    void pararMov();

    PosJog getPosicaoJogador();
}
