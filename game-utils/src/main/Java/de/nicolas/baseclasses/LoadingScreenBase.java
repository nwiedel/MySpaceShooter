package de.nicolas.baseclasses;

import com.badlogic.gdx.ScreenAdapter;
import com.badlogic.gdx.assets.AssetDescriptor;
import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.utils.Array;
import com.badlogic.gdx.utils.ScreenUtils;
import com.badlogic.gdx.utils.viewport.FitViewport;
import com.badlogic.gdx.utils.viewport.Viewport;
import de.nicolas.GdxUtilities;

public abstract class LoadingScreenBase extends ScreenAdapter {

    // -- Konstanten --
    private static final float DEFAULT_HUD_WIDTH = 640;
    private static final float DEFAULT_HUD_HEIGHT = 480;
    private static final float DEFAULT_PROGRESS_BAR_HEIGHT = 60f;

    // -- Attribute --
    protected final GameBase game;
    protected final AssetManager assetManager;

    private OrthographicCamera camera;
    private Viewport viewport;
    private ShapeRenderer renderer;

    private float progress;
    private float waitTime = 0.75f;

    private float progressBarWidth;
    private float progressBarHeight;

    private float hudWidth;
    private float hudHeight;

    private boolean changeScreen;

    // -- Konstruktor --
    protected LoadingScreenBase(GameBase game) {
        this.game = game;
        assetManager = game.getAssetManager();
    }

    // -- abstrakte Methoden --
    protected abstract Array<AssetDescriptor> getAssetDescriptors();

    protected abstract void onLoadDone();

    // -- öffentliche Methoden --
    @Override
    public void show() {
        hudWidth = getHudWidth();
        hudHeight = getHudHeight();

        progressBarWidth = getProgressBarWidth();
        progressBarHeight = getProgressBarHeight();

        camera = new OrthographicCamera();
        viewport = new FitViewport(hudWidth, hudHeight, camera);
        renderer = new ShapeRenderer();


        for (AssetDescriptor descriptor : getAssetDescriptors()) {
            assetManager.load(descriptor);
        }
    }

    @Override
    public void render(float delta) {
        update(delta);

        ScreenUtils.clear(GdxUtilities.CORNFLOWER_BLUE);
        viewport.apply();
        renderer.setProjectionMatrix(camera.combined);
        renderer.begin(ShapeRenderer.ShapeType.Filled);

        draw();

        renderer.end();

        if (changeScreen) {
            onLoadDone();
        }
    }

    @Override
    public void resize(int width, int height) {
        viewport.update(width, height, true);
    }

    @Override
    public void hide() {
        dispose();
    }

    @Override
    public void dispose() {
        renderer.dispose();
    }

    // == protected methods ==
    protected float getHudWidth() {
        return DEFAULT_HUD_WIDTH;
    }

    protected float getHudHeight() {
        return DEFAULT_HUD_HEIGHT;
    }

    protected float getProgressBarWidth() {
        return getHudWidth() / 2f;
    }

    protected float getProgressBarHeight() {
        return DEFAULT_PROGRESS_BAR_HEIGHT;
    }

    // == private methods ==
    private void update(float delta) {
        progress = assetManager.getProgress();

        if (assetManager.update()) {
            waitTime -= delta;

            if (waitTime <= 0f) {
                changeScreen = true;
            }
        }
    }

    private void draw() {
        float progressBarX = (hudWidth - progressBarWidth) / 2f;
        float progressBarY = (hudHeight - progressBarHeight) / 2f;

        renderer.rect(progressBarX, progressBarY,
            progress * progressBarWidth, progressBarHeight);
    }
}
