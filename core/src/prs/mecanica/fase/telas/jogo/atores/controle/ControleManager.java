package prs.mecanica.fase.telas.jogo.atores.controle;

import prs.mecanica.fase.global.Configuracao;
import prs.mecanica.fase.global.RegistradorInputProcessors;
import prs.mecanica.fase.telas.jogo.atores.controle.desktop.ControleDesktop;
import prs.mecanica.fase.telas.jogo.atores.controle.mobile.ControleMobile;
import prs.mecanica.fase.telas.jogo.comuns.contratos.geral.ControleJogador;

public class ControleManager extends ControleModelo {

    private final static ControleManager controleManager;

    private ControleModelo controlerAtual;

    static{
        controleManager = new ControleManager();
    }

    private ControleManager(){
    }

    public void definirControle(ControleJogador controleJogador){
        if(Configuracao.getInstance().isMobile()){
            this.controlerAtual = new ControleMobile(controleJogador);
        }
        else{
            this.controlerAtual = new ControleDesktop(controleJogador);
        }
        RegistradorInputProcessors.getInstance().adicionarControlavel(this.controlerAtual);
    }

    @Override
    public void meDesenhar() {
        this.controlerAtual.meDesenhar();
    }

    @Override
    public void resize(int width, int height) {
        this.controlerAtual.resize(width, height);
    }

    @Override
    public void dispose() {
        this.controlerAtual.dispose();
    }

    public static ControleManager getInstance() {
        return controleManager;
    }
}
