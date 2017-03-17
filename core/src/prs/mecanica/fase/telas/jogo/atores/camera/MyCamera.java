package prs.mecanica.fase.telas.jogo.atores.camera;

import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.math.Vector3;
import com.badlogic.gdx.utils.viewport.StretchViewport;
import com.badlogic.gdx.utils.viewport.Viewport;

import prs.mecanica.fase.telas.jogo.comuns.contratos.geral.InformacaoJogador;
import prs.mecanica.fase.telas.jogo.comuns.contratos.usuario.ViewPortUser;
import prs.mecanica.fase.telas.jogo.comuns.contratos.tipo.TipoAtualizavel;

public class MyCamera implements ViewPortUser, TipoAtualizavel<InformacaoJogador>{

    public static final float ESCALA = 1f / 10f;
    public static final int LARGURA_TELA = 30;
    public static final int HALTURA_TELA = 20;

    private static final MyCamera myCamera;
    private final OrthographicCamera camera;

    private final Viewport viewport;
    private final MovimentadorCamera movimentador;

    static{
        myCamera = new MyCamera();
    }

    private MyCamera(){
        this.camera = new OrthographicCamera();
        this.viewport = new StretchViewport(LARGURA_TELA, HALTURA_TELA, this.camera);
        this.viewport.apply();

        this.camera.position.set(this.camera.viewportWidth / 2f, this.camera.viewportHeight / 2f, 0);
        this.camera.update();

        this.movimentador = new MovimentadorCamera(this.camera);
    }

    public static MyCamera getInstance() {
        return myCamera;
    }

    @Override
    public void resize(int width, int heigth){
        this.viewport.update(width, heigth);
        this.viewport.apply();
        this.camera.update();

        this.movimentador.setLimitesCamera();
    }

//    @Override
//    public void atualizar() {
//        this.camera.update();
//    }

//    private Vector3 diferenca = new Vector3();
//    private float ptYMaior;
//    private float ptYMenor;
//    private float ptXmenor;
//    private float ptXMaior;
//
//    float result;
    @Override
    public void atualizar(InformacaoJogador jogador){
//        this.ptYMaior = -1f;
//        this.ptXMaior = -1f;
//        this.ptXmenor = 100f;
//        this.ptYMenor = 100f;
//
//        for(int i = 0; i < this.camera.frustum.planePoints.length; i++){
//            this.ptYMaior = Math.max(this.ptYMaior, this.camera.frustum.planePoints[i].y);
//            this.ptYMenor = Math.min(this.ptYMenor, this.camera.frustum.planePoints[i].y);
//            this.ptXMaior = Math.max(this.ptXMaior, this.camera.frustum.planePoints[i].x);
//            this.ptXmenor = Math.min(this.ptXmenor, this.camera.frustum.planePoints[i].x);
//        }
//        System.out.println("x jogador: " + (jogador.getPosX() + jogador.getLargura()) + " limiteCamera: " + ptXMaior);
//
//        if(!this.camera.frustum.pointInFrustum(jogador.getPosX(), jogador.getPosY(), 0) ||
//                !this.camera.frustum.pointInFrustum(jogador.getPosX() + jogador.getLargura(), jogador.getPosY() + jogador.getHaltura(), 0)){
//
////            this.ptYMaior = -1f;
////            this.ptXMaior = -1f;
////            this.ptXmenor = 100f;
////            this.ptYMenor = 100f;
////
////            for(int i = 0; i < this.camera.frustum.planePoints.length; i++){
////                this.ptYMaior = Math.max(this.ptYMaior, this.camera.frustum.planePoints[i].y);
////                this.ptYMenor = Math.min(this.ptYMenor, this.camera.frustum.planePoints[i].y);
////                this.ptXMaior = Math.max(this.ptXMaior, this.camera.frustum.planePoints[i].x);
////                this.ptXmenor = Math.min(this.ptXmenor, this.camera.frustum.planePoints[i].x);
////            }
//
////            System.out.println("x jogador: " + jogador.getPosX() + " limiteCamera: " + ptXMaior);
//            if(jogador.getPosX() < ptXmenor){
//                this.camera.translate(jogador.getPosX() - ptXmenor, 0, 0);
//            }
//            else if((jogador.getPosX() + jogador.getLargura()) > ptXMaior){
//                System.out.println("entramos");
//                this.camera.translate((jogador.getPosX() + jogador.getLargura()) - ptXMaior, 0, 0);
//            }
//
//            if(jogador.getPosY() < ptYMenor){
//                this.camera.translate(0, jogador.getPosY() - ptYMenor, 0);
//            }
//            else if((jogador.getPosY()  + jogador.getHaltura()) > ptYMaior){
//                this.camera.translate(0, (jogador.getPosY()  + jogador.getHaltura()) - ptYMaior, 0);
//            }
//        }
        this.movimentador.atualizar(jogador);
        this.camera.update();
    }

    public OrthographicCamera getCamera() {
        return camera;
    }
}
