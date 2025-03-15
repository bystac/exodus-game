package biz.dvlop.exodus.screens

import com.badlogic.gdx.Gdx
import com.badlogic.gdx.scenes.scene2d.ui.Label
import com.badlogic.gdx.scenes.scene2d.ui.Table
import com.badlogic.gdx.graphics.Color
import biz.dvlop.exodus.ExodusGame
import biz.dvlop.exodus.assets.GameAssets

/**
 * Loading screen implementation.
 *
 * Displays a loading progress indicator and transitions to the main menu
 * once loading is complete.
 *
 * @param game Reference to the main game instance
 */
class LoadingScreen(game: ExodusGame) : BaseScreen(game) {
    private var progress = 0f
    private val loadingLabel: Label
    private val assets = GameAssets()

    init {
        // Initialize assets
        assets.load()

        // Setup UI
        val table = Table()
        table.setFillParent(true)

        loadingLabel = Label("Loading...", assets.skin, "large").apply {
            color = Color.WHITE
        }
        table.add(loadingLabel).center()

        stage.addActor(table)
    }

    override fun render(delta: Float) {
        super.render(delta)

        progress += delta * 0.1f
        if (progress >= 1f) {
            game.setScreen(game.menuScreen)
            return
        }

        loadingLabel.setText("Loading... ${(progress * 100).toInt()}%")
    }

    override fun dispose() {
        super.dispose()
        assets.dispose()
    }
}
