package org.academiadecodigo.hackathon.foxtrot.entities;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import org.academiadecodigo.hackathon.foxtrot.GameMap;
import org.academiadecodigo.hackathon.foxtrot.TileType;

public class Player extends Entity {

    //if translate (2,0) 120 is the same speed as the map
    private static final int SPEED = 190;
    private static final int JUMP_VELOCITY = 5;
    private boolean canMove = true;

    private Texture image;

    public Player(float x, float y, GameMap map) {
        super(x, y, EntityType.PLAYER, map);
        image = new Texture("player.png");
    }

    @Override
    public void update(float deltaTime, float gravity) {

        verifyDeath();

        jumps(deltaTime);

        super.update(deltaTime, gravity);

        move(deltaTime);
    }

    public void verifyDeath() {

        if (map.getTileTypeByLocation(1, pos.x, pos.y).equals(TileType.LAVA)) {
            isDead = true;
        }
    }

    private void jumps(float deltaTime) {

        if (Gdx.input.isKeyPressed(Input.Keys.SPACE) && grounded) {
            this.velocityY += JUMP_VELOCITY * getWeight();

        } else if (Gdx.input.isKeyPressed(Input.Keys.SPACE) && !grounded && velocityY > 0) {
            this.velocityY += JUMP_VELOCITY * getWeight() * deltaTime;
        }
    }

    @Override
    protected void move(float deltaTime) {
        if (canMove) {
            if (Gdx.input.isKeyPressed(Input.Keys.LEFT)) {
                moveX(-SPEED * deltaTime);
            }

            if (Gdx.input.isKeyPressed(Input.Keys.RIGHT)) {
                moveX(SPEED * deltaTime);
            }
        }
    }



    @Override
    public void render(SpriteBatch batch) {
        batch.draw(image, pos.x, pos.y, getWidth(), getHeight());
    }

    public void setCanMove(boolean canMove) {
        this.canMove = canMove;
    }
}


