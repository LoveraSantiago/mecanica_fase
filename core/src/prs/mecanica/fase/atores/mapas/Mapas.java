package prs.mecanica.fase.atores.mapas;

public enum Mapas {

    CASA("casamapa2.tmx");

    private String nomeArquivo;

    private Mapas(String nomeArquivo){
        this.nomeArquivo = nomeArquivo;
    }

    public String getNomeArquivo() {
        return "semnome/mapas/" + nomeArquivo;
    }
}
