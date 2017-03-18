package prs.mecanica.fase.telas.jogo.atores.jogador;

import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Rectangle;

import prs.mecanica.fase.global.SpriteBatchManager;
import prs.mecanica.fase.telas.jogo.atores.entidades.DirecaoEstado;
import prs.mecanica.fase.telas.jogo.atores.entidades.Direcoes;
import prs.mecanica.fase.telas.jogo.comuns.contratos.geral.ControleJogador;
import prs.mecanica.fase.telas.jogo.comuns.contratos.geral.InformacaoJogador;
import prs.mecanica.fase.telas.jogo.comuns.contratos.tipo.TipoDesenhavel;

public class Jogador implements TipoDesenhavel, ControleJogador, InformacaoJogador {

    private final SpriteBatch spriteBatch;
    private final SpriteManager spriteManager;

    private Direcoes direcaoAtual;
    private Sprite spriteAtual;

    private final Movimentador movimentador;
    private final Rectangle areaJogador;

    public Jogador() {
        this.spriteManager = new SpriteManager();

        this.direcaoAtual = Direcoes.CIMA;
        this.spriteAtual = this.spriteManager.getSprite(this.direcaoAtual);

        this.spriteBatch = SpriteBatchManager.getInstance().getSpriteBatch();

        this.movimentador = new Movimentador();
        this.movimentador.movimentar(this.spriteAtual, this.direcaoAtual);

        this.areaJogador = new Rectangle();
    }

    @Override
    public void meDesenhar() {
        this.movimentador.movimentar(this.spriteAtual, this.direcaoAtual);
        this.spriteBatch.begin();
        this.spriteAtual.draw(this.spriteBatch);
        this.spriteBatch.end();
    }

    @Override
    public void iniciarMov(Direcoes direcao, DirecaoEstado direcaoEstado) {
        this.direcaoAtual = direcao;
        this.spriteAtual = this.spriteManager.getSprite(direcao);
        this.movimentador.setAcaoAtual(direcaoEstado);
    }

    @Override
    public float getHaltura() {
        return this.spriteManager.getHeigth();
    }

    @Override
    public float getLargura(){
        return this.spriteManager.getWidth();
    }

    @Override
    public float getPosX() {
        return this.movimentador.getPosX();
    }

    @Override
    public float getPosY(){
        return this.movimentador.getPosY();
    }

    @Override
    public Rectangle getBounds() {
        return this.areaJogador.set(getPosX(), getPosY(), getLargura(), getHaltura());
    }
}
