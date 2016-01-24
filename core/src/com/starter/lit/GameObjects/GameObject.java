package com.starter.lit.GameObjects;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.math.Vector2;
import com.starter.lit.StarterKit;

/**
 * Created by Joseph on 31/12/2015.
 */
public abstract class GameObject extends Sprite{

    protected int positionX;
    protected int positionY;

    public GameObject(Texture texture, int positionX, int positionY){
        super(texture);
        this.positionX = positionX;
        this.positionY = positionY;
    }

    public void update(){

    }
}
