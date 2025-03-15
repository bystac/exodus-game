package biz.dvlop.exodus

import biz.dvlop.exodus.assets.GameAssets
import biz.dvlop.exodus.screens.GameScreen
import biz.dvlop.exodus.screens.MainGameScreen
import biz.dvlop.exodus.screens.MainMenuScreen
import com.badlogic.gdx.Game
import com.badlogic.gdx.Gdx
import com.badlogic.gdx.graphics.g2d.SpriteBatch

/**
 * Main game class for Exodus.
 *
 * This class serves as the core game engine, handling the SpriteBatch,
 * font resources, and screen management.
 */
class ExodusGame : Game() {
    // Game assets and resources
    lateinit var batch: SpriteBatch
        private set
    lateinit var assets: GameAssets
        private set

    // Game screens
    lateinit var menuScreen: MainMenuScreen
        private set
    lateinit var gameScreen: MainGameScreen
        private set

    override fun create() {
        // Log the device information for debugging
        Gdx.app.log("ExodusGame", "Device: ${Gdx.app.type}, " +
                "Resolution: ${Gdx.graphics.width}x${Gdx.graphics.height}, " +
                "Density: ${Gdx.graphics.density}")

        // Initialize game resources
        batch = SpriteBatch()
        assets = GameAssets()
        assets.load()


        // Initialize screens
        menuScreen = MainMenuScreen(this)
        gameScreen = MainGameScreen(this)

        // Set initial screen
        setScreen(menuScreen)
    }

    override fun render() {
        super.render()
    }

    override fun dispose() {
        batch.dispose()
        assets.dispose()
        screen?.dispose()
    }
}
