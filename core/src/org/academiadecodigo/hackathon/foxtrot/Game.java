package org.academiadecodigo.hackathon.foxtrot;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import org.academiadecodigo.hackathon.foxtrot.menu.InnerMenus;
import org.academiadecodigo.hackathon.foxtrot.menu.MenuScreen;
import org.academiadecodigo.hackathon.foxtrot.menu.ScreenTypes;

public class Game implements MenuScreen {

    private OrthographicCamera camera;
    private SpriteBatch batch;

    private GameMap gameMap;
    private InnerMenus innerMenus;

    private Music music;

    public Game(InnerMenus innerMenus) {
        this.innerMenus = innerMenus;
    }

    @Override
    public void show() {


        batch = new SpriteBatch();

        float w = Gdx.graphics.getWidth();
        float h = Gdx.graphics.getHeight();

        camera = new OrthographicCamera();
        camera.setToOrtho(false, w, h);
        camera.update();
        gameMap = new TiledGameMap(innerMenus);

        if (music == null) {
            music = Gdx.audio.newMusic(Gdx.files.internal("bestGameEver.wav"));
            music.play();
        }
    }

    @Override
    public void render(float delta) {

        Gdx.gl.glClearColor(0, 0, 0, 1);
        Gdx.gl.glBlendFunc(GL20.GL_SRC_ALPHA, GL20.GL_ONE_MINUS_SRC_ALPHA);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        camera.update();
        gameMap.update(Gdx.graphics.getDeltaTime());
        gameMap.render(camera, batch);

        if (gameMap.endGame()) {

            music.stop();
            innerMenus.setScreen(ScreenTypes.GAMEOVER);
        }
    }

    @Override
    public void dispose() {

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
    public void init() {

    }

}
