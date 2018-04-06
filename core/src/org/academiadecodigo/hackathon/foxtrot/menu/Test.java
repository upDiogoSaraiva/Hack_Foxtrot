package org.academiadecodigo.hackathon.foxtrot.menu;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class Test extends ApplicationAdapter{

    SpriteBatch batch;
    BitmapFont font;
    String myText;

    @Override
    public void create() {
        batch = new SpriteBatch();
        font = new BitmapFont(Gdx.files.internal("arial.fnt"));
        myText = "HELLO DDFFF";
    }

    @Override
    public void render() {
        Gdx.gl.glClearColor(0,0,0,1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        batch.begin();
        font.draw(batch, myText, Gdx.graphics.getWidth() /2, Gdx.graphics.getHeight() / 2);
        batch.end();
    }
}
