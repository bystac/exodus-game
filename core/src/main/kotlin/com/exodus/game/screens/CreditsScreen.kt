package com.exodus.game.screens

import com.badlogic.gdx.scenes.scene2d.ui.Table
import com.badlogic.gdx.scenes.scene2d.ui.Label
import com.badlogic.gdx.graphics.Color
import com.exodus.game.ExodusGame

class CreditsScreen(game: ExodusGame) : GameScreen(game, "Credits") {
    override fun addContent(table: Table) {
        val style = Label.LabelStyle(game.font, Color.WHITE)
        table.add(Label("Credits coming soon...", style)).pad(50f).row()
    }
}
