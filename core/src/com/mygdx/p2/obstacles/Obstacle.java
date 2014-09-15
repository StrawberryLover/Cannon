package com.mygdx.p2.obstacles;

import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.math.Circle;

/**
 * Created with IntelliJ IDEA
 * User : Oli
 * Date : 9/14/2014
 * Time : 17:41
 */
public interface Obstacle {
    public void draw(OrthographicCamera camera);
    public boolean hit(Circle ball);
}
