package prs.mecanica.fase.atores.mapas;

import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.maps.tiled.renderers.OrthogonalTiledMapRenderer;
import com.badlogic.gdx.math.Rectangle;

import prs.mecanica.fase.comuns.MapaLeitor;
import prs.mecanica.fase.comuns.MyCamera;
import prs.mecanica.fase.comuns.MySpriteBatch;
import prs.mecanica.fase.comuns.contratos.TipoDesenhavel;

public class MapaCasa implements TipoDesenhavel {

    private static MapaCasa mapaCasa;

    private OrthogonalTiledMapRenderer orthogonalTiledMapRenderer;
    private OrthographicCamera camera;

    private final SpriteBatch spriteBatch;

    public MapaCasa(){
        this.orthogonalTiledMapRenderer = MapaLeitor.getInstance().lerMapa(Mapas.CASA, MyCamera.ESCALA);
        this.camera = MyCamera.getInstance().getCamera();

        this.spriteBatch = MySpriteBatch.getInstance().getSpriteBatch();
        this.orthogonalTiledMapRenderer.setView(this.camera);

        mapaCasa = this;
    }

    public static MapaCasa getInstance() {
        return mapaCasa;
    }

    @Override
    public void meDesenhar() {
        this.spriteBatch.begin();
        this.orthogonalTiledMapRenderer.render();
        this.spriteBatch.end();
    }

    public OrthogonalTiledMapRenderer getOrthogonalTiledMapRenderer() {
        return orthogonalTiledMapRenderer;
    }
}
