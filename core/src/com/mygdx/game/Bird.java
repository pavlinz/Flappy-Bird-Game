package com.mygdx.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;

public class Bird {
    Texture img;
    Vector2 position;
    float vy;
    float gravity;

    public Bird() {
        img = new Texture("bird1.png");
        position = new Vector2(100, 350);
        vy = 0;
        gravity = -0.2f;
    }

    public void render(SpriteBatch batch) {
        batch.draw(img, position.x, position.y);
    }

    public void update() {
        if(Gdx.input.isKeyPressed(Input.Keys.SPACE)) {
            flap();
        }
        vy += gravity;
        position.y += vy;
    }

    private void flap() {
        vy = 5;
    }

    public void recreate() {
        position = new Vector2(100, 350);
        vy = 0;
    }

    public void dispose() {
        img.dispose();
    }
}
