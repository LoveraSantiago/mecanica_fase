package prs.mecanica.fase.telas.jogo.atores.controle.desktop;

import com.badlogic.gdx.InputProcessor;
import com.badlogic.gdx.utils.Array;

import prs.mecanica.fase.telas.jogo.atores.controle.ControlerModelo;
import prs.mecanica.fase.telas.jogo.atores.entidades.Direcoes;
import prs.mecanica.fase.telas.jogo.comuns.contratos.geral.ControleJogador;

public class ControleDesktop extends ControlerModelo {

    private final Array<Direcoes> direcoes;
    private Direcoes direcaoTempKD;
    private Direcoes direcaoTempKU;

    private final ControleJogador controle;
    private final KeyCodeUtils keyCodeUtils;

    public ControleDesktop(ControleJogador controle) {
        this.controle = controle;

        this.direcoes = new Array<Direcoes>();
        this.keyCodeUtils = KeyCodeUtils.getInstance();
    }

    @Override
    public boolean keyDown(int keycode) {
        if(this.keyCodeUtils.isKeyCodeMovimentacao(keycode)){
            this.direcaoTempKD = this.keyCodeUtils.getDirecaoFromKeyCode(keycode);
            this.direcoes.add(this.direcaoTempKD);

            if(this.direcoes.size < 2){
                this.controle.initMov(this.direcaoTempKD);
            }
            else{
                this.controle.initMov(this.keyCodeUtils.getDirecaoFromSomaDirecao(this.direcoes));
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
                    this.controle.pararMov();
                }
                else if(this.direcoes.size == 1){
                    this.controle.initMov(this.direcoes.first());
                }
            }
        }
        return false;
    }

    @Override
    public InputProcessor getControle() {
        return this;
    }
}
