package org.academiadecodigo.hackathon.foxtrot.desktop;

import com.badlogic.gdx.ApplicationListener;
import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;
import org.academiadecodigo.hackathon.foxtrot.Game;
import org.academiadecodigo.hackathon.foxtrot.menu.InnerMenus;
import org.academiadecodigo.hackathon.foxtrot.menu.Menu;

public class DesktopLauncher {
	public static void main (String[] arg) {
		LwjglApplicationConfiguration config = new LwjglApplicationConfiguration();
		config.useGL30 = false;
		config.width = 1000;
		config.height = 700;
		config.resizable = false;

		new LwjglApplication(new InnerMenus(config), config);
		//new LwjglApplication(new Game(), config);

	}
}
