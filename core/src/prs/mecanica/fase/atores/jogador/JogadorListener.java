package prs.mecanica.fase.atores.jogador;

import com.badlogic.gdx.InputProcessor;

import prs.mecanica.fase.debugagem.Debugagem;

class JogadorListener implements InputProcessor{

    private int contadorKeyDown;

    private final ControleJogador controle;
    private final JogadorGesture gesture;

    public JogadorListener(ControleJogador controle) {
        this.controle = controle;

        this.gesture = new JogadorGesture();
    }

    @Override
    public boolean keyDown(int keycode) {
        ++this.contadorKeyDown;
        this.controle.iniciarMovimentacao(keycode);
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
        this.controle.iniciarMovimentacao(gesture.getKeyCodeToque(this.controle.getPosicaoJogador(), screenX, screenY));
        return false;
    }

    @Override
    public boolean touchUp(int screenX, int screenY, int pointer, int button) {
        this.controle.pararMovimentacao();
        return false;
    }

    @Override
    public boolean touchDragged(int screenX, int screenY, int pointer) {
        Debugagem.Toque.touchDragged(screenX, screenY, pointer);
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
