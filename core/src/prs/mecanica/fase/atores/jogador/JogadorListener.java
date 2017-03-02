package prs.mecanica.fase.atores.jogador;

import com.badlogic.gdx.InputProcessor;
import com.badlogic.gdx.graphics.Camera;
import com.badlogic.gdx.math.Vector3;

import prs.mecanica.fase.atores.entidades.direcao.DirecaoManager;
import prs.mecanica.fase.comuns.MyCamera;

class JogadorListener implements InputProcessor{

    private int contadorKeyDown;

    private final Vector3 vetor3;
    private final Camera camera;

    private final ControleJogador controle;
    private final JogadorGesture gesture;
    private final DirecaoManager direcaoManager;

    public JogadorListener(ControleJogador controle) {
        this.controle = controle;
        this.gesture = new JogadorGesture();

        this.vetor3 = new Vector3();
        this.camera = MyCamera.getInstance().getCamera();

        this.direcaoManager = DirecaoManager.getInstance();
    }

//    @Override
//    public boolean keyDown(int keycode) {
//        ++this.contadorKeyDown;
//        this.controle.iniciarMovimentacaoTecla(keycode);
//        return false;
//    }

    @Override
    public boolean keyDown(int keycode) {
        ++this.contadorKeyDown;
        this.controle.iniciarMovimentacaoTecla(this.direcaoManager.getDirecaoFromKeyCode(keycode));
        return false;
    }

    @Override
    public boolean keyUp(int keycode) {
        if(--this.contadorKeyDown == 0){
            this.controle.pararMovimentacao();
        }
        return false;
    }

    @Override
    public boolean keyTyped(char character) {
        return false;
    }

    @Override
    public boolean touchDown(int screenX, int screenY, int pointer, int button) {
        this.vetor3.set(screenX, screenY, 0);
        this.vetor3.set(this.camera.unproject(this.vetor3));

        if(this.gesture.isToqueValido(this.controle.getPosicaoJogador(), this.vetor3.x, this.vetor3.y)){
            this.controle.iniciarMovimentacaoToque(this.direcaoManager.getDirecaoFromKeyCode(this.gesture.getKeyCode()), this.gesture.getLimite());
        }
        return false;
    }

    @Override
    public boolean touchUp(int screenX, int screenY, int pointer, int button) {
        this.controle.pararMovimentacao();
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
