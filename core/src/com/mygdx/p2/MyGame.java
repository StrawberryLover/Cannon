package com.mygdx.p2;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.mygdx.p2.entity.Text;
import com.mygdx.p2.events.MyInputProcessor;
import com.mygdx.p2.screens.GameScreen;
import com.mygdx.p2.screens.MenuScreen;
import com.mygdx.p2.screens.OptionScreen;

public class MyGame extends Game {
    private MenuScreen mainMenuScreen;

    private Text fps;

    public GameScreen main;
    public OptionScreen opt;

    @Override
    public void create() {
        mainMenuScreen = new MenuScreen(this);

        // Set Main Screens
        main = new GameScreen(this);

        // Set Option Screen
        opt = new OptionScreen(this);

        setScreen(mainMenuScreen);
    }

    public MenuScreen getMenu() {
        return mainMenuScreen;
    }

    /**
     * Setups back button and fps display
     * @param stage elements are added to the stage
     */
    public void setupBasicScreen(Stage stage) {
        float width = Gdx.graphics.getWidth();
        float height = Gdx.graphics.getHeight();

        // Set FPS display
        fps = new Text("fps: 0", width - 60, height - 10);
        stage.addActor(fps);

        // Set Input Processor
        Gdx.input.setInputProcessor(new MyInputProcessor());
    }

    /**
     * Draw stage and update fps display
     * @param stage viewport
     * @param batch screen batch
     */
    public void renderBasicScreen(Stage stage, SpriteBatch batch){
        fps.setText("fps:" + Gdx.graphics.getFramesPerSecond());

        batch.begin();
            stage.draw();
        batch.end();
    }
}
