package com.mygdx.game;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;

public class Background {
    private Texture tx;   // picture itself
    private Texture tx2;
    private Vector2 pos;
    private Vector2 pos2;
    private int speed;

    public Background() {
        tx = new Texture("back.png");
        tx2 = new Texture("back.png");
        pos = new Vector2(0,0);
        pos2 = new Vector2(800,0);
        speed = 2;
    }

    public void render(SpriteBatch batch) {
        batch.draw(tx, pos.x, pos.y);
        batch.draw(tx2, pos2.x, pos2.y);
    }

    public void update () {
        pos.x -= speed;
        pos2.x -= speed;
        if (pos.x == -800) {
            pos.x = 800;
        }
        else if(pos2.x == -800) {
            pos2.x = 800;
        }
    }
}
