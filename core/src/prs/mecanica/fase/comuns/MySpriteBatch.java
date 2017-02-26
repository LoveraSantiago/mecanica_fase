package prs.mecanica.fase.comuns;

import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.Disposable;

public class MySpriteBatch implements Disposable{

    private static final MySpriteBatch mySpriteBatch;

    private final SpriteBatch spriteBatch;

    static{
        mySpriteBatch = new MySpriteBatch();
    }

    private MySpriteBatch(){
        this.spriteBatch = new SpriteBatch();
    }

    public static MySpriteBatch getInstance() {
        return mySpriteBatch;
    }

    public SpriteBatch getSpriteBatch(){
        return this.spriteBatch;
    }

    @Override
    public void dispose() {
        this.spriteBatch.dispose();
    }

    public void desenharSprite(Sprite sprite){
        this.spriteBatch.begin();
        sprite.draw(this.spriteBatch);
        this.spriteBatch.end();
    }
}