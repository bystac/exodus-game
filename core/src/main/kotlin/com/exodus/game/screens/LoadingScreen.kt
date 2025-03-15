package com.exodus.game.screens

import com.badlogic.gdx.scenes.scene2d.ui.Label
import com.badlogic.gdx.scenes.scene2d.ui.Table
import com.badlogic.gdx.graphics.Color
import com.badlogic.gdx.scenes.scene2d.ui.Label.LabelStyle
import com.exodus.game.ExodusGame

class LoadingScreen(game: ExodusGame) : BaseScreen(game) {
    private var progress = 0f
    private val loadingLabel: Label

    init {
        val table = Table()
        table.setFillParent(true)

        val style = LabelStyle(game.font, Color.WHITE)
        loadingLabel = Label("Loading...", style)
        table.add(loadingLabel).center()

        stage.addActor(table)
    }

    override fun render(delta: Float) {
        super.render(delta)

        progress += delta * 0.1f
        if (progress >= 1f) {
            game.setScreen(MainMenuScreen(game))
            return
        }

        loadingLabel.setText("Loading... ${(progress * 100).toInt()}%")
    }
}
