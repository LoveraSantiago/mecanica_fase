package prs.mecanica.fase.telas.jogo.atores.jogador;

import com.badlogic.gdx.InputProcessor;
import com.badlogic.gdx.graphics.Camera;
import com.badlogic.gdx.math.Vector3;
import com.badlogic.gdx.utils.Array;

import prs.mecanica.fase.telas.jogo.atores.entidades.Direcoes;
import prs.mecanica.fase.telas.jogo.comuns.MyCamera;

class JogadorListener implements InputProcessor{

    private final Array<Direcoes> direcoes;
    private Direcoes direcaoTempKD;
    private Direcoes direcaoTempKU;

    private final Vector3 vetor3;
    private final Camera camera;

    private final prs.mecanica.fase.telas.jogo.comuns.contratos.geral.ControleJogador controle;
    private final DirecaoManager direcaoManager;
    private final KeyCodeFilter keyCodeFilter;

    public JogadorListener(prs.mecanica.fase.telas.jogo.comuns.contratos.geral.ControleJogador controle) {
        this.controle = controle;

        this.vetor3 = new Vector3();
        this.camera = MyCamera.getInstance().getCamera();

        this.direcoes = new Array<Direcoes>();
        this.keyCodeFilter = new KeyCodeFilter();
        this.direcaoManager = DirecaoManager.getInstance();
    }

    @Override
    public boolean keyDown(int keycode) {
        if(this.keyCodeFilter.isKeyCodeMovimentacao(keycode)){
            this.direcaoTempKD = this.direcaoManager.getDirecaoFromKeyCode(keycode);
            this.direcoes.add(this.direcaoTempKD);

            if(this.direcoes.size < 2){
                this.controle.initMovTecla(this.direcaoTempKD);
            }
            else{
                this.controle.initMovTecla(this.direcaoManager.getDirecaoFromSomaDirecao(this.direcoes));
            }
        }
        return false;
    }

    @Override
    public boolean keyUp(int keycode) {
        if(this.keyCodeFilter.isKeyCodeMovimentacao(keycode)){
            this.direcaoTempKU = this.direcaoManager.getDirecaoFromKeyCode(keycode);
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
