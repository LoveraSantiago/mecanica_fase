package prs.mecanica.fase.telas.jogo.atores.controle.desktop;

import com.badlogic.gdx.utils.TimeUtils;

class TapKeyboard {

    private long contador;
    private final long limite;

    public TapKeyboard(long limite) {
        this.limite = limite;
    }

    public void iniciar(){
        this.contador = TimeUtils.millis();
    }

    public boolean isTap(){
        return TimeUtils.millis() - this.contador < limite;
    }
}
