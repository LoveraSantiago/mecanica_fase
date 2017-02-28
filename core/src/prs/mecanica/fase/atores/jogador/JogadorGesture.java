package prs.mecanica.fase.atores.jogador;

import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector3;

import prs.mecanica.fase.comuns.MyCamera;
import prs.mecanica.fase.debugagem.Debugagem;

class JogadorGesture {

    private int keyCode;
    private float limite;

    private final Rectangle areaC;
    private final Rectangle areaB;
    private final Rectangle areaE;
    private final Rectangle areaD;

    public JogadorGesture() {
        this.areaC = new Rectangle();
        this.areaB = new Rectangle();
        this.areaE = new Rectangle();
        this.areaD = new Rectangle();
    }

    public boolean isToqueValido(PosJog posJog, float xToque, float yToque){
        setAreas(posJog);

        if(this.areaC.contains(xToque, yToque)){
            this.keyCode = Input.Keys.UP;
            this.limite = yToque;
            return true;
        }
        if(this.areaB.contains(xToque, yToque)){
            this.keyCode = Input.Keys.DOWN;
            this.limite = yToque;
            return true;
        }
        if(this.areaD.contains(xToque, yToque)){
            this.keyCode = Input.Keys.RIGHT;
            this.limite = xToque;
            return true;
        }
        if(this.areaE.contains(xToque, yToque)){
            this.keyCode = Input.Keys.LEFT;
            this.limite = xToque;
            return true;
        }
        return false;
    }

    private void setAreas(PosJog posJog){
        this.areaC.set(posJog.getX(), posJog.getY() + posJog.getH(), posJog.getW(), MyCamera.HALTURA_TELA);
        this.areaB.set(posJog.getX(), posJog.getY() - MyCamera.HALTURA_TELA, posJog.getW(), MyCamera.HALTURA_TELA);
        this.areaD.set(posJog.getX() + posJog.getW(), posJog.getY(), MyCamera.LARGURA_TELA, posJog.getH());
        this.areaE.set(posJog.getX() - MyCamera.LARGURA_TELA, posJog.getY(), MyCamera.LARGURA_TELA, posJog.getH());
    }

    public int getKeyCode() {
        return keyCode;
    }

    public float getLimite() {
        return limite;
    }
}
