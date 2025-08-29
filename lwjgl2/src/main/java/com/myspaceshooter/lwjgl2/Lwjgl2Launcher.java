package com.myspaceshooter.lwjgl2;

import com.badlogic.gdx.Files.FileType;
import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;
import com.myspaceshooter.SpaceShooterGame;
import com.myspaceshooter.configuration.GameConfig;

/** Launches the desktop (LWJGL2) application. */
public class Lwjgl2Launcher {
    public static void main(String[] args) {
        createApplication();
    }

    private static LwjglApplication createApplication() {
        return new LwjglApplication(new SpaceShooterGame(), getDefaultConfiguration());
    }

    private static LwjglApplicationConfiguration getDefaultConfiguration() {
        LwjglApplicationConfiguration configuration = new LwjglApplicationConfiguration();
        configuration.title = "Space Shooter Prototype";
        configuration.width = (int)GameConfig.WIDTH;
        configuration.height = (int) GameConfig.HEIGHT;
        //// This prevents a confusing error that would appear after exiting normally.
        configuration.forceExit = false;

        configuration.addIcon("icon.png", FileType.Internal);

        /*for (int size : new int[] { 128, 64, 32, 16 }) {
            configuration.addIcon("libgdx" + size + ".png", FileType.Internal);
        }*/
        return configuration;
    }
}
