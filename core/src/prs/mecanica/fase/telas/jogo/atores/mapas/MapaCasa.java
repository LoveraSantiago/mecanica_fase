package prs.mecanica.fase.telas.jogo.atores.mapas;

import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.maps.tiled.renderers.OrthogonalTiledMapRenderer;

import prs.mecanica.fase.telas.jogo.comuns.imagens.MapaLeitor;
import prs.mecanica.fase.telas.jogo.comuns.MyCamera;

public class MapaCasa implements prs.mecanica.fase.telas.jogo.comuns.contratos.tipo.TipoDesenhavel {

    private static MapaCasa mapaCasa;

    private OrthogonalTiledMapRenderer orthogonalTiledMapRenderer;
    private OrthographicCamera camera;

    public MapaCasa(){
        this.orthogonalTiledMapRenderer = MapaLeitor.getInstance().lerMapa(Mapas.CASA, MyCamera.ESCALA);
        this.camera = MyCamera.getInstance().getCamera();

        this.orthogonalTiledMapRenderer.setView(this.camera);

        mapaCasa = this;
    }

    public static MapaCasa getInstance() {
        return mapaCasa;
    }

    @Override
    public void meDesenhar() {
        this.orthogonalTiledMapRenderer.setView(this.camera);
        this.orthogonalTiledMapRenderer.render();
    }

    public OrthogonalTiledMapRenderer getOrthogonalTiledMapRenderer() {
        return orthogonalTiledMapRenderer;
    }
}
