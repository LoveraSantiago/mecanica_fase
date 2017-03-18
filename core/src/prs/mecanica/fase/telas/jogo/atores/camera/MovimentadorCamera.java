package prs.mecanica.fase.telas.jogo.atores.camera;

import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.math.Rectangle;

import prs.mecanica.fase.telas.jogo.comuns.contratos.geral.InformacaoJogador;
import prs.mecanica.fase.telas.jogo.comuns.contratos.tipo.TipoAtualizavel;

class MovimentadorCamera implements TipoAtualizavel<InformacaoJogador>{

    private final OrthographicCamera camera;
    private final Rectangle miniArea;

    private final CalculadorLimitesCamera calculador;

    public MovimentadorCamera(OrthographicCamera camera) {
        this.camera = camera;

        this.miniArea = new Rectangle();
        this.calculador = new CalculadorLimitesCamera();
        setLimitesCamera();
    }

    @Override
    public void atualizar(InformacaoJogador jogador) {
        if(!this.miniArea.contains(jogador.getBounds())){
            setLimitesCamera();
            System.out.println("diferenca x:" + (jogador.getPosX() - this.miniArea.getX()));
            if(jogador.getPosX() < this.miniArea.getX()){
                this.camera.translate(jogador.getPosX() - this.miniArea.getX(), 0, 0);
            }
            else if((jogador.getPosX() + jogador.getLargura()) > (this.miniArea.getX() + this.miniArea.getWidth())){
                this.camera.translate((jogador.getPosX() + jogador.getLargura()) - (this.miniArea.getX() + this.miniArea.getWidth()), 0, 0);
            }

            if(jogador.getPosY() < this.miniArea.getY()){
                this.camera.translate(0, jogador.getPosY() - this.miniArea.getY(), 0);
            }
            else if((jogador.getPosY()  + jogador.getHaltura()) > (this.miniArea.getY() + this.miniArea.getHeight())){
                this.camera.translate(0, (jogador.getPosY()  + jogador.getHaltura()) - (this.miniArea.getY() + this.miniArea.getHeight()), 0);
            }
        }
    }

    public void setLimitesCamera(){
        this.calculador.calcularLimites(this.camera);
        this.miniArea.set(this.calculador.getPtXmenor() + 5, this.calculador.getPtYMenor() + 3, MyCamera.LARGURA_TELA - 10, MyCamera.HALTURA_TELA - 6);
    }
}
