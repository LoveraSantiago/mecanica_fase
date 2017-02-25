package prs.mecanica.fase;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

import prs.mecanica.fase.atores.jogador.Jogador;
import prs.mecanica.fase.atores.mapas.MapaCasa;
import prs.mecanica.fase.comuns.ImgLeitor;
import prs.mecanica.fase.comuns.MapaLeitor;
import prs.mecanica.fase.comuns.MyCamera;
import prs.mecanica.fase.comuns.MySpriteBatch;

public class MecanicaFaseMain extends ApplicationAdapter {
	private MyCamera myCamera;

	private MapaCasa mapaCasa;
	private Jogador jogador;

	@Override
	public void create() {
		this.myCamera = MyCamera.getInstance();
		MySpriteBatch.getInstance();//Força o early instantiation do MySpriteBatch

		this.mapaCasa = new MapaCasa();

		this.jogador = new Jogador();
		Gdx.input.setInputProcessor(this.jogador.getControle());
	}

	@Override
	public void render() {
		Gdx.gl.glClearColor(1, 0, 0, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		myCamera.update();
		this.mapaCasa.meDesenhar();
		this.jogador.meDesenhar();
	}

	@Override
	public void resize(int width, int height) {
		this.myCamera.resize(width, height);
	}

	@Override
	public void dispose() {
		MySpriteBatch.getInstance().dispose();
		MapaLeitor.getInstance().dispose();
		ImgLeitor.getInstance().dispose();
	}
}
