package com.myspaceshooter.screens.game;

import com.badlogic.gdx.Screen;
import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.utils.ScreenUtils;
import com.myspaceshooter.SpaceShooterGame;

public class GameScreen implements Screen {

    private final SpaceShooterGame game;

    private AssetManager assetManager;

    public GameScreen(SpaceShooterGame game){
        this.game = game;
        assetManager = game.getAssetManager();
    }

    @Override
    public void show() {

    }

    @Override
    public void render(float v) {

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

    }
}
