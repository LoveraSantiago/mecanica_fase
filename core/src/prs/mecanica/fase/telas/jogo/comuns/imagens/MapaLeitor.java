package prs.mecanica.fase.telas.jogo.comuns.imagens;

import com.badlogic.gdx.maps.tiled.TiledMap;
import com.badlogic.gdx.maps.tiled.TmxMapLoader;
import com.badlogic.gdx.maps.tiled.renderers.OrthogonalTiledMapRenderer;
import com.badlogic.gdx.utils.Disposable;

public class MapaLeitor implements Disposable{

    private static final MapaLeitor MAPA_LEITOR;

    private TiledMap map;

    static{
        MAPA_LEITOR = new MapaLeitor();
    }

    private MapaLeitor(){
    }

    public static MapaLeitor getInstance() {
        return MAPA_LEITOR;
    }

    public OrthogonalTiledMapRenderer lerMapa(prs.mecanica.fase.telas.jogo.atores.mapas.Mapas mapa, float escala){
        this.map = new TmxMapLoader().load(mapa.getNomeArquivo());
        return new OrthogonalTiledMapRenderer(map, escala);
    }

    @Override
    public void dispose() {
        this.map.dispose();
    }
}
