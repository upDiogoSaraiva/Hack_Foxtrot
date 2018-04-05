package org.academiadecodigo.hackathon.foxtrot;

import java.util.HashMap;
import java.util.Map;

public enum TileType {

    GRASS(1, true, "Grass", false),
    DIRT(2, true, "Dirt", false),
    SKY(3, false, "Sky", false),
    LAVA(4, false, "Lava", true),
    CLOUD(5, true, "Cloud", false),
    STONE(6, true, "Stone", false);

    public static final int TILE_SIZE = 16;

    private int id;
    private boolean collidable;
    private String name;
    private boolean damage;
    private static Map<Integer, TileType> tileMap;

    TileType(int id, boolean collidable, String name, boolean damage) {

        this.id = id;
        this.collidable = collidable;
        this.name = name;
        this.damage = damage;
    }

    public int getId() {
        return id;
    }

    public boolean isCollidable() {
        return collidable;
    }

    public boolean getDamage() {
        return damage;
    }

    static {

        tileMap = new HashMap<Integer, TileType>();

        for (TileType tileType : TileType.values()) {
            tileMap.put(tileType.getId(), tileType);
        }
    }

    public static TileType getTileTypeById(int id) {
        return tileMap.get(id);
    }
}
