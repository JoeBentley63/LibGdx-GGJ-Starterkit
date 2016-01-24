package com.starter.lit.GameObjects;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Vector2;
import com.starter.lit.StarterKit;

/**
 * Created by Joseph on 31/12/2015.
 */
public class Paddle extends GameObject{
    private StarterKit game;
    private int leftKey;
    private int rightKey;
    public Paddle(StarterKit game, int positionX, int positionY, int leftKey, int rightKey){
        super(game.assetStore.getAsset("paddle.png", Texture.class), positionX, positionY);
        this.game = game;
        this.leftKey = leftKey;
        this.rightKey = rightKey;
    }

    @Override
    public void update(){
        if(Gdx.input.isKeyPressed(leftKey)){
            positionX--;
        }

        if(Gdx.input.isKeyPressed(rightKey)){
            positionX++;
        }

        this.setPosition(positionX, positionY);
    }
}
