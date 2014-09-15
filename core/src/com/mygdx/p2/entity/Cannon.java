package com.mygdx.p2.entity;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Circle;

/**
 * Created with IntelliJ IDEA
 * User : Oli
 * Date : 9/8/2014
 * Time : 14:52
 */
public class Cannon {
    private float x, y;
    private static Texture cannonTexture;
    private static Sprite cannon;
    public static CannonBall ball;
    public static Circle cannonball;

    private static final float CANNON_WIDTH = 100f;
    private static final float CANNON_HEIGHT = 90f;
    private static final float ROTAION_SPEED = 3f;

    public Cannon(float x, float y) {
        this.x = x;
        this.y = y;

        // Set Texture
        cannonTexture = new Texture(Gdx.files.internal("data/cannon.png"));
        cannon = new Sprite(cannonTexture);

        drawInit();
    }

    private void drawInit() {
        // Set the cannon size
        cannon.setSize(CANNON_WIDTH, CANNON_HEIGHT);

        // Point the cannon up
        cannon.rotate90(false);

        // Set Rotate point as center
        cannon.setOriginCenter();

        // Set Origin pos and rotate up
        cannon.setPosition(x - CANNON_WIDTH / 2, y - CANNON_HEIGHT / 2);
    }

    public void draw(SpriteBatch batch) {
        updateRotaion();

        batch.begin();
            if(ball != null) {
                if (ball.inWorld())
                    ball.draw(batch);
                else
                    ball = null;
            }

            cannon.draw(batch);
        batch.end();
    }

    public void fireCannon() {
        double margin = 10.0;

        // Cannon center point
        double centerX = (CANNON_WIDTH / 2) + cannon.getX();
        double centerY = (CANNON_HEIGHT / 2) + cannon.getY();

        // Theta
        double t = Math.toRadians(cannon.getRotation() + 90);

        // Radius
        double r = (cannon.getWidth() / 2) - margin;

        // Calculate fireball pos
        double x = (centerX + r * Math.cos(t)) - margin;
        double y = (centerY + r * Math.sin(t)) - margin;

        // Create ball
        ball = new CannonBall((float) x , (float) y, (float) t);

        // Create shape
        cannonball = ball.cannonball;
    }

    private void updateRotaion() {
        float currentRotation = cannon.getRotation();

        // Right
        if(Gdx.input.isKeyPressed(Input.Keys.RIGHT))
            currentRotation -= 3;

        // Left
        if(Gdx.input.isKeyPressed(Input.Keys.LEFT))
            currentRotation += 3;

        // Set rotation boundaries
        if(currentRotation < -90)
            currentRotation = -90;

        if(currentRotation > 90)
            currentRotation = 90;

        cannon.setRotation(currentRotation);
    }
}
