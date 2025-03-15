package com.exodus.game.screens

import com.badlogic.gdx.scenes.scene2d.ui.Table
import com.badlogic.gdx.scenes.scene2d.ui.Label
import com.badlogic.gdx.graphics.Color
import com.exodus.game.ExodusGame

class FeedbackScreen(game: ExodusGame) : GameScreen(game, "Feedback & News") {
    override fun addContent(table: Table) {
        val style = Label.LabelStyle(game.font, Color.WHITE)
        table.add(Label("Feedback and news section coming soon...", style)).pad(50f).row()
    }
}
