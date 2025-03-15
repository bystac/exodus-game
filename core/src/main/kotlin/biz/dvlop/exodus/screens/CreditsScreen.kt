package biz.dvlop.exodus.screens

import com.badlogic.gdx.scenes.scene2d.ui.Table
import com.badlogic.gdx.scenes.scene2d.ui.Label
import com.badlogic.gdx.graphics.Color
import biz.dvlop.exodus.ExodusGame

/**
 * Credits screen implementation.
 *
 * Displays the game's credits, including developers, artists, and acknowledgements.
 *
 * @param game Reference to the main game instance
 */
class CreditsScreen(game: ExodusGame) : GameScreen(game, "Credits") {
    override fun addContent(table: Table) {
        val skin = game.assets.skin
        table.add(Label("Credits Coming Soon", skin, "medium")).pad(10f).row()
    }
}
