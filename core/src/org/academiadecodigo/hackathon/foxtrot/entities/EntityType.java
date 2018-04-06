package org.academiadecodigo.hackathon.foxtrot.entities;

public enum EntityType {

    PLAYER("player", 31, 64, 40),
    COFFIN("coffin", 31, 64, 40);

    private String id;
    private int width;
    private int height;
    private float weight;

    EntityType(String id, int width, int height, float weight) {

        this.id = id;
        this.width = width;
        this.height = height;
        this.weight = weight;
    }

    public String getId() {
        return id;
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

    public float getWeight() {
        return weight;
    }
}
