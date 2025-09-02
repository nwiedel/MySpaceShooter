package de.nicolas.baseclasses;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.Logger;

public abstract class GameBase extends Game {

    private AssetManager assetManager;
    private SpriteBatch batch;

    public GameBase(){}

    @Override
    public void create() {
        Gdx.app.setLogLevel(Logger.DEBUG);

        assetManager = new AssetManager();
        assetManager.getLogger().setLevel(Logger.DEBUG);

        batch = new SpriteBatch();

        postCreate();
    }

    public abstract void postCreate();

    @Override
    public void dispose() {
        super.dispose();
        assetManager.dispose();
        batch.dispose();
    }

    public AssetManager getAssetManager() {
        return assetManager;
    }

    public SpriteBatch getBatch() {
        return batch;
    }
}
