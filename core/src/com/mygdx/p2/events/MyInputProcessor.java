package com.mygdx.p2.events;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.InputProcessor;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.math.Vector3;
import com.mygdx.p2.entity.Cannon;
import com.mygdx.p2.entity.ObstacleField;
import com.mygdx.p2.obstacles.Line;
import com.mygdx.p2.obstacles.Wall;
import com.mygdx.p2.screens.GameScreen;

/**
 * Created with IntelliJ IDEA
 * User : Oli
 * Date : 9/12/2014
 * Time : 05:19
 */
public class MyInputProcessor implements InputProcessor {
    private Vector3 startPos = new Vector3(), endPos = new Vector3();
    boolean isDragging = false;

    ObstacleField field = GameScreen.getField();
    Cannon cannon = GameScreen.getCannon();

    @Override
    public boolean keyDown(int keycode) {
        return false;
    }

    @Override
    public boolean keyUp(int keycode) {
        return false;
    }

    @Override
    public boolean keyTyped(char character) {

        // Fire cannon
        if(character == 'z') {
            cannon.fireCannon();
        }

        return false;
    }

    @Override
    public boolean touchDown(int screenX, int screenY, int pointer, int button) {
       // Set Start point
       startPos.set(Gdx.input.getX(), Gdx.input.getY(), 0);
       field.camera.unproject(startPos);

        // Set dragging
        isDragging = true;

        return false;
    }

    @Override
    public boolean touchUp(int screenX, int screenY, int pointer, int button) {

       // Check if dragging
       if(!isDragging) return  false;

        // Update EndPoint
        endPos.set(Gdx.input.getX(), Gdx.input.getY(), 0);
        field.camera.unproject(endPos);

        // Add Rect or Line as an obstacle
        if (button == Input.Buttons.LEFT) {
            field.addObstacle(new Wall(startPos, endPos, Color.RED));
        } else {
            field.addObstacle(new Line(startPos, endPos));
        }

        // Disable drag
        isDragging = false;

        return false;
    }

    @Override
    public boolean touchDragged(int screenX, int screenY, int pointer) {
        // Update EndPoint
        endPos.set(Gdx.input.getX(), Gdx.input.getY(), 0);
        field.camera.unproject(endPos);

        // Update temp Rect or Line
        if (Gdx.input.isButtonPressed(Input.Buttons.LEFT)) {
            field.addTempObstacle(new Wall(startPos, endPos, Color.RED));
        } else {
            field.addTempObstacle(new Line(startPos, endPos));
        }

        return false;
    }

    @Override
    public boolean mouseMoved(int screenX, int screenY) {
        return false;
    }

    @Override
    public boolean scrolled(int amount) {
        return false;
    }
}
