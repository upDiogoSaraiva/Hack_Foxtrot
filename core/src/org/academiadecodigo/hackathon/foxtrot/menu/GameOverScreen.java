package org.academiadecodigo.hackathon.foxtrot.menu;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.*;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.badlogic.gdx.utils.viewport.FitViewport;
import com.badlogic.gdx.utils.viewport.Viewport;

public class GameOverScreen implements MenuScreen {

    private InnerMenus innerMenus;
    private SpriteBatch batch;
    private Stage stage;
    private Skin skin;
    private TextureAtlas atlas;
    private Texture image;
    private SpriteBatch pictureBatch;
    private SpriteBatch fontbatch;
    private BitmapFont font;
    private Texture texture;

    public GameOverScreen(InnerMenus innerMenus) {
        this.innerMenus = innerMenus;
        init();
    }

    @Override
    public void init() {

        batch = new SpriteBatch();
        fontbatch = new SpriteBatch();
        atlas = new TextureAtlas("uiskin.atlas");
        skin = new Skin(Gdx.files.internal("uiskin.json"));
        Camera camera = new OrthographicCamera();
        Viewport viewport = new FitViewport(Gdx.graphics.getWidth(),
                Gdx.graphics.getHeight(), camera);
        viewport.apply(true);

        stage = new Stage(viewport, batch);
        show();
    }

    @Override
    public void show() {

        font = new BitmapFont(Gdx.files.internal("arial.fnt"));
        fontbatch.begin();

        texture = new Texture(Gdx.files.internal("arial.png"));

        TextureRegion bg = new TextureRegion(texture, 500,500);


        fontbatch.draw(texture, 500,500);
        font.setColor(Color.WHITE);
        fontbatch.end();



        Gdx.input.setInputProcessor(stage);
        TextButton menu = new TextButton("PlayBack", skin);

        image = new Texture(Gdx.files.internal("GameOver.png"));
        batch = new SpriteBatch();

        Table table = new Table(skin);

        table.setFillParent(true);

        table.padBottom(-400);
        table.add(menu);
        table.row().pad(10);

        stage.addActor(table);

        menu.addListener(new ClickListener() {
            @Override
            public void clicked(InputEvent event, float x, float y) {
                innerMenus.setScreen(ScreenTypes.MENU);
            }
        });
        
    }

    @Override
    public void render(float delta) {
        Gdx.gl.glClearColor(.1f, .12f, .16f, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        batch.begin();
        batch.draw(image, 0, 0);
        batch.end();
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

        font.dispose();

    }
}
