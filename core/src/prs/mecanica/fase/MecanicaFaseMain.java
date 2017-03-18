package prs.mecanica.fase;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;

import prs.mecanica.fase.telas.jogo.atores.controle.ControleManager;
import prs.mecanica.fase.telas.jogo.atores.jogador.Jogador;
import prs.mecanica.fase.telas.jogo.atores.mapas.MapaRenderer;
import prs.mecanica.fase.telas.jogo.atores.mapas.Mapas;
import prs.mecanica.fase.telas.jogo.comuns.imagens.ImgLeitor;
import prs.mecanica.fase.telas.jogo.comuns.imagens.MapaLeitor;
import prs.mecanica.fase.telas.jogo.atores.camera.MyCamera;
import prs.mecanica.fase.global.SpriteBatchManager;

public class MecanicaFaseMain extends ApplicationAdapter {

	private MyCamera myCamera;
	private SpriteBatchManager spriteBatchManager;

	private MapaRenderer mapaRenderer;
	private Jogador jogador;
	private ControleManager controleManager;

	@Override
	public void create() {
		this.myCamera = MyCamera.getInstance();
		this.spriteBatchManager = SpriteBatchManager.getInstance();

		this.mapaRenderer = new MapaRenderer(Mapas.SHOPPING);
		this.jogador = new Jogador();

		this.controleManager = ControleManager.getInstance();
		this.controleManager.definirControle(this.jogador);
	}

	@Override
	public void render() {
		Gdx.gl.glClearColor(255, 255, 255, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        this.jogador.atualizar(null);

		this.myCamera.atualizar(this.jogador);
		this.spriteBatchManager.atualizar(this.myCamera.getCamera());

//		this.mapaRenderer.meDesenhar();
		this.jogador.meDesenhar();
		this.controleManager.meDesenhar();
	}

	@Override
	public void resize(int width, int height) {
		this.myCamera.resize(width, height);
		this.controleManager.resize(width, height);
	}

	@Override
	public void dispose() {
		this.spriteBatchManager.dispose();
		MapaLeitor.getInstance().dispose();
		ImgLeitor.getInstance().dispose();
		this.controleManager.dispose();
	}
}
