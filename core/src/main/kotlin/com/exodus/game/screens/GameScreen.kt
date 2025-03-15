package com.exodus.game.screens

import com.badlogic.gdx.scenes.scene2d.ui.*
import com.badlogic.gdx.graphics.Color
import com.badlogic.gdx.scenes.scene2d.Actor
import com.badlogic.gdx.scenes.scene2d.utils.ChangeListener
import com.exodus.game.ExodusGame

abstract class GameScreen(game: ExodusGame, title: String) : BaseScreen(game) {
    init {
        val table = Table()
        table.setFillParent(true)

        val titleStyle = Label.LabelStyle(game.font, Color.WHITE)
        val titleLabel = Label(title, titleStyle)

        val buttonStyle = TextButton.TextButtonStyle()
        buttonStyle.font = game.font
        buttonStyle.fontColor = Color.WHITE

        val backButton = TextButton("Back", buttonStyle)
        backButton.addListener(object : ChangeListener() {
            override fun changed(event: ChangeEvent?, actor: Actor?) {
                game.setScreen(MainMenuScreen(game))
            }
        })

        table.add(titleLabel).padBottom(20f).row()
        addContent(table)
        table.add(backButton).width(100f).padTop(20f)

        stage.addActor(table)
    }

    // Override this method to add screen-specific content
    protected abstract fun addContent(table: Table)
}
