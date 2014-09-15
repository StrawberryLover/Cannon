package com.mygdx.p2.obstacles;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.math.Circle;
import com.badlogic.gdx.math.Intersector;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector3;

/**
 * Created with IntelliJ IDEA
 * User : Oli
 * Date : 9/14/2014
 * Time : 06:40
 */
public class Line implements Obstacle {
    private Vector3 start, end;

    private ShapeRenderer renderer;
    private Rectangle line;

    // Set Line color as black
    private static final Color LINE_COLOR = Color.BLACK;

    public Line(Vector3 startPos, Vector3 endPos) {
        this.start = new Vector3(startPos);
        this.end = new Vector3(endPos);

        // Set Line
        this.line = new Rectangle(start.x, start.y, end.x, end.y);

        // Create new instance of shape
        this.renderer = new ShapeRenderer();
    }

    @Override
    public void draw(OrthographicCamera camera) {
        renderer.setProjectionMatrix(camera.combined);

        renderer.begin(ShapeRenderer.ShapeType.Line);
            // Set Color as black
            renderer.setColor(LINE_COLOR);

            // Set the line
            renderer.line(start.x, start.y, end.x, end.y);
        renderer.end();
    }

    @Override
    public boolean hit(Circle cannonball) {
        if(cannonball == null) return false;

        return Intersector.overlaps(cannonball, line);
    }
}
