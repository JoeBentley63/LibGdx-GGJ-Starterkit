package com.starter.lit.Screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.starter.lit.StarterKit;

/**
 * Created by Joseph on 30/12/2015.
 */
public class LoadingScreen implements Screen {

    //private final Screen newScreen;
    private final StarterKit game;
    private final BitmapFont font;
    private final SpriteBatch spriteBatch;

    public LoadingScreen(StarterKit game){
        this.game = game;
        font = game.assetStore.getFont();
        spriteBatch = new SpriteBatch();
    }

    public void Update(){
        if(game.assetStore.assetManager.update()){
            game.setScreen(new GameScreen(game));
        }
    }

    public void Draw(){
        font.draw(spriteBatch, "Loading: " + (int)(game.assetStore.assetManager.getProgress() * 100) + "%", 20, 20);
    }

    @Override
    public void render(float deltaTimeSinceLastFrame){
        Update();

        Gdx.gl.glClearColor(1, 0, 0, 1);
        Gdx.gl.glClear( GL20.GL_COLOR_BUFFER_BIT | GL20.GL_DEPTH_BUFFER_BIT );;
        spriteBatch.begin();
        Draw();
        spriteBatch.end();
    }

    @Override
    public void resize(int width, int height) {
    }

    @Override
    public void show() {
        // called when this screen is set as the screen with game.setScreen();
    }

    @Override
    public void hide() {
        // called when current screen changes from this to a different screen
    }

    @Override
    public void pause() {
    }

    @Override
    public void resume() {
    }

    @Override
    public void dispose() {
        // never called automatically
    }
}
