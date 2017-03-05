package prs.mecanica.fase.telas.jogo.comuns;

import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.utils.viewport.StretchViewport;
import com.badlogic.gdx.utils.viewport.Viewport;

import prs.mecanica.fase.telas.jogo.comuns.contratos.usuario.ViewPortUser;
import prs.mecanica.fase.telas.jogo.comuns.contratos.tipo.TipoAtualizavel;

public class MyCamera implements TipoAtualizavel, ViewPortUser {

    public static final float ESCALA = 1f / 10f;
    public static final int LARGURA_TELA = 30;
    public static final int HALTURA_TELA = 20;

    private static final MyCamera myCamera;
    private final OrthographicCamera camera;

    private final Viewport viewport;

    static{
        myCamera = new MyCamera();
    }

    private MyCamera(){
        this.camera = new OrthographicCamera();
        this.viewport = new StretchViewport(LARGURA_TELA, HALTURA_TELA, this.camera);
        this.viewport.apply();

        this.camera.position.set(this.camera.viewportWidth / 2f, this.camera.viewportHeight / 2f, 0);
        atualizar();
    }

    public static MyCamera getInstance() {
        return myCamera;
    }

    @Override
    public void resize(int width, int heigth){
        this.viewport.update(width, heigth);
        this.viewport.apply();
    }

    @Override
    public void atualizar() {
        this.camera.update();
    }

    public OrthographicCamera getCamera() {
        return camera;
    }
}
