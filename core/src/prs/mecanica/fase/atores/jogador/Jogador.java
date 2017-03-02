package prs.mecanica.fase.atores.jogador;

import com.badlogic.gdx.InputProcessor;
import com.badlogic.gdx.graphics.g2d.Sprite;

import prs.mecanica.fase.atores.entidades.direcao.Direcoes;
import prs.mecanica.fase.comuns.MyCamera;
import prs.mecanica.fase.comuns.MySpriteBatch;
import prs.mecanica.fase.comuns.contratos.TipoControlavel;
import prs.mecanica.fase.comuns.contratos.TipoDesenhavel;

import static prs.mecanica.fase.atores.entidades.direcao.Direcoes.CIMA;

public class Jogador implements TipoDesenhavel, TipoControlavel, ControleJogador{

    private final MySpriteBatch mySpriteBatch;
    private final SpriteManager spriteManager;

    private Direcoes direcaoAtual;
    private Sprite spriteAtual;
    private final PosJog posJog;

    private final InputProcessor controle;

    private final Movimentador movimentador;

    public Jogador() {
        this.spriteManager = new SpriteManager();
        this.spriteAtual = this.spriteManager.getSprite(CIMA);
        this.posJog = new PosJog();

        this.mySpriteBatch = MySpriteBatch.getInstance();

        this.movimentador = new Movimentador(this.spriteManager);
        this.controle = new JogadorListener(this);
    }

    @Override
    public void meDesenhar() {
        this.movimentador.movimentar(this.spriteAtual, this.direcaoAtual);
        this.mySpriteBatch.desenharSprite  (this.spriteAtual);
    }

    @Override
    public void iniciarMovimentacaoTecla(Direcoes direcao) {
        this.direcaoAtual = direcao;
        this.movimentador.configurarTecla();
        this.spriteAtual = this.spriteManager.getSprite(direcao);
    }

    @Override
    public void iniciarMovimentacaoToque(Direcoes direcao, float limite) {
        this.direcaoAtual = direcao;
        this.movimentador.configurarToque(limite);
        this.spriteAtual = this.spriteManager.getSprite(direcao);
    }

    @Override
    public void pararMovimentacao() {
        this.movimentador.configurarParado();
    }

    @Override
    public PosJog getPosicaoJogador() {
        this.posJog.setXYWH(this.spriteAtual.getX(), this.spriteAtual.getY(), this.spriteAtual.getWidth() * MyCamera.ESCALA, this.spriteAtual.getHeight() * MyCamera.ESCALA);
        return this.posJog;
    }

    @Override
    public InputProcessor getControle() {
        return this.controle;
    }
}
