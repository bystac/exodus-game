package com.exodus.game;

import com.badlogic.gdx.backends.lwjgl3.Lwjgl3Application;
import com.badlogic.gdx.backends.lwjgl3.Lwjgl3ApplicationConfiguration;
import com.badlogic.gdx.graphics.glutils.HdpiMode;

public class DesktopLauncher {
    public static void main(String[] args) {
        if (StartupHelper.startNewJvmIfRequired()) return; // Handles -XstartOnFirstThread
        
        Lwjgl3ApplicationConfiguration config = new Lwjgl3ApplicationConfiguration();
        
        // Window settings
        config.setTitle("Exodus Game");
        config.setWindowedMode(1280, 720);
        config.useVsync(true);
        config.setForegroundFPS(60);
        config.setBackBufferConfig(8, 8, 8, 8, 16, 0, 4);
        
        // HiDPI support
        config.setHdpiMode(HdpiMode.Logical);
        
        // OpenGL settings
        config.setOpenGLEmulation(Lwjgl3ApplicationConfiguration.GLEmulation.GL20, 2, 0);
        config.enableGLDebugOutput(true, System.out);
        
        // Window icon - TODO: Add proper icons
        //config.setWindowIcon("icon128.png", "icon64.png", "icon32.png", "icon16.png");
        
        new Lwjgl3Application(new ExodusGame(), config);
    }
}
