package com.mygdx.p2.obstacles;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.math.Circle;
import com.badlogic.gdx.math.Intersector;

/**
 * Created with IntelliJ IDEA
 * User : Oli
 * Date : 9/15/2014
 * Time : 02:22
 */
public class Goal implements Obstacle {
    private float x, y, radius;

    private Circle goal;
    private ShapeRenderer render;

    // Set Goal color and size
    private static final Color GOAL_COLOR = Color.GREEN;
    private static final float GOAL_RADIUS = 25;

    public Goal() {
        // Set random x and y point
        this.x = randomWithRange(GOAL_RADIUS, Gdx.graphics.getWidth() - GOAL_RADIUS);
        this.y = randomWithRange(65, Gdx.graphics.getHeight() - GOAL_RADIUS);

        // Set Radius
        this.radius = GOAL_RADIUS;
        this.goal = new Circle(x, y, radius);

        this.render = new ShapeRenderer();
    }

    @Override
    public void draw(OrthographicCamera camera) {
        render.begin(ShapeRenderer.ShapeType.Filled);

            // Set Color
            render.setColor(GOAL_COLOR);

            // Draw
            render.circle(x, y, radius);
        render.end();
    }

    @Override
    public boolean hit(Circle cannonball) {
        if(cannonball == null) return false;

        return Intersector.overlaps(cannonball, goal);
    }

    private float randomWithRange(float min, float max)
    {
        float range = Math.abs(max - min) + 1;
        return (float)(Math.random() * range) + (min <= max ? min : max);
    }
}
