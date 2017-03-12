package prs.mecanica.fase.telas.jogo.atores.jogador;

import com.badlogic.gdx.graphics.g2d.Sprite;

import prs.mecanica.fase.global.SpriteBatchManager;
import prs.mecanica.fase.telas.jogo.atores.entidades.DirecaoEstado;
import prs.mecanica.fase.telas.jogo.atores.entidades.Direcoes;
import prs.mecanica.fase.telas.jogo.comuns.contratos.geral.ControleJogador;
import prs.mecanica.fase.telas.jogo.comuns.contratos.tipo.TipoDesenhavel;

public class Jogador implements TipoDesenhavel, ControleJogador {

    private final SpriteBatchManager spriteBatchManager;
    private final SpriteManager spriteManager;

    private Direcoes direcaoAtual;
    private Sprite spriteAtual;

    private final Movimentador movimentador;

    public Jogador() {
        this.spriteManager = new SpriteManager();

        this.direcaoAtual = Direcoes.CIMA;
        this.spriteAtual = this.spriteManager.getSprite(this.direcaoAtual);

        this.spriteBatchManager = SpriteBatchManager.getInstance();

        this.movimentador = new Movimentador(this.spriteManager);
    }

    @Override
    public void meDesenhar() {
        this.movimentador.movimentar(this.spriteAtual, this.direcaoAtual);
        this.spriteBatchManager.desenharSprite  (this.spriteAtual);
    }

    @Override
    public void iniciarMov(Direcoes direcao, DirecaoEstado direcaoEstado) {
        this.direcaoAtual = direcao;
        this.spriteAtual = this.spriteManager.getSprite(direcao);
        this.movimentador.setAcaoAtual(direcaoEstado);
    }
}
