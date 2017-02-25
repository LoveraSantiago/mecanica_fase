package prs.mecanica.fase.atores.jogador;

public enum Imagens {

    PERSONAGEM_CIMA("pcima"),
    PERSONAGEM_BAIXO("pbaixo"),
    PERSONAGEM_ESQ("pesquerda"),
    PERSONAGEM_DIR("pdireita");

    private String nomeArquivo;

    private Imagens(String nomeArquivo){
        this.nomeArquivo = nomeArquivo;
    }

    public String getNomeArquivo() {
        return nomeArquivo;
    }
}
