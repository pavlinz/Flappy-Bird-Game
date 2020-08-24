package com.mygdx.game;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class MyGdxGame extends ApplicationAdapter {
	Music music;

	SpriteBatch batch;
	Background bg;
	Bird bird;
	Obstacles obstacles;
	boolean gameOver;
	Texture restart;
	
	@Override
	public void create () {
		batch = new SpriteBatch();
		bg = new Background();
		bird = new Bird();
		obstacles = new Obstacles();
		music = Gdx.audio.newMusic(Gdx.files.internal("music.mp3"));
		music.setLooping(true);
		music.setVolume(0.1f);
		music.play();
		gameOver = false;
		restart = new Texture("RestartBtn.png");
	}

	@Override
	public void render () {
		update();
		Gdx.gl.glClearColor(1, 1, 1, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		batch.begin();
		bg.render(batch);
		obstacles.render(batch);
		if(!gameOver) {
			bird.render(batch);
		} else {
			batch.draw(restart, 200, 200);
		}
		batch.end();
	}

	public void update () {
		bg.update();
		bird.update();
		obstacles.update();
		for(int i = 0; i < Obstacles.pairs.length; i++) {
			if(bird.position.x > Obstacles.pairs[i].position.x && bird.position.x < Obstacles.pairs[i].position.x + 50) {
				if(!Obstacles.pairs[i].emptySpace.contains(bird.position)) {
					gameOver = true;
				}
			}
		}
		if(bird.position.y < 0 || bird.position.y > 600) {
			gameOver = true;
		}
		if((Gdx.input.isKeyPressed(Input.Keys.ENTER)) && (gameOver = true)) {
			recreate();
			gameOver = false;
		}
	}

	public void recreate() {
		bird.recreate();
		obstacles.recreate();
	}
	
	@Override
	public void dispose () {
		batch.dispose();
		music.dispose();
	}
}
