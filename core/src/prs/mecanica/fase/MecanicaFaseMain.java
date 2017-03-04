package prs.mecanica.fase;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;

import prs.mecanica.fase.atores.entidades.controle.Controle;
import prs.mecanica.fase.atores.entidades.controle.ControleManager;
import prs.mecanica.fase.atores.jogador.Jogador;
import prs.mecanica.fase.atores.mapas.MapaCasa;
import prs.mecanica.fase.comuns.imagens.ImgLeitor;
import prs.mecanica.fase.comuns.imagens.MapaLeitor;
import prs.mecanica.fase.comuns.MyCamera;
import prs.mecanica.fase.comuns.MySpriteBatch;

public class MecanicaFaseMain extends ApplicationAdapter {

	private MyCamera myCamera;
	private MySpriteBatch mySpriteBatch;

	private MapaCasa mapaCasa;
	private Jogador jogador;
	private Controle controle;

	@Override
	public void create() {
		this.myCamera = MyCamera.getInstance();
		this.mySpriteBatch = MySpriteBatch.getInstance();

		this.mapaCasa = new MapaCasa();
		this.jogador = new Jogador();
		this.controle = new Controle();

        ControleManager controleManager = ControleManager.getInstance();
        controleManager.adicionarControlavel(this.jogador);
        controleManager.adicionarControlavel(this.controle);
	}

	@Override
	public void render() {
		Gdx.gl.glClearColor(1, 0, 0, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

		this.myCamera.atualizar();
		this.mySpriteBatch.atualizar();

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
		this.mySpriteBatch.dispose();
		MapaLeitor.getInstance().dispose();
		ImgLeitor.getInstance().dispose();
		this.controle.dispose();
	}
}
