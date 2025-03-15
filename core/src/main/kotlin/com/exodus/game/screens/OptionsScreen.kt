package com.exodus.game.screens

import com.badlogic.gdx.scenes.scene2d.ui.Table
import com.badlogic.gdx.scenes.scene2d.ui.Label
import com.badlogic.gdx.graphics.Color
import com.exodus.game.ExodusGame

class OptionsScreen(game: ExodusGame) : GameScreen(game, "Options") {
    override fun addContent(table: Table) {
        val style = Label.LabelStyle(game.font, Color.WHITE)
        table.add(Label("Options coming soon...", style)).pad(50f).row()
    }
}
