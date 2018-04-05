package org.academiadecodigo.hackathon.foxtrot;

import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import org.academiadecodigo.hackathon.foxtrot.entities.Entity;
import org.academiadecodigo.hackathon.foxtrot.entities.Player;

import java.util.ArrayList;
import java.util.List;

public abstract class GameMap {

    private static final float GRAVITY = -9.8f;
    private Player player;

    protected List<Entity> entities;

    public GameMap() {

        this.entities = new ArrayList<Entity>();
        player = new Player(40, 600, this);
        entities.add(player);
    }



    public void render(OrthographicCamera camera, SpriteBatch batch) {

        for (Entity entity : entities) {
            entity.render(batch);
        }
    }

    public void update(float delta) {

        for (Entity entity : entities) {
            entity.update(delta, GRAVITY);
        }
    }

    public abstract void dispose();

    public abstract TileType getTileTypeByCoordinate(int layer, int col, int row);

    public boolean doesRectCollideWithMap(float x, float y, int width, int height) {

        if (x < 0 || y < 0 || x + width > getPixelWidth() || y + height > getPixelHeight()) {
            return true;
        }

        for (int row = (int) (y / TileType.TILE_SIZE); row < Math.ceil((y + height) / TileType.TILE_SIZE); row++) {
            for (int col = (int) (x / TileType.TILE_SIZE); col < Math.ceil((x + width) / TileType.TILE_SIZE); col++) {
                for (int layer = 0; layer < getLayers(); layer++) {

                    TileType type = getTileTypeByCoordinate(layer, col, row);

                    if (type != null && type.isCollidable()) {
                        return true;
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

    public Player getPlayer() {
        return player;
    }
}
