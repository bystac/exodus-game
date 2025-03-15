package biz.dvlop.exodus.screens

import biz.dvlop.exodus.ExodusGame
import com.badlogic.gdx.Gdx
import com.badlogic.gdx.graphics.Color
import com.badlogic.gdx.scenes.scene2d.ui.Label
import com.badlogic.gdx.scenes.scene2d.ui.Table
import com.badlogic.gdx.scenes.scene2d.ui.TextButton
import com.badlogic.gdx.utils.Align
import ktx.actors.onClick

/**
 * Main gameplay screen that handles the actual game.
 */
class MainGameScreen(game: ExodusGame) : GameScreen(game, "Game") {

    override fun addContent(table: Table) {
        val skin = game.assets.skin

        // Add game UI elements
        table.add(Label("Game world coming soon!", skin, "large")).center().row()
        table.add(Label("This is where the game will be played", skin, "medium")).padTop(20f).center()
    }

    override fun render(delta: Float) {
        super.render(delta)

        // Game-specific rendering logic would go here
        // Update game state, render game objects, etc.
    }
}
