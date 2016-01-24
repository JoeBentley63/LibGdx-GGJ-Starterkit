package com.starter.lit.Helper;

import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.assets.loaders.TextureLoader;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;

/**
 * Created by Joseph on 30/12/2015.
 */
public class AssetStore {
    private static AssetStore singletonInstance;
    private BitmapFont simpleFont;
    public AssetManager assetManager;
    private AssetStore(){
        assetManager = new AssetManager();
        loadFont();
        loadAssets();
    }

    public static AssetStore getInstance(){
        if(singletonInstance == null){
            singletonInstance = new AssetStore();
        }
        return singletonInstance;
    }

    public void loadAssets(){
        assetManager.load("paddle.png", Texture.class);
        assetManager.load("ball.png", Texture.class);
    }

    public <T> T getAsset(String assetName, Class<T> returnType){
            return assetManager.get(assetName, returnType);
    }

    public BitmapFont getFont(){
        return simpleFont;
    }

    private void loadFont(){
        simpleFont = new BitmapFont();
        simpleFont.setColor(Color.WHITE);
    }

}


