package com.mygdx.p2.entity;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.mygdx.p2.obstacles.Goal;
import com.mygdx.p2.obstacles.Obstacle;

import java.util.ArrayList;

/**
 * Created with IntelliJ IDEA
 * User : Oli
 * Date : 9/12/2014
 * Time : 04:43
 */
public class ObstacleField {
    public OrthographicCamera camera;

    private ArrayList obstacles;
    private Obstacle tempObstacle;

    private Cannon cannon;

    public ObstacleField() {
        obstacles = new ArrayList<Obstacle>();

        // Setup the camera
        camera = new OrthographicCamera();
        camera.setToOrtho(false, Gdx.graphics.getHeight() , Gdx.graphics.getWidth());

        // Set Line width
        Gdx.gl.glLineWidth(2f);

        // Get cannon
        //cannon = Cannon.

        // Add Goal
        obstacles.add(new Goal());
    }

    public void draw() {
        // Update the camera
        camera.update();

        // Draw Obstacles
        for (Object anObstacle : obstacles) {
            Obstacle r = (Obstacle) anObstacle;

            if(r.hit(Cannon.cannonball))
                Cannon.ball = null;

            r.draw(camera);
        }

        if(tempObstacle != null)
            tempObstacle.draw(camera);
    }

    public void addObstacle(Obstacle obstacle) {
        obstacles.add(obstacle);

        // Clear dragging rect
        tempObstacle = null;
    }

    public void addTempObstacle(Obstacle obstacle) {
        tempObstacle = obstacle;

        // Draw temp obstacle
        tempObstacle.draw(camera);
    }
}
