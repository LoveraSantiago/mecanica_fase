package prs.mecanica.fase.atores.mapas;

import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.maps.tiled.TiledMapRenderer;

import prs.mecanica.fase.comuns.MapaLeitor;
import prs.mecanica.fase.comuns.MyCamera;
import prs.mecanica.fase.comuns.MySpriteBatch;
import prs.mecanica.fase.comuns.contratos.TipoDesenhavel;

public class MapaCasa implements TipoDesenhavel {

    private TiledMapRenderer renderer;
    private OrthographicCamera camera;

    private final SpriteBatch spriteBatch;

    public MapaCasa(){
        this.renderer = MapaLeitor.getInstance().lerMapa(Mapas.CASA, .1f);
        this.camera = MyCamera.getInstance().getCamera();

        this.spriteBatch = MySpriteBatch.getInstance().getSpriteBatch();
    }

    @Override
    public void meDesenhar() {
        this.spriteBatch.begin();

        this.renderer.setView(this.camera);
        this.renderer.render();

        this.spriteBatch.end();
    }
}
