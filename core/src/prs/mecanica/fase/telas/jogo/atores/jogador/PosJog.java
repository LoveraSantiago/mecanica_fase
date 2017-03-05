package prs.mecanica.fase.telas.jogo.atores.jogador;

public class PosJog {

    private float x;
    private float y;
    private float w;
    private float h;

    public float getX() {
        return x;
    }

    public float getY() {
        return y;
    }

    public float getH() {
        return h;
    }

    public float getW() {
        return w;
    }

    public void setX(float x) {
        this.x = x;
    }

    public void setY(float y) {
        this.y = y;
    }

    public void setW(float w) {
        this.w = w;
    }

    public void setH(float h) {
        this.h = h;
    }

    public void setXYWH(float x, float y, float w, float h){
        setX(x);
        setY(y);
        setW(w);
        setH(h);
    }
}
