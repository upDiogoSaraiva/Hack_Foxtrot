package org.academiadecodigo.hackathon.foxtrot.menu;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.*;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.badlogic.gdx.utils.viewport.FitViewport;
import com.badlogic.gdx.utils.viewport.Viewport;
import org.academiadecodigo.hackathon.foxtrot.Game;

public class InstructionScreen implements MenuScreen {

    private InnerMenus innerMenus;
    private SpriteBatch batch;
    private Stage stage;
    private Skin skin;
    private TextureAtlas atlas;
    private Texture image;

    public InstructionScreen(InnerMenus innerMenus) {
        this.innerMenus = innerMenus;
        image = new Texture("player.png");
    }

    @Override
    public void init() {
        batch = new SpriteBatch();
        atlas = new TextureAtlas("uiskin.atlas");
        skin = new Skin(Gdx.files.internal("uiskin.json"));
        Camera camera = new OrthographicCamera();
        Viewport viewport = new FitViewport(Gdx.graphics.getWidth(),
                Gdx.graphics.getHeight(), camera);
        viewport.apply(true);

        stage = new Stage(viewport, batch);
        System.out.println("here 2");
        show();
    }

    @Override
    public void show() {
        Gdx.input.setInputProcessor(stage);
        TextButton menu = new TextButton("Menu", skin);
        TextButton exitButton = new TextButton("Exit", skin);


       // texture = new Texture(pixmap);
        Table table = new Table(skin);

        table.setFillParent(true);

        table.center();
        table.add(menu);
        table.row().pad(10);
        table.add(exitButton);
        table.row().pad(10);

        table.add(exitButton);

        stage.addActor(table);


        menu.addListener(new ClickListener() {
            @Override
            public void clicked(InputEvent event, float x, float y) {
                innerMenus.setScreen(ScreenTypes.MENU);
            }
        });

        exitButton.addListener(new ClickListener() {
            @Override
            public void clicked(InputEvent event, float x, float y) {
                Gdx.app.exit();
            }
        });

    }

    @Override
    public void render(float delta) {
        Gdx.gl.glClearColor(.1f, .12f, .16f, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        stage.act(delta);
        stage.draw();

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
