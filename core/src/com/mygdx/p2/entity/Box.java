package com.mygdx.p2.entity;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;

/**
 * Created with IntelliJ IDEA
 * User : Oli
 * Date : 9/15/2014
 * Time : 02:51
 */
public class Box {

    private static final float BOX_THICKNESS = 20f;
    private static final Color BOX_COLOR = Color.BLACK;
    private ShapeRenderer renderer;

    public Box() {
        this.renderer = new ShapeRenderer();
    }

    public void draw() {
        renderer.begin(ShapeRenderer.ShapeType.Filled);
            // Set Color
            renderer.setColor(BOX_COLOR);

            // Draw Ground
            // renderer.rect(0, 0, Gdx.graphics.getWidth(), BOX_THICKNESS);

            // Draw Walls
            renderer.rect(0, 0, BOX_THICKNESS, Gdx.graphics.getHeight());

            renderer.rect(Gdx.graphics.getWidth() - BOX_THICKNESS, 0, BOX_THICKNESS, Gdx.graphics.getHeight());

        renderer.end();
    }
}
