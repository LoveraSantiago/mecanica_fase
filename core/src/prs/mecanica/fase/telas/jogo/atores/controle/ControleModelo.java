package prs.mecanica.fase.telas.jogo.atores.controle;

import com.badlogic.gdx.InputAdapter;
import com.badlogic.gdx.InputProcessor;
import com.badlogic.gdx.utils.Disposable;

import prs.mecanica.fase.telas.jogo.comuns.contratos.tipo.TipoControlavel;
import prs.mecanica.fase.telas.jogo.comuns.contratos.tipo.TipoDesenhavel;
import prs.mecanica.fase.telas.jogo.comuns.contratos.usuario.ViewPortUser;

public abstract class ControleModelo extends InputAdapter
        implements TipoDesenhavel, ViewPortUser, TipoControlavel, Disposable{

    @Override
    public void meDesenhar() {
    }

    @Override
    public void resize(int width, int height) {
    }

    @Override
    public void dispose() {
    }

    @Override
    public InputProcessor getControle() {
        return null;
    }
}
