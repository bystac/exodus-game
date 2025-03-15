package biz.dvlop.exodus.screens

import com.badlogic.gdx.scenes.scene2d.ui.Table
import com.badlogic.gdx.scenes.scene2d.ui.Label
import com.badlogic.gdx.graphics.Color
import biz.dvlop.exodus.ExodusGame

/**
 * Character selection screen implementation.
 *
 * Allows the player to choose a character before starting the game.
 *
 * @param game Reference to the main game instance
 */
class CharacterSelectionScreen(game: ExodusGame) : GameScreen(game, "Character Selection") {
    override fun addContent(table: Table) {
        val skin = game.assets.skin
        table.add(Label("Character selection coming soon...", skin, "medium")).pad(50f).row()
    }
}
