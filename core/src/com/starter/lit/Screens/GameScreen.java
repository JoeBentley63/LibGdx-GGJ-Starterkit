package com.starter.lit.Screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.starter.lit.GameObjects.Ball;
import com.starter.lit.GameObjects.GameObject;
import com.starter.lit.GameObjects.Paddle;
import com.starter.lit.StarterKit;

/**
 * Created by Joseph on 30/12/2015.
 */
public class GameScreen implements Screen {

    //private final Screen newScreen;
    private final StarterKit game;
    private final SpriteBatch spriteBatch;
    private Paddle topPaddle;
    private Paddle bottomPaddle;
    private Ball ball;
    public GameScreen(StarterKit game){
        this.game = game;
        spriteBatch = new SpriteBatch();
        topPaddle = new Paddle(game, 20, 20, Input.Keys.LEFT, Input.Keys.RIGHT);
        bottomPaddle = new Paddle(game, 20, 420, Input.Keys.A, Input.Keys.D);
        ball = new Ball(game, 200, 220);
    }

    private void BallPaddlesCollisionDetection(){
        if(checkGameObjectCollision(ball, bottomPaddle) || checkGameObjectCollision(ball, topPaddle)){
            System.out.println("Hit");
            ball.velocityY *= -1;
        }
    }

    private boolean checkGameObjectCollision(GameObject first, GameObject second){
        return first.getBoundingRectangle().overlaps(second.getBoundingRectangle());
    }
    public void Update(){
        BallPaddlesCollisionDetection();
        topPaddle.update();
        bottomPaddle.update();
        ball.update();
    }

    public void Draw(){
        topPaddle.draw(spriteBatch);
        bottomPaddle.draw(spriteBatch);
        ball.draw(spriteBatch);
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
