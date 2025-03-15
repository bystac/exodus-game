@file:JvmName("Lwjgl3Launcher")

package biz.dvlop.exodus.launchers

import com.badlogic.gdx.backends.lwjgl3.Lwjgl3Application
import com.badlogic.gdx.backends.lwjgl3.Lwjgl3ApplicationConfiguration
import biz.dvlop.exodus.ExodusGame

/** Launches the desktop (LWJGL3) application. */
fun main() {
    // This handles macOS support and helps on Windows.
    if (StartupHelper.startNewJvmIfRequired())
        return

    Lwjgl3Application(ExodusGame(), Lwjgl3ApplicationConfiguration().apply {
        setTitle("Exodus")
        setWindowedMode(1280, 720) // Larger default window size
        setWindowIcon(*(arrayOf(128, 64, 32, 16).map { "libgdx$it.png" }.toTypedArray()))
    })
}
