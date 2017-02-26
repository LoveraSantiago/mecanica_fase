package prs.mecanica.fase.comuns;

import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.utils.viewport.StretchViewport;
import com.badlogic.gdx.utils.viewport.Viewport;

import prs.mecanica.fase.debugagem.Debugagem;

public class MyCamera {

    public static final float ESCALA = 1f / 10f;

    private static final MyCamera myCamera;
    private final OrthographicCamera camera;

    private final Viewport viewport;
    private final int LARGURA_TELA = 30;

    private final int HALTURA_TELA = 20;

    static{
        myCamera = new MyCamera();
    }

    private MyCamera(){
        this.camera = new OrthographicCamera();
        this.viewport = new StretchViewport(LARGURA_TELA, HALTURA_TELA, this.camera);
        this.viewport.apply();

        this.camera.position.set(this.camera.viewportWidth / 2f, this.camera.viewportHeight / 2f, 0);
        update();
    }

    public static MyCamera getInstance() {
        return myCamera;
    }

    public void resize(int width, int heigth){
        this.viewport.update(width, heigth);
        this.viewport.apply();
    }

    public void update(){
        this.camera.update();
    }

    public OrthographicCamera getCamera() {
        return camera;
    }
}
