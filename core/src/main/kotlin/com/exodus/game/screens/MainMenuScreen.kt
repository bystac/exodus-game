package com.exodus.game.screens

import com.badlogic.gdx.scenes.scene2d.ui.*
import com.badlogic.gdx.graphics.Color
import com.badlogic.gdx.scenes.scene2d.ui.Label.LabelStyle
import com.badlogic.gdx.scenes.scene2d.ui.TextButton.TextButtonStyle
import com.badlogic.gdx.scenes.scene2d.Actor
import com.badlogic.gdx.scenes.scene2d.utils.ChangeListener
import com.exodus.game.ExodusGame

open class MainMenuScreen(
    game: ExodusGame,
    private val testLabelStyle: LabelStyle? = null,
    private val testButtonStyle: TextButtonStyle? = null
) : BaseScreen(game) {

    private val table: Table = Table()
    private val newGameButton: TextButton

    init {
        table.setFillParent(true)
        stage.addActor(table)

        val titleStyle = testLabelStyle ?: LabelStyle(game.font, Color(1f, 1f, 1f, 1f))
        val title = Label("EXODUS", titleStyle)

        val buttonStyle = testButtonStyle ?: TextButtonStyle().apply {
            font = game.font
            fontColor = Color(1f, 1f, 1f, 1f)
            downFontColor = Color(0.5f, 0.5f, 0.5f, 1f)
            overFontColor = Color(0.75f, 0.75f, 0.75f, 1f)
        }

        newGameButton = TextButton("New Game", buttonStyle)
        val continueButton = TextButton("Continue Game", buttonStyle)
        val optionsButton = TextButton("Options", buttonStyle)
        val leaderboardButton = TextButton("Leaderboard", buttonStyle)
        val feedbackButton = TextButton("Feedback/News", buttonStyle)
        val prevRunsButton = TextButton("Previous Runs", buttonStyle)
        val creditsButton = TextButton("Credits", buttonStyle)

        table.add(title).padBottom(50f).row()
        table.add(newGameButton).width(200f).padBottom(10f).row()
        table.add(continueButton).width(200f).padBottom(10f).row()
        table.add(optionsButton).width(200f).padBottom(10f).row()
        table.add(leaderboardButton).width(200f).padBottom(10f).row()
        table.add(feedbackButton).width(200f).padBottom(10f).row()
        table.add(prevRunsButton).width(200f).padBottom(10f).row()
        table.add(creditsButton).width(200f).padBottom(10f).row()

        // Add button listeners
        newGameButton.addListener(object : ChangeListener() {
            override fun changed(event: ChangeEvent?, actor: Actor?) {
                game.setScreen(CharacterSelectionScreen(game))
            }
        })

        continueButton.addListener(object : ChangeListener() {
            override fun changed(event: ChangeEvent?, actor: Actor?) {
                // TODO: Implement continue game functionality
            }
        })

        optionsButton.addListener(object : ChangeListener() {
            override fun changed(event: ChangeEvent?, actor: Actor?) {
                game.setScreen(OptionsScreen(game))
            }
        })

        leaderboardButton.addListener(object : ChangeListener() {
            override fun changed(event: ChangeEvent?, actor: Actor?) {
                game.setScreen(LeaderboardScreen(game))
            }
        })

        feedbackButton.addListener(object : ChangeListener() {
            override fun changed(event: ChangeEvent?, actor: Actor?) {
                game.setScreen(FeedbackScreen(game))
            }
        })

        prevRunsButton.addListener(object : ChangeListener() {
            override fun changed(event: ChangeEvent?, actor: Actor?) {
                game.setScreen(PreviousRunsScreen(game))
            }
        })

        creditsButton.addListener(object : ChangeListener() {
            override fun changed(event: ChangeEvent?, actor: Actor?) {
                game.setScreen(CreditsScreen(game))
            }
        })
    }

    // Test helper method
    fun clickNewGameButton() {
        newGameButton.fire(ChangeListener.ChangeEvent())
    }
}
