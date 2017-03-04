package prs.mecanica.fase.comuns.imagens;

public enum Imagens {

    PERSONAGEM_CIMA ("pcima"),
    PERSONAGEM_BAIXO("pbaixo"),
    PERSONAGEM_ESQ  ("pesquerda"),
    PERSONAGEM_DIR  ("pdireita"),

    BTN_DIR    ("btn_direita"),
    BTN_ESQ    ("btn_esquerda"),
    BTN_CIMA   ("btn_cima"),
    BTN_BAIXO  ("btn_baixo"),
    BTN_DIR_SUP("btn_direitasuperior"),
    BTN_DIR_INF("btn_direitainferior"),
    BTN_ESQ_SUP("btn_esquerdasuperior"),
    BTN_ESQ_INF("btn_esquerdainferior");

    private String nomeArquivo;

    private Imagens(String nomeArquivo){
        this.nomeArquivo = nomeArquivo;
    }

    public String getNomeArquivo() {
        return nomeArquivo;
    }
}
