package com.mygdx.p2.entity;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Circle;
import com.badlogic.gdx.math.Vector2;

/**
 * Created with IntelliJ IDEA
 * User : Oli
 * Date : 9/9/2014
 * Time : 02:09
 */
public class CannonBall {

    private float angle, power = 5f;

    // Vectors
    private Vector2 velocity = new Vector2();
    public Vector2 position = new Vector2();

    // Sprite
    private static Texture ballTexture;
    private static Sprite ball;

    // Ball
    public Circle cannonball;


    private static final float CANNONBALL_SIZE = 25f;

    public CannonBall(float x, float y, float angle) {
        this.angle = angle;

        ballTexture = new Texture(Gdx.files.internal("data/ball.png"));
        ball = new Sprite(ballTexture);

        this.cannonball = new Circle(x, y, CANNONBALL_SIZE / 2);

        drawInit(x, y);
    }

    public void drawInit(float x, float y) {
        // Set ball size
        ball.setSize(CANNONBALL_SIZE, CANNONBALL_SIZE);

        // Set Origin point as center
        ball.setOriginCenter();

        //Set position vector
        position.add(x, y);
    }

    public void draw(SpriteBatch batch) {
        setPosition();

        // Draw the cannon ball
        ball.draw(batch);
    }

    public void setPosition() {
        // Update velocity vector
        float velocityX = (float) (power * Math.cos(angle));
        float velocityY = (float) (power * Math.sin(angle));

        // Update position vector
        position.add(velocityX, velocityY);

        // Update position
        ball.setPosition(position.x, position.y);

        // Update Shape
        cannonball.setPosition(position);
    }

    public boolean inWorld() {
        // Check if the ball is of the screen
        if(position.x > Gdx.graphics.getWidth() || position.x < 0)
            return false;

        if(position.y > Gdx.graphics.getHeight() || position.y < 0)
            return false;

        return true;
    }
}
