package prs.mecanica.fase.atores.jogador;

import com.badlogic.gdx.InputProcessor;
import com.badlogic.gdx.graphics.g2d.Sprite;

import prs.mecanica.fase.comuns.MyCamera;
import prs.mecanica.fase.comuns.MySpriteBatch;
import prs.mecanica.fase.comuns.contratos.TipoControlavel;
import prs.mecanica.fase.comuns.contratos.TipoDesenhavel;

public class Jogador implements TipoDesenhavel, TipoControlavel, ControleJogador{

    private final MySpriteBatch mySpriteBatch;
    private final SpriteManager spriteManager;

    private Sprite spriteAtual;
    private final PosJog posJog;

    private final InputProcessor controle;

    private final MovimentadorManager movimentadorManager;

    public Jogador() {
        this.spriteManager = new SpriteManager();
        this.spriteAtual = this.spriteManager.getSprite(666);

        this.mySpriteBatch = MySpriteBatch.getInstance();

        this.posJog = new PosJog();

        this.movimentadorManager = new MovimentadorManager(this.spriteManager);
        this.controle = new JogadorListener(this);
    }

    @Override
    public void meDesenhar() {
        this.movimentadorManager.movimentar(this.spriteAtual);
        this.mySpriteBatch.desenharSprite  (this.spriteAtual);
    }

    @Override
    public void iniciarMovimentacaoTecla(int keyCode) {
        this.movimentadorManager.configurarTecla();
        this.spriteAtual = this.spriteManager.getSprite(keyCode);
    }

    @Override
    public void iniciarMovimentacaoToque(int keyCode, float limite) {
        this.movimentadorManager.configurarToque(limite);
        this.spriteAtual = this.spriteManager.getSprite(keyCode);
    }

    @Override
    public void pararMovimentacao() {
        this.movimentadorManager.configurarParado();
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
