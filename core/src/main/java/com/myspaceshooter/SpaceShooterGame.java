package com.myspaceshooter;

import com.badlogic.gdx.ApplicationAdapter;
import com.myspaceshooter.screens.game.GameScreen;
import de.nicolas.baseclasses.GameBase;

public class SpaceShooterGame extends GameBase {

    public SpaceShooterGame(){

    }

    @Override
    public void postCreate() {
        setScreen(new GameScreen(this));
    }
}
