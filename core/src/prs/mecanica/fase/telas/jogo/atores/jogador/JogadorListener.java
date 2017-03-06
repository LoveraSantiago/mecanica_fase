package prs.mecanica.fase.telas.jogo.atores.jogador;

import com.badlogic.gdx.InputProcessor;
import com.badlogic.gdx.utils.Array;

import prs.mecanica.fase.telas.jogo.atores.entidades.Direcoes;

class JogadorListener implements InputProcessor{

    private final Array<Direcoes> direcoes;
    private Direcoes direcaoTempKD;
    private Direcoes direcaoTempKU;

    private final prs.mecanica.fase.telas.jogo.comuns.contratos.geral.ControleJogador controle;
    private final KeyCodeUtils keyCodeUtils;

    public JogadorListener(prs.mecanica.fase.telas.jogo.comuns.contratos.geral.ControleJogador controle) {
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
                this.controle.initMovTecla(this.direcaoTempKD);
            }
            else{
                this.controle.initMovTecla(this.keyCodeUtils.getDirecaoFromSomaDirecao(this.direcoes));
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
                    this.controle.initMovTecla(this.direcoes.first());
                }
            }
        }
        return false;
    }

    @Override
    public boolean keyTyped(char character) {
        return false;
    }

    @Override
    public boolean touchDown(int screenX, int screenY, int pointer, int button) {
        return false;
    }

    @Override
    public boolean touchUp(int screenX, int screenY, int pointer, int button) {
        return false;
    }

    @Override
    public boolean touchDragged(int screenX, int screenY, int pointer) {
        return false;
    }

    @Override
    public boolean mouseMoved(int screenX, int screenY) {
        return false;
    }

    @Override
    public boolean scrolled(int amount) {
        return false;
    }
}
