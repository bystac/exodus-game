package biz.dvlop.exodus.screens

import com.badlogic.gdx.scenes.scene2d.ui.Table
import com.badlogic.gdx.scenes.scene2d.ui.Label
import com.badlogic.gdx.graphics.Color
import biz.dvlop.exodus.ExodusGame

/**
 * Options screen implementation.
 *
 * Allows the player to configure game settings.
 *
 * @param game Reference to the main game instance
 */
class OptionsScreen(game: ExodusGame) : GameScreen(game, "Options") {
    override fun addContent(table: Table) {
        val skin = game.assets.skin
        table.add(Label("Options Coming Soon", skin, "medium")).pad(10f).row()
    }
}
