package prs.mecanica.fase.telas.jogo.atores.entidades;

public enum DirecaoEstado {

    PARADO(0),
    ANDANDO(5),
    CORRENDO(10f);

    private float velocidade;

    private DirecaoEstado(float velocidade){
        this.velocidade = velocidade;
    }

    public float getVelocidade() {
        return velocidade;
    }
}
