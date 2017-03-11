package prs.mecanica.fase.telas.jogo.comuns.contratos.geral;

import prs.mecanica.fase.telas.jogo.atores.entidades.DirecaoEstado;
import prs.mecanica.fase.telas.jogo.atores.entidades.Direcoes;

public interface ControleJogador {

    void initMov(Direcoes direcao);
    void pararMov();
    void initMov2(Direcoes direcao, DirecaoEstado direcaoEstado);
}
