package biz.dvlop.exodus.screens

import com.badlogic.gdx.scenes.scene2d.ui.Table
import com.badlogic.gdx.scenes.scene2d.ui.Label
import com.badlogic.gdx.graphics.Color
import biz.dvlop.exodus.ExodusGame

/**
 * Previous Runs screen implementation.
 *
 * Displays a history of the player's previous game runs.
 *
 * @param game Reference to the main game instance
 */
class PreviousRunsScreen(game: ExodusGame) : GameScreen(game, "Previous Runs") {
    override fun addContent(table: Table) {
        val skin = game.assets.skin
        table.add(Label("Previous Runs Coming Soon", skin, "medium")).pad(10f).row()
    }
}
