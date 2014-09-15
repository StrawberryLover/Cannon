package com.mygdx.p2.screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.mygdx.p2.MyGame;

public class OptionScreen implements Screen {
    private MyGame game;

    private SpriteBatch batch;
    private Stage stage;

    // Constructor
    public OptionScreen(MyGame inGame){
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
        Gdx.gl.glClearColor(0, 0, 0.2f, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        // Render layout
        game.renderBasicScreen(stage, batch);
    }

    @Override
    public void resize(int arg0, int arg1) {}

    @Override
    public void resume() {}

    @Override
    public void show() {
        stage = new Stage();
        batch = new SpriteBatch();

        game.setupBasicScreen(stage);
    }

    @Override
    public void hide() {
        stage.dispose();
        batch.dispose();
    }
}
