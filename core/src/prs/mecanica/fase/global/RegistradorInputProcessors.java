package prs.mecanica.fase.global;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.InputMultiplexer;

import prs.mecanica.fase.telas.jogo.comuns.contratos.tipo.TipoControlavel;

public class RegistradorInputProcessors {

    private static final RegistradorInputProcessors REGISTRADOR_INPUT_PROCESSORS;

    private final InputMultiplexer inputMultiplexer;

    static{
        REGISTRADOR_INPUT_PROCESSORS = new RegistradorInputProcessors();
    }

    private RegistradorInputProcessors(){
        this.inputMultiplexer = new InputMultiplexer();
        Gdx.input.setInputProcessor(this.inputMultiplexer);
    }

    public static RegistradorInputProcessors getInstance() {
        return REGISTRADOR_INPUT_PROCESSORS;
    }

    public void adicionarControlavel(TipoControlavel controlavel){
        this.inputMultiplexer.addProcessor(controlavel.getControle());
    }
}
