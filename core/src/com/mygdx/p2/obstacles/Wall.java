package com.mygdx.p2.obstacles;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.math.Circle;
import com.badlogic.gdx.math.Intersector;
import com.badlogic.gdx.math.Vector3;
import com.badlogic.gdx.math.Rectangle;

import java.util.Random;

public class Wall implements Obstacle {
    private float x, y;
    private Color color;

    private ShapeRenderer renderer;
    private Rectangle rect;

    private float WIDTH;
    private float HEIGHT;

    public Wall(Vector3 startPos, Vector3 endPos, Color color) {
        // Set Size
        setRect(startPos, endPos);

        // Set Rect color
        this.color = color;

        // Set Rectangle
        this.rect = new Rectangle(x, y, WIDTH, HEIGHT);

        // Create new instance of shape
        this.renderer = new ShapeRenderer();
    }

    /**
     * Draws rectangle from (x, y)
     */
    @Override
    public void draw(OrthographicCamera camera) {
        renderer.setProjectionMatrix(camera.combined);

        renderer.begin(ShapeRenderer.ShapeType.Filled);

            // Draw Border
            renderer.setColor(Color.BLACK);
            renderer.rect(x - 1, y - 1, WIDTH + 2, HEIGHT + 2);

            // Draw Rect
            renderer.setColor(color);
            renderer.rect(x, y, WIDTH, HEIGHT);

        renderer.end();
    }

    @Override
    public boolean hit(Circle cannonball) {
        if(cannonball == null) return false;

        return Intersector.overlaps(cannonball, rect);
    }

    private void setRect(Vector3 startPos, Vector3 endPos) {
        // Set Pos
        this.x = (startPos.x < endPos.x) ? startPos.x : endPos.x;
        this.y = (startPos.y < endPos.y) ? startPos.y : endPos.y;

        // Set Size
        this.WIDTH = Math.abs(startPos.x - endPos.x);
        this.HEIGHT = Math.abs(startPos.y - endPos.y);
    }

    /**
     * Returns a random color
     */
    private Color getRandColor() {
        Random rand = new Random();

        float r = rand.nextFloat();
        float g = rand.nextFloat();
        float b = rand.nextFloat();

        return new Color(r, g, b, 1);
    }
}