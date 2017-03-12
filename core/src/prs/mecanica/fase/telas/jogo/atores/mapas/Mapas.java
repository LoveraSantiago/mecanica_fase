package prs.mecanica.fase.telas.jogo.atores.mapas;

public enum Mapas {

    CASA("casamapa2.tmx"),
    SHOPPING("mapa_shopping.tmx");

    private String nomeArquivo;

    private Mapas(String nomeArquivo){
        this.nomeArquivo = nomeArquivo;
    }

    public String getNomeArquivo() {
        return "mapas/" + nomeArquivo;
    }
}
