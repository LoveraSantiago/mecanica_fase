package prs.mecanica.fase.comuns;

import com.badlogic.gdx.maps.tiled.TiledMap;
import com.badlogic.gdx.maps.tiled.TiledMapRenderer;
import com.badlogic.gdx.maps.tiled.TmxMapLoader;
import com.badlogic.gdx.maps.tiled.renderers.OrthogonalTiledMapRenderer;
import com.badlogic.gdx.utils.Disposable;

import prs.mecanica.fase.atores.mapas.Mapas;

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

    public TiledMapRenderer lerMapa(Mapas mapa, float escala){
        this.map = new TmxMapLoader().load(mapa.getNomeArquivo());
        return new OrthogonalTiledMapRenderer(map, escala);
    }

    @Override
    public void dispose() {
        this.map.dispose();
    }
}
