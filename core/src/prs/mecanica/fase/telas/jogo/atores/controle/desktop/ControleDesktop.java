package prs.mecanica.fase.telas.jogo.atores.controle.desktop;

import com.badlogic.gdx.InputProcessor;
import com.badlogic.gdx.utils.Array;

import prs.mecanica.fase.telas.jogo.atores.controle.CacheDirecao;
import prs.mecanica.fase.telas.jogo.atores.controle.ControleModelo;
import prs.mecanica.fase.telas.jogo.atores.entidades.Direcoes;
import prs.mecanica.fase.telas.jogo.comuns.contratos.geral.ControleJogador;

import static prs.mecanica.fase.telas.jogo.atores.entidades.DirecaoEstado.ANDANDO;
import static prs.mecanica.fase.telas.jogo.atores.entidades.DirecaoEstado.CORRENDO;
import static prs.mecanica.fase.telas.jogo.atores.entidades.DirecaoEstado.PARADO;

public class ControleDesktop extends ControleModelo {

    private final Array<Direcoes> direcoes;
    private Direcoes direcaoTempKD;
    private Direcoes direcaoTempKU;

    private final ControleJogador controle;
    private final KeyCodeUtils keyCodeUtils;

    private final CacheDirecao cacheDirecao;
    private final TapKeyboard tapKeyboard;

    public ControleDesktop(ControleJogador controle) {
        this.controle = controle;

        this.direcoes = new Array<Direcoes>();
        this.keyCodeUtils = KeyCodeUtils.getInstance();

        this.cacheDirecao = CacheDirecao.getInstance();
        this.tapKeyboard = new TapKeyboard(100);
    }

    @Override
    public boolean keyDown(int keycode) {
        if(this.keyCodeUtils.isKeyCodeMovimentacao(keycode)){
            this.direcaoTempKD = this.keyCodeUtils.getDirecaoFromKeyCode(keycode);
            this.direcoes.add(this.direcaoTempKD);

            if(this.cacheDirecao.isMesmaUltimaDirecao(this.direcaoTempKD) && this.tapKeyboard.isTap()){
                if(this.direcoes.size < 2){
                    this.controle.iniciarMov(this.direcaoTempKD, CORRENDO);
                }
                else{
                    this.controle.iniciarMov(this.keyCodeUtils.getDirecaoFromSomaDirecao(this.direcoes), CORRENDO);
                }
            }
            else{
                if(this.direcoes.size < 2){
                    this.controle.iniciarMov(this.direcaoTempKD, ANDANDO);
                }
                else{
                    this.controle.iniciarMov(this.keyCodeUtils.getDirecaoFromSomaDirecao(this.direcoes), ANDANDO);
                }
            }
        }
        return false;
    }

    @Override
    public boolean keyUp(int keycode) {
        if(this.keyCodeUtils.isKeyCodeMovimentacao(keycode)){

            this.direcaoTempKU = this.keyCodeUtils.getDirecaoFromKeyCode(keycode);
            if(this.direcoes.removeValue(this.direcaoTempKU, true)){
                if(this.direcoes.size == 0){
                    this.controle.iniciarMov(Direcoes.CIMA, PARADO);
                }
                else if(this.direcoes.size == 1){
                    this.controle.iniciarMov(this.direcoes.first(), ANDANDO);
                }
            }

            this.tapKeyboard.iniciar();
        }
        return false;
    }

    @Override
    public InputProcessor getControle() {
        return this;
    }
}
