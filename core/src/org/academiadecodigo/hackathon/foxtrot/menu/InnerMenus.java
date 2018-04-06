package org.academiadecodigo.hackathon.foxtrot.menu;


import com.badlogic.gdx.Game;

import java.util.HashMap;
import java.util.Map;

public class InnerMenus extends Game {

    private Map<ScreenTypes, MenuScreen> screenMap;

    @Override
    public void create() {

        screenMap = new HashMap<ScreenTypes, MenuScreen>();
        MenuScreen screen = new Menu(this);
        MenuScreen screen2 = new InstructionScreen(this);

        screen.init();
        screen2.init();

        screenMap.put(ScreenTypes.MENU,screen);
        screenMap.put(ScreenTypes.INSTRUCTION,screen2);
        super.setScreen(screen);
    }

    @Override
    public void render() {
        super.render();

    }

    @Override
    public void dispose() {
        for (MenuScreen menuScreen : screenMap.values()) {
            menuScreen.dispose();
        }
    }

    public void setScreen(ScreenTypes screen) {
        super.setScreen(screenMap.get(screen));
    }
}
