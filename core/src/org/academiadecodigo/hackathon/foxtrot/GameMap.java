package org.academiadecodigo.hackathon.foxtrot;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import org.academiadecodigo.hackathon.foxtrot.TileType;
import org.academiadecodigo.hackathon.foxtrot.entities.Coffin;
import org.academiadecodigo.hackathon.foxtrot.entities.Entity;
import org.academiadecodigo.hackathon.foxtrot.entities.EntityType;
import org.academiadecodigo.hackathon.foxtrot.entities.Player;
import org.academiadecodigo.hackathon.foxtrot.menu.InnerMenus;
import org.academiadecodigo.hackathon.foxtrot.menu.Menu;
import org.academiadecodigo.hackathon.foxtrot.menu.MenuScreen;
import org.academiadecodigo.hackathon.foxtrot.menu.ScreenTypes;

import java.rmi.MarshalException;
import java.util.ArrayList;
import java.util.List;

public abstract class GameMap {

    private static final float GRAVITY = -9.8f;
    private Player player;
    private Coffin coffin;

    private InnerMenus innerMenus;


    protected List<Entity> entities;

    public GameMap(InnerMenus innerMenus) {
        this.innerMenus=innerMenus;


        this.entities = new ArrayList<Entity>();
        coffin = new Coffin(0, 600, this);
        entities.add(coffin);

        player = new Player(80, 600, this);
        entities.add(player);


    }

    public void render(OrthographicCamera camera, SpriteBatch batch) {

        entities.get(0).setY(entities.get(1).getY());

        for (Entity entity : entities) {
            entity.render(batch);
        }
    }

    public void update(float delta) {

        for (Entity entity : entities) {
            entity.update(delta, GRAVITY);
        }
    }

    public void endGame() {

        player = (Player) entities.get(1);


        if (player.getType().equals(EntityType.PLAYER)) {

            if ((player.getX() <= entities.get(0).getX()) || player.isDead()) {
                innerMenus.setScreen(ScreenTypes.MENU);
            }
        }
    }

    public TileType getTileTypeByLocation(int layer, float x, float y) {
        return getTileTypeByCoordinate(layer, (int) (x / TileType.TILE_SIZE), (int) (y / TileType.TILE_SIZE));
    }


    public abstract TileType getTileTypeByCoordinate(int layer, int col, int row);

    public boolean doesRectCollideWithMap(float x, float y, int width, int height, boolean isCoffin) {

        if (x < 0 || y < 0 || x + width > getPixelWidth() || y + height > getPixelHeight()) {
            return true;
        }

        for (int row = (int) (y / TileType.TILE_SIZE); row < Math.ceil((y + height) / TileType.TILE_SIZE); row++) {
            for (int col = (int) (x / TileType.TILE_SIZE); col < Math.ceil((x + width) / TileType.TILE_SIZE); col++) {
                for (int layer = 0; layer < getLayers(); layer++) {

                    TileType type = getTileTypeByCoordinate(layer, col, row);

                    if (type != null && type.isCollidable()) {
                        return !isCoffin;
                    }
                }
            }
        }

        return false;
    }

    public abstract int getWidth();

    public abstract int getHeight();

    public abstract int getLayers();

    public int getPixelWidth() {
        return this.getWidth() * TileType.TILE_SIZE;
    }

    public int getPixelHeight() {
        return this.getHeight() * TileType.TILE_SIZE;

    }

    public Coffin getCoffin() {
        return coffin;
    }

    public Player getPlayer() {
        return player;
    }
}
