package com.starter.lit;

import com.badlogic.gdx.Game;
import com.starter.lit.Helper.AssetStore;
import com.starter.lit.Screens.LoadingScreen;

public class StarterKit extends Game {
    LoadingScreen loadingScreen;
    public AssetStore assetStore;

    @Override
    public void create() {
        assetStore = AssetStore.getInstance();
        loadingScreen = new LoadingScreen(this);
        setScreen(loadingScreen);
    }
}