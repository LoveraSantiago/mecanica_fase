package prs.mecanica.fase.telas.jogo.atores.camera;

import com.badlogic.gdx.graphics.OrthographicCamera;

class CalculadorLimitesCamera {

    private float ptYMaior;
    private float ptYMenor;
    private float ptXmenor;
    private float ptXMaior;

    public void calcularLimites(OrthographicCamera camera){
        resetPontos();
        for(int i = 0; i < camera.frustum.planePoints.length; i++){
            this.ptYMaior = Math.max(this.ptYMaior, camera.frustum.planePoints[i].y);
            this.ptYMenor = Math.min(this.ptYMenor, camera.frustum.planePoints[i].y);
            this.ptXMaior = Math.max(this.ptXMaior, camera.frustum.planePoints[i].x);
            this.ptXmenor = Math.min(this.ptXmenor, camera.frustum.planePoints[i].x);
        }
    }

    private void resetPontos(){
        this.ptYMaior = -1f;
        this.ptXMaior = -1f;
        this.ptXmenor = 100f;
        this.ptYMenor = 100f;
    }

    public float getPtXMaior() {
        return ptXMaior;
    }

    public float getPtXmenor() {
        return ptXmenor;
    }

    public float getPtYMaior() {
        return ptYMaior;
    }

    public float getPtYMenor() {
        return ptYMenor;
    }
}
