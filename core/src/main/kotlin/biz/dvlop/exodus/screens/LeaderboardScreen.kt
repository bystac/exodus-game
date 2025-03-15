package biz.dvlop.exodus.screens

import com.badlogic.gdx.scenes.scene2d.ui.Table
import com.badlogic.gdx.scenes.scene2d.ui.Label
import com.badlogic.gdx.graphics.Color
import biz.dvlop.exodus.ExodusGame

/**
 * Leaderboard screen implementation.
 *
 * Displays the game's leaderboard with player rankings.
 *
 * @param game Reference to the main game instance
 */
class LeaderboardScreen(game: ExodusGame) : GameScreen(game, "Leaderboard") {
    override fun addContent(table: Table) {
        val skin = game.assets.skin
        table.add(Label("Leaderboard Coming Soon", skin, "medium")).pad(10f).row()
    }
}
