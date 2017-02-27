package prs.mecanica.fase.atores.jogador;

import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.math.Vector3;

import prs.mecanica.fase.comuns.MyCamera;

public class JogadorGesture {

    private float difC;
    private float difB;
    private float difE;
    private float difD;

    private final Vector3 vetor3;

    private final OrthographicCamera camera;

    public JogadorGesture() {
        this.camera = MyCamera.getInstance().getCamera();

        this.vetor3 = new Vector3();
    }

    public int getKeyCodeToque(PosJog posJog, float xToque, float yToque){
        this.vetor3.set(xToque, yToque, 0);
        this.vetor3.set(this.camera.unproject(this.vetor3));

        this.difC = this.vetor3.y - posJog.getY();
        this.difB = posJog.getY() - this.vetor3.y;
        this.difD = this.vetor3.x - posJog.getX();
        this.difE = posJog.getX() - this.vetor3.x;

        if(this.difC > this.difB && this.difC > this.difD && this.difC > this.difE){
            return Input.Keys.UP;
        }
        if(this.difB > this.difC && this.difB > this.difD && this.difB > this.difE){
            return Input.Keys.DOWN;
        }
        if(this.difD > this.difB && this.difD > this.difC && this.difD > this.difE){
            return Input.Keys.RIGHT;
        }
        if(this.difE > this.difB && this.difE > this.difD && this.difE > this.difC){
            return Input.Keys.LEFT;
        }
        return Input.Keys.UP;
    }
}
