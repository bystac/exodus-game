package biz.dvlop.exodus.screens

import com.badlogic.gdx.scenes.scene2d.ui.Table
import com.badlogic.gdx.scenes.scene2d.ui.Label
import com.badlogic.gdx.graphics.Color
import biz.dvlop.exodus.ExodusGame

/**
 * Feedback screen implementation.
 *
 * Displays news and allows users to provide feedback.
 *
 * @param game Reference to the main game instance
 */
class FeedbackScreen(game: ExodusGame) : GameScreen(game, "Feedback & News") {
    override fun addContent(table: Table) {
        val skin = game.assets.skin
        table.add(Label("News and Feedback Coming Soon", skin, "medium")).pad(10f).row()
    }
}
