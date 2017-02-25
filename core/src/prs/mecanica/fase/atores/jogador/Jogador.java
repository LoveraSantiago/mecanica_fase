package prs.mecanica.fase.atores.jogador;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.InputProcessor;
import com.badlogic.gdx.graphics.g2d.Sprite;

import prs.mecanica.fase.comuns.ImgLeitor;
import prs.mecanica.fase.comuns.MySpriteBatch;
import prs.mecanica.fase.comuns.contratos.TipoControlavel;
import prs.mecanica.fase.comuns.contratos.TipoDesenhavel;
import prs.mecanica.fase.debugagem.Debugagem;

public class Jogador implements TipoDesenhavel, TipoControlavel, ControleJogador{

    private float xAtual;
    private float yAtual;

    private final MySpriteBatch mySpriteBatch;

    private Sprite spriteAtual;
    private final Sprite spriteCima;
    private final Sprite spriteBaixo;
    private final Sprite spriteEsq;
    private final Sprite spriteDir;

    private final InputProcessor controle;

    private Movimentador movimentadorAtual;
    private final Movimentador movimentadorAcao;
    private final Movimentador movimentadorParado;

    public Jogador() {
        ImgLeitor imgLeitor = ImgLeitor.getInstance();
        this.spriteCima = imgLeitor.getImg (Imagens.PERSONAGEM_CIMA);
        this.spriteBaixo = imgLeitor.getImg(Imagens.PERSONAGEM_BAIXO);
        this.spriteDir = imgLeitor.getImg  (Imagens.PERSONAGEM_DIR);
        this.spriteEsq = imgLeitor.getImg  (Imagens.PERSONAGEM_ESQ);
        this.spriteAtual = this.spriteCima;

        this.mySpriteBatch = MySpriteBatch.getInstance();

        this.controle = new JogadorListener(this);

        this.movimentadorAcao = new MovimentarAcao();
        this.movimentadorParado = new MovimentarParado();
        this.movimentadorAtual = this.movimentadorParado;

        this.xAtual = this.spriteAtual.getX();
        this.yAtual = this.spriteAtual.getY();
    }


    @Override
    public void meDesenhar() {
        this.movimentadorAtual.movimentar();
        Debugagem.Posicao.dbgXY("pos sprite", this.xAtual, this.yAtual);
        this.mySpriteBatch.desenharSprite(this.spriteAtual);
    }

    @Override
    public void movimentarJogador(int keyCode) {
        this.movimentadorAtual = movimentadorAcao;

        switch (keyCode){
            case Input.Keys.UP:
                this.spriteAtual = this.spriteCima;
                break;
            case Input.Keys.DOWN:
                this.spriteAtual = this.spriteBaixo;
                break;
            case Input.Keys.LEFT:
                this.spriteAtual = this.spriteEsq;
                break;
            case Input.Keys.RIGHT:
                this.spriteAtual = this.spriteDir;
                break;
        }
    }

    @Override
    public void pararMovimentacao() {
        this.movimentadorAtual = movimentadorParado;
    }

    @Override
    public InputProcessor getControle() {
        return this.controle;
    }

    private interface Movimentador{
        public void movimentar();
    }

    private class MovimentarAcao implements Movimentador{

        @Override
        public void movimentar() {
            if(spriteAtual == spriteCima){
                yAtual += (150 * Gdx.graphics.getDeltaTime());
            }
            else if(spriteAtual == spriteBaixo){
                yAtual -= (150 * Gdx.graphics.getDeltaTime());
            }
            else if(spriteAtual == spriteDir){
                xAtual += (150 * Gdx.graphics.getDeltaTime());
            }
            else if(spriteAtual == spriteEsq){
                xAtual -= (150 * Gdx.graphics.getDeltaTime());
            }
            spriteAtual.setPosition(xAtual, yAtual);
        }
    }

    private class MovimentarParado implements Movimentador{

        @Override
        public void movimentar() {

        }
    }
}
