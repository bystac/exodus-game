package com.exodus.game.desktop

import com.badlogic.gdx.backends.lwjgl3.Lwjgl3Application
import com.badlogic.gdx.backends.lwjgl3.Lwjgl3ApplicationConfiguration
import com.exodus.game.ExodusGame

/**
 * Desktop launcher for the Exodus Game.
 * Uses LWJGL3 backend for modern desktop support.
 */
object DesktopLauncher {
    @JvmStatic
    fun main(args: Array<String>) {
        val config = Lwjgl3ApplicationConfiguration().apply {
            // Set window title
            setTitle("Exodus Game")

            // Set window size
            setWindowedMode(1280, 720)

            // Enable vsync for smoother rendering
            setVSync(true)

            // Set foreground FPS limit (0 for unlimited)
            setForegroundFPS(60)

            // Configure MSAA for smoother edges
            setBackBufferConfig(8, 8, 8, 8, 16, 0, 4)
        }

        Lwjgl3Application(ExodusGame(), config)
    }
}
