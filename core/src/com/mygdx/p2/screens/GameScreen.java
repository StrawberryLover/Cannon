package com.mygdx.p2.screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.mygdx.p2.MyGame;
import com.mygdx.p2.entity.Box;
import com.mygdx.p2.entity.Cannon;
import com.mygdx.p2.entity.ObstacleField;

public class GameScreen implements Screen {
    private MyGame game;

    private SpriteBatch batch;
    private Stage stage;

    private static Cannon cannon;

    private static ObstacleField obstacles;

    private static Box box;

    // Current Delta time
    public static float deltaTime;

    // Constructor
    public GameScreen(MyGame inGame){
        game = inGame;
    }

    @Override
    public void dispose() {
        stage.dispose();
        batch.dispose();
    }

    @Override
    public void pause() {}

    @Override
    public void render (float delta) {
        Gdx.gl.glClearColor(0 / (float)0xFF, 64 / (float)( 0xFF ), 123 / (float)( 0xFF ), 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        // Update delta time
        deltaTime = delta;

        // Draw Box
        box.draw();

        // Render layout
        game.renderBasicScreen(stage, batch);

        // Draw Cannon
        cannon.draw(batch);

        // Draw Obstacle Field
        obstacles.draw();
    }

    @Override
    public void resize(int arg0, int arg1) {}

    @Override
    public void resume() {}

    @Override
    public void show() {
        float centerX = Gdx.graphics.getWidth() / 2;

        // Setup screen
        stage = new Stage();
        batch = new SpriteBatch();

        // Setup the Box
        box = new Box();

        // Setup the cannon
        cannon = new Cannon(centerX, 0);

        // Setup the obstacle field
        obstacles = new ObstacleField();

        // Setup the basic setup
        game.setupBasicScreen(stage);
    }

    @Override
    public void hide() {
        stage.dispose();
        batch.dispose();
    }

    public static ObstacleField getField() {
        return obstacles;
    }

    public static Cannon getCannon() {
        return cannon;
    }
}
