package prs.mecanica.fase.telas.jogo.atores.jogador;

import com.badlogic.gdx.InputProcessor;
import com.badlogic.gdx.graphics.g2d.Sprite;

import prs.mecanica.fase.global.Configuracao;
import prs.mecanica.fase.global.ControleManager;
import prs.mecanica.fase.telas.jogo.atores.controle.Controle;
import prs.mecanica.fase.telas.jogo.comuns.MyCamera;
import prs.mecanica.fase.global.SpriteBatchManager;
import prs.mecanica.fase.telas.jogo.comuns.contratos.tipo.TipoControlavel;
import prs.mecanica.fase.telas.jogo.atores.entidades.Direcoes;
import prs.mecanica.fase.telas.jogo.comuns.contratos.tipo.TipoDesenhavel;

public class Jogador implements TipoDesenhavel, TipoControlavel, prs.mecanica.fase.telas.jogo.comuns.contratos.geral.ControleJogador {

    private final SpriteBatchManager spriteBatchManager;
    private final SpriteManager spriteManager;

    private Direcoes direcaoAtual;
    private Sprite spriteAtual;
    private final PosJog posJog;

    private final InputProcessor controle;

    private final Movimentador movimentador;

    public Jogador() {
        this.spriteManager = new SpriteManager();
        this.spriteAtual = this.spriteManager.getSprite(Direcoes.CIMA);
        this.posJog = new PosJog();

        this.spriteBatchManager = SpriteBatchManager.getInstance();

        this.movimentador = new Movimentador(this.spriteManager);


        //TODO arrumar essa bagunca
        if(Configuracao.getInstance().isMobile()){
            Controle.getInstance().registrarControleJogador(this);
            this.controle = Controle.getInstance().getControle();
        }
        else{
            this.controle = new JogadorListener(this);
        }

        ControleManager controleManager = ControleManager.getInstance();
        controleManager.adicionarControlavel(this);
    }

    @Override
    public void meDesenhar() {
        this.movimentador.movimentar(this.spriteAtual, this.direcaoAtual);
        this.spriteBatchManager.desenharSprite  (this.spriteAtual);
    }

    @Override
    public void initMovTecla(Direcoes direcao) {
        this.direcaoAtual = direcao;
        this.movimentador.configurarTecla();
        this.spriteAtual = this.spriteManager.getSprite(direcao);
    }

    @Override
    public void initMovToque(Direcoes direcao, float limite) {
        this.direcaoAtual = direcao;
        this.movimentador.configurarToque(limite);
        this.spriteAtual = this.spriteManager.getSprite(direcao);
    }

    @Override
    public void pararMov() {
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
