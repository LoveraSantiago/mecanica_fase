package prs.mecanica.fase.telas.jogo.atores.controle;

import prs.mecanica.fase.telas.jogo.atores.entidades.Direcoes;

import static prs.mecanica.fase.telas.jogo.atores.entidades.Direcoes.INICIO;

public class CacheDirecao {

    private final static CacheDirecao cacheDirecao;
    private Direcoes direcao;
    private boolean resultado;

    static{
        cacheDirecao = new CacheDirecao();
    }

    private CacheDirecao(){
        this.direcao = INICIO;
    }

    public boolean isMesmaUltimaDirecao(Direcoes direcao){
        if(this.direcao == direcao){
            this.resultado = true;
        }
        else{
            this.resultado = false;
        }
        this.direcao = direcao;
        return this.resultado;
    }

    public static CacheDirecao getInstance() {
        return cacheDirecao;
    }
}
