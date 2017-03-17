package prs.mecanica.fase.telas.jogo.atores.camera;

import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.math.Rectangle;

class MovimentadorCamera {

    private final OrthographicCamera camera;
    private final Rectangle limitesCamera;

    public MovimentadorCamera(OrthographicCamera camera) {
        this.camera = camera;

        this.limitesCamera = new Rectangle();
    }




}
