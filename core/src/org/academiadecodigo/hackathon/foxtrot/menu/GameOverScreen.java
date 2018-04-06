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
import org.academiadecodigo.hackathon.foxtrot.TiledGameMap;
import sun.jvm.hotspot.utilities.BitMap;

public class GameOverScreen implements MenuScreen {

    private InnerMenus innerMenus;
    private SpriteBatch batch;
    private Stage stage;
    private Skin skin;
    private TextureAtlas atlas;
    private Texture image;

    private SpriteBatch textBatch;
    private BitmapFont font;
    private String myText;

    public GameOverScreen(InnerMenus innerMenus) {
        this.innerMenus = innerMenus;
        init();
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
        show();
    }

    @Override
    public void show() {

        Gdx.input.setInputProcessor(stage);
        TextButton menu = new TextButton("PlayBack", skin);

        textBatch = new SpriteBatch();
        font = new BitmapFont(Gdx.files.internal("arial.fnt"));
        int points = TiledGameMap.score;

        myText = Integer.toString(points);

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
        Gdx.gl.glClearColor(0, 0, 0, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);


        batch.begin();
        batch.draw(image, 0, 0);
        batch.end();

        textBatch.begin();
        font.draw(textBatch, myText, Gdx.graphics.getWidth() /2 - 25, Gdx.graphics.getHeight() / 2 - 120);
        textBatch.end();

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
