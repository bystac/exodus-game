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
 * Base game screen with common UI elements.
 *
 * Provides a standard layout with a title and back button,
 * as well as a content area for derived screens to populate.
 *
 * @param game Reference to the main game instance
 * @param title The title to display at the top of the screen
 */
open class GameScreen(game: ExodusGame, private val title: String) : BaseScreen(game) {

    /** Table for screen-specific content */
    protected val contentTable = Table()

    init {
        setupBaseUI()
    }

    private fun setupBaseUI() {
        // Get the skin
        val skin = game.assets.skin

        // Root table that fills the screen
        val rootTable = Table().apply {
            setFillParent(true)
            padTop(30f)
            padBottom(30f)
            padLeft(20f)
            padRight(20f)
        }

        // Title label
        val titleLabel = Label(title, skin, "large").apply {
            setAlignment(Align.center)
            color = Color.WHITE
        }

        // Back button
        val backButton = TextButton("BACK", skin).apply {
            label.setFontScale(1.5f)
        }

        // Set click listener for back button
        backButton.onClick {
            game.setScreen(game.menuScreen)
        }

        // Add elements to root table
        rootTable.apply {
            add(titleLabel).expandX().center().padBottom(30f).row()
            add(contentTable).expand().fill().row()
            add(backButton).width(200f).height(80f).padTop(20f)
        }

        // Add root table to stage
        stage.addActor(rootTable)
    }

    /**
     * Add content to the screen.
     * Override this method in derived screens to add specific content.
     *
     * @param table The table to add content to
     */
    open fun addContent(table: Table) {
        // Default implementation adds a placeholder message
        val skin = game.assets.skin
        table.add(Label("Screen content not implemented", skin, "medium")).center()
    }

    override fun show() {
        Gdx.input.inputProcessor = stage

        // Clear and populate content
        contentTable.clear()
        addContent(contentTable)
    }
}
