package prs.mecanica.fase;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;

import prs.mecanica.fase.telas.jogo.atores.controle.Controle;
import prs.mecanica.fase.global.ControleManager;
import prs.mecanica.fase.telas.jogo.atores.jogador.Jogador;
import prs.mecanica.fase.telas.jogo.atores.mapas.MapaCasa;
import prs.mecanica.fase.telas.jogo.comuns.imagens.ImgLeitor;
import prs.mecanica.fase.telas.jogo.comuns.imagens.MapaLeitor;
import prs.mecanica.fase.telas.jogo.comuns.MyCamera;
import prs.mecanica.fase.global.SpriteBatchManager;

public class MecanicaFaseMain extends ApplicationAdapter {

	private MyCamera myCamera;
	private SpriteBatchManager spriteBatchManager;

	private MapaCasa mapaCasa;
	private Jogador jogador;
	private Controle controle;



	@Override
	public void create() {
		this.myCamera = MyCamera.getInstance();
		this.spriteBatchManager = SpriteBatchManager.getInstance();

		this.mapaCasa = new MapaCasa();
		this.controle = new Controle();
		this.jogador = new Jogador();
	}

	@Override
	public void render() {
		Gdx.gl.glClearColor(1, 0, 0, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

		this.myCamera.atualizar();
		this.spriteBatchManager.atualizar();

		this.mapaCasa.meDesenhar();
		this.jogador.meDesenhar();
		this.controle.meDesenhar();
	}

	@Override
	public void resize(int width, int height) {
		this.myCamera.resize(width, height);
	}

	@Override
	public void dispose() {
		this.spriteBatchManager.dispose();
		MapaLeitor.getInstance().dispose();
		ImgLeitor.getInstance().dispose();
		this.controle.dispose();
	}
}
