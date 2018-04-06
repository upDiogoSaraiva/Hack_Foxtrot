package org.academiadecodigo.hackathon.foxtrot.menu;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class GameOverScreen implements MenuScreen {

    private SpriteBatch batch;
    private Texture image;

    private InnerMenus innerMenus;

    public GameOverScreen(InnerMenus innerMenus) {
        this.innerMenus = innerMenus;
    }

    @Override
    public void init() {

        show();
    }

    @Override
    public void show() {

        batch = new SpriteBatch();
        image = new Texture(Gdx.files.internal("GameOver.png"));

        batch.begin();
        batch.draw(image, 0, 0);
        batch.end();

        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        innerMenus.setScreen(ScreenTypes.MENU);
    }

    @Override
    public void render(float delta) {


    }

    @Override
    public void resize(int width, int height) {

    }

    @Override
    public void pause() {

    }

    @Override
    public void resume() {

    }

    @Override
    public void hide() {

    }

    @Override
    public void dispose() {

    }
}
