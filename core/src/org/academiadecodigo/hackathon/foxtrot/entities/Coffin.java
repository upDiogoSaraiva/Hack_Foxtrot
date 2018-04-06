package org.academiadecodigo.hackathon.foxtrot.entities;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import org.academiadecodigo.hackathon.foxtrot.GameMap;

public class Coffin extends Entity {

    private static final int SPEED = 120;

    private Texture image;

    public Coffin(float x, float y, GameMap map) {

        super(x, y, EntityType.COFFIN, map);
        image = new Texture("coffin.png");
    }

    @Override
    public void render(SpriteBatch batch) {
        batch.draw(image, pos.x, pos.y, getWidth(), getHeight());
    }

    @Override
    public void update(float deltaTime, float gravity) {

        move(deltaTime);
        super.update(deltaTime, gravity);
    }

    @Override
    protected void move(float deltaTime) {

        moveX(SPEED * deltaTime);
    }


}
