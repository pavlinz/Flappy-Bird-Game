package com.mygdx.game;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;

import java.util.Random;

public class Obstacles {
    class WallPair
    {
        Vector2 position;
        float speed;
        int offSet;
        Rectangle emptySpace;

        public WallPair(Vector2 pos) {
            position = pos;
            speed = 2;
            offSet = new Random().nextInt(250);
            emptySpace = new Rectangle(position.x, position.y - offSet + 300, 50, betweenDistance);
        }

        public void update() {
            position.x -= speed;
            if(position.x == -50) {
                position.x = 800;
                offSet = new Random().nextInt(250);
            }
            emptySpace.y = position.y - offSet + 300;
            emptySpace.x = position.x;
        }
    }

    static WallPair[] pairs;
    Texture img;
    int betweenDistance;

    public Obstacles() {
        img = new Texture("wall.png");
        pairs = new WallPair[4];
        betweenDistance = 250;
        int startPosX = 400;

        for(int i = 0; i < pairs.length; i++) {
            pairs[i] = new WallPair(new Vector2(startPosX,0));
            startPosX += 220;
        }
    }

    public void render(SpriteBatch batch) {
        for (int i = 0; i < pairs.length; i++) {
            batch.draw(img, pairs[i].position.x, pairs[i].position.y  - pairs[i].offSet);
            batch.draw(img, pairs[i].position.x, pairs[i].position.y + betweenDistance + img.getHeight() - pairs[i].offSet);
        }
    }

    public void update() {
        for (int i = 0; i < pairs.length; i++) {
            pairs[i].update();
        }
    }

    public void recreate() {
        int startPosX = 400;
        for(int i = 0; i < pairs.length; i++) {
            pairs[i] = new WallPair(new Vector2(startPosX,0));
            startPosX += 220;
        }
    }
}
