package prs.mecanica.fase.comuns.imagens;

public enum Imagens {

    PERSONAGEM_CIMA ("pcima"),
    PERSONAGEM_BAIXO("pbaixo"),
    PERSONAGEM_ESQ  ("pesquerda"),
    PERSONAGEM_DIR  ("pdireita"),

    BTN_DIR_U    ("btn_direita_u"),
    BTN_ESQ_U    ("btn_esquerda_u"),
    BTN_CIMA_U   ("btn_cima_u"),
    BTN_BAIXO_U  ("btn_baixo_u"),
    BTN_DIR_SUP_U("btn_direitasuperior_u"),
    BTN_DIR_INF_U("btn_direitainferior_u"),
    BTN_ESQ_SUP_U("btn_esquerdasuperior_u"),
    BTN_ESQ_INF_U("btn_esquerdainferior_u"),

    BTN_DIR_D    ("btn_direita_d"),
    BTN_ESQ_D    ("btn_esquerda_d"),
    BTN_CIMA_D   ("btn_cima_d"),
    BTN_BAIXO_D  ("btn_baixo_d"),
    BTN_DIR_SUP_D("btn_direitasuperior_d"),
    BTN_DIR_INF_D("btn_direitainferior_d"),
    BTN_ESQ_SUP_D("btn_esquerdasuperior_d"),
    BTN_ESQ_INF_D("btn_esquerdainferior_d");

    private String nomeArquivo;

    private Imagens(String nomeArquivo){
        this.nomeArquivo = nomeArquivo;
    }

    public String getNomeArquivo() {
        return nomeArquivo;
    }
}
