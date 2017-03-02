package prs.mecanica.fase.utils.debugagem;

import com.badlogic.gdx.graphics.Camera;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.math.Vector3;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.utils.StringBuilder;

public class Debugagem {

    private final static StringBuilder stringBuilder = new StringBuilder();

    public static class CameraD {

        private final static Vector3 vector3 = new Vector3();
        private static int contador;

        public static void completo(Camera camera){
            posicao(camera);
            frustrum(camera);
        }

        public static void posicao(Camera camera){
            Debugagem.Posicao.vetor3("Camera pos", camera.position);
        }

        public static void frustrum(Camera camera){
            stringBuilder.setLength(0);
            stringBuilder.append("Camera Frustrum" + "\n");
            for(contador = 0; contador < camera.frustum.planePoints.length; contador++){
                vector3.set(camera.frustum.planePoints[contador]);
                stringBuilder.append("x: " + vector3.x + ", " + "y: " + vector3.y + "; \n");
            }
            stringBuilder.append("*********\n");
            System.out.println(stringBuilder);
        }
    }

    public static class Posicao{

        public static void vetor3(String texto, Vector3 p){
            System.out.println(texto + " x:" + p.x + " y:" + p.y);
        }

        public static void vetor2(String texto, Vector2 p){
            xy(texto, p.x, p.y);
        }

        public static void xy(String texto, float x, float y){
            System.out.println(texto + " x:" + x + " y:" + y);
        }
    }

    public static class Texturas{

        public static void sprite(String texto, Sprite sprite){
            stringBuilder.setLength(0);
            stringBuilder.append("Sprite " + texto + "\n");
            stringBuilder.append("pt origem x:" + sprite.getOriginX() + " y:" + sprite.getOriginY() + "\n");
            stringBuilder.append("width:" + sprite.getWidth() + ", height:" + sprite.getHeight() + "\n");
            stringBuilder.append("*********\n");
            System.out.println(stringBuilder);
        }
    }

    public static class Toque{

        public static void pinch(Vector2 i1, Vector2 i2, Vector2 p1, Vector2 p2){
            System.out.println("i1 x:" + i1.x + " y:" + i1.y);
            System.out.println("i2 x:" + i2.x + " y:" + i2.y);

            System.out.println("p1 x:" + p1.x + " y:" + p1.y);
            System.out.println("p2 x:" + p2.x + " y:" + p2.y);
        }

        public static void pan(float x, float y, float deltaX, float deltaY){
            panComum("Pan", x, y, deltaX, deltaY);
        }

        public static void panStop(float x, float y, float deltaX, float deltaY){
            panComum("PanStop", x, y, deltaX, deltaY);
        }

        private static void panComum(String texto, float x, float y, float deltaX, float deltaY){
            System.out.println(texto + " x:" + x + " y: " + y + " deltaX:" + deltaX + " deltaY:" + deltaY);
        }

        public static void touchDragged(int x, int y, int pt){
            System.out.println("TouchDragged x:" + x + " y:" + y + " pt:" + pt);
        }

        public static void touchDown(float x, float y, int pt, int btn){
            touchComum("TouchDown", x, y, pt, btn);
        }

        public static void touchUp(float x, float y, float pt, float btn){
            touchComum("TouchUp", x, y, pt, btn);
        }

        private static void touchComum(String texto, float x, float y, float pt, float btn){
            System.out.println(texto + " x:" + x + " y:" + y + " pt:" + pt + " btn:" + btn);
        }
    }

    private static ShapeRenderer shapeRenderer = new ShapeRenderer();

    public static void dbgAtor_Posicao(String nomeAtor, Actor ator){
        System.out.println(nomeAtor + " origemX: " + ator.getOriginX());
        System.out.println(nomeAtor + " origemY: " + ator.getOriginY());
        System.out.println(nomeAtor + " X: " + ator.getX());
        System.out.println(nomeAtor + " Y: " + ator.getY());
    }

//    public static void dbgEquacaoDaReta(TipoEquacao eq, float entrada){
//        System.out.println("Equacao Reta: " + eq + " f(" + entrada + ") x=" + eq.getX(entrada) + " y=" + eq.getY(entrada));
//    }

    public static void desenharPontoNaTela(Color cor, float x, float y){
        shapeRenderer.begin(ShapeRenderer.ShapeType.Filled);
        shapeRenderer.setColor(cor);
        shapeRenderer.circle(x, y, 50);
        shapeRenderer.end();
    }

    public static void desenharPontoNaTela(Color cor, Vector2 posicao, boolean printDbg){
        desenharPontoNaTela(cor, posicao.x, posicao.y);

//        if(printDbg) dbgPontoVector2("Ponto desenhado posicao", posicao);
    }

    public static void desenharPontoNaTela(Color cor, Vector3 posicao, boolean printDbg){
        desenharPontoNaTela(cor, posicao.x, posicao.y);
//        if(printDbg)dbgPontoVector3("Ponto desenhado posicao", posicao);
    }
}