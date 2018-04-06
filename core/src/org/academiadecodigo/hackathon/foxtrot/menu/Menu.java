package org.academiadecodigo.hackathon.foxtrot.menu;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Camera;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.badlogic.gdx.utils.viewport.FillViewport;
import com.badlogic.gdx.utils.viewport.Viewport;
import org.academiadecodigo.hackathon.foxtrot.Game;

public class Menu implements MenuScreen {

    private SpriteBatch batch;
    private Stage stage;
    private Skin skin;
    private TextureAtlas atlas;

    private SpriteBatch pictureBatch;
    private Texture image;

    private Game game;

    private InnerMenus innerMenus;

    public Menu(InnerMenus innerMenus) {
        this.innerMenus = innerMenus;
    }

    public void init() {
        batch = new SpriteBatch();
        game = new Game(innerMenus);
        atlas = new TextureAtlas("uiskin.atlas");
        skin = new Skin(Gdx.files.internal("uiskin.json"));
        Camera camera = new OrthographicCamera();
        Viewport viewport = new FillViewport(Gdx.graphics.getWidth(),
                Gdx.graphics.getHeight(), camera);
        viewport.apply(true);

        stage = new Stage(viewport, batch);

    }

    @Override
    public void show() {
        Gdx.input.setInputProcessor(stage);

        pictureBatch = new SpriteBatch();
        image = new Texture(Gdx.files.internal("cover.png"));

        final TextButton startGame = new TextButton("Start Game", skin);
        TextButton instructionsButton = new TextButton("Instructions", skin);
        TextButton exitButton = new TextButton("Exit", skin);



        startGame.addListener(new ClickListener() {
            @Override
            public void clicked(InputEvent event, float x, float y) {
                innerMenus.setScreen(ScreenTypes.GAME);
                game.show();



            }
        });

        instructionsButton.addListener(new ClickListener() {
            @Override
            public void clicked(InputEvent event, float x, float y) {

                innerMenus.setScreen(ScreenTypes.INSTRUCTION);
            }
        });

        exitButton.addListener(new ClickListener() {
            @Override
            public void clicked(InputEvent event, float x, float y) {
                Gdx.app.exit();
            }
        });



        Table table = new Table(skin);

        table.setFillParent(true);

        table.center();
        table.add(startGame);
        table.row().pad(10);
        table.add(instructionsButton);
        table.row().pad(10);

        table.add(exitButton);

        stage.addActor(table);

    }

    @Override
    public void render(float delta) {
        Gdx.gl.glClearColor(.1f, .12f, .16f, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        pictureBatch.begin();
        pictureBatch.draw(image, 0, 0);
        pictureBatch.end();

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
        stage.dispose();
        batch.dispose();
        skin.dispose();
        atlas.dispose();
    }

}
