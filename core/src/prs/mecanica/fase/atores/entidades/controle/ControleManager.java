package prs.mecanica.fase.atores.entidades.controle;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.InputMultiplexer;

import prs.mecanica.fase.comuns.contratos.tipo.TipoControlavel;

public class ControleManager {

    private static final ControleManager controleManager;

    private final InputMultiplexer inputMultiplexer;

    static{
        controleManager = new ControleManager();
    }

    private ControleManager(){
        this.inputMultiplexer = new InputMultiplexer();
        Gdx.input.setInputProcessor(this.inputMultiplexer);
    }

    public static ControleManager getInstance() {
        return controleManager;
    }

    public void adicionarControlavel(TipoControlavel controlavel){
        this.inputMultiplexer.addProcessor(controlavel.getControle());
    }
}
