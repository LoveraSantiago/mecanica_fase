package prs.mecanica.fase.telas.jogo.atores.mapas;

import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.maps.tiled.renderers.OrthogonalTiledMapRenderer;

import prs.mecanica.fase.telas.jogo.comuns.contratos.tipo.TipoDesenhavel;
import prs.mecanica.fase.telas.jogo.comuns.imagens.MapaLeitor;
import prs.mecanica.fase.telas.jogo.atores.camera.MyCamera;

public class MapaRenderer implements TipoDesenhavel {

    private static MapaRenderer mapaRenderer;

    private OrthogonalTiledMapRenderer orthogonalTiledMapRenderer;
    private OrthographicCamera camera;

    public MapaRenderer(Mapas mapa){
        this.orthogonalTiledMapRenderer = MapaLeitor.getInstance().lerMapa(mapa, MyCamera.ESCALA);
        this.camera = MyCamera.getInstance().getCamera();

        this.orthogonalTiledMapRenderer.setView(this.camera);

        mapaRenderer = this;
    }

    public static MapaRenderer getInstance() {
        return mapaRenderer;
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
