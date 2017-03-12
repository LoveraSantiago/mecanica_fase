package prs.mecanica.fase.telas.jogo.comuns.contratos.geral;

import prs.mecanica.fase.telas.jogo.atores.entidades.DirecaoEstado;
import prs.mecanica.fase.telas.jogo.atores.entidades.Direcoes;

public interface ControleJogador {

    void iniciarMov(Direcoes direcao, DirecaoEstado direcaoEstado);
}
