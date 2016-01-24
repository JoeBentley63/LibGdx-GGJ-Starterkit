package com.starter.lit.GameObjects;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.starter.lit.StarterKit;

/**
 * Created by Joseph on 31/12/2015.
 */
public class Ball extends GameObject{
    private StarterKit game;
    public int velocityX;
    public int velocityY;
    public Ball(StarterKit game, int positionX, int positionY){
        super(game.assetStore.getAsset("ball.png", Texture.class), positionX, positionY);
        this.game = game;
        this.velocityX = 1;
        this.velocityY = 1;
    }

    @Override
    public void update(){
        CheckBallIsWithinBounds();
        applyVelocity();
        this.setPosition(positionX, positionY);
    }

    private void CheckBallIsWithinBounds() {
        if(positionX < 0 || positionX > Gdx.graphics.getWidth()){
            this.velocityX *= -1;
        }
        if(positionY < 0 || positionY > Gdx.graphics.getHeight()){
            this.velocityY *= -1;
        }
    }

    private void applyVelocity() {
        this.positionX += this.velocityX;
        this.positionY += this.velocityY;
    }
}
