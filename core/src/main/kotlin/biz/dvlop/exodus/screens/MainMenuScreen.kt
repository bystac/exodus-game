package biz.dvlop.exodus.screens

import com.badlogic.gdx.Gdx
import com.badlogic.gdx.scenes.scene2d.ui.*
import com.badlogic.gdx.graphics.Color
import com.badlogic.gdx.scenes.scene2d.ui.Label.LabelStyle
import com.badlogic.gdx.scenes.scene2d.ui.TextButton.TextButtonStyle
import com.badlogic.gdx.scenes.scene2d.Actor
import com.badlogic.gdx.scenes.scene2d.utils.ChangeListener
import biz.dvlop.exodus.ExodusGame
import com.badlogic.gdx.graphics.g2d.BitmapFont
import com.badlogic.gdx.utils.Scaling
import com.badlogic.gdx.utils.Align
import ktx.actors.onClick

/**
 * Main menu screen implementation.
 *
 * Displays the game's main menu with buttons for starting a new game,
 * continuing a saved game, accessing options, and other features.
 *
 * @param game Reference to the main game instance
 * @param testLabelStyle Optional label style for testing
 * @param testButtonStyle Optional button style for testing
 */
open class MainMenuScreen(
    game: ExodusGame,
    private val testLabelStyle: LabelStyle? = null,
    private val testButtonStyle: TextButtonStyle? = null
) : BaseScreen(game) {

    private val screenWidth = Gdx.graphics.width.toFloat()
    private val screenHeight = Gdx.graphics.height.toFloat()

    // Use fixed sizes to ensure UI is visible
    private val buttonWidth = minOf(screenWidth * 0.9f, 800f)
    private val buttonHeight = maxOf(screenHeight * 0.12f, 80f)
    private val buttonPadding = screenHeight * 0.05f

    // Debug info
    private var debugLabel: Label? = null

    // Store font references for disposal
    private val scaledTitleFont: BitmapFont
    private val scaledButtonFont: BitmapFont

    init {
        // Debug output
        Gdx.app.log("MainMenuScreen", "Screen dimensions: ${screenWidth}x${screenHeight}")
        Gdx.app.log("MainMenuScreen", "Button size: ${buttonWidth}x${buttonHeight}")

        setupUI()

        // Create scaled font for title
        scaledTitleFont = BitmapFont()
        scaledTitleFont.data.setScale(6f)

        // Create scaled font for buttons with larger minimum size
        scaledButtonFont = BitmapFont()
        scaledButtonFont.data.setScale(Math.max(2.0f, buttonWidth / 800f * 1.5f))

        val titleStyle = testLabelStyle ?: LabelStyle(scaledTitleFont, Color(1f, 1f, 1f, 1f))
        val title = Label("EXODUS", titleStyle)
        title.name = "title"
        title.setAlignment(Align.center)

        val buttonStyle = testButtonStyle ?: TextButtonStyle().apply {
            font = scaledButtonFont
            fontColor = Color(1f, 1f, 1f, 1f)
            downFontColor = Color(0.5f, 0.5f, 0.5f, 1f)
            overFontColor = Color(0.75f, 0.75f, 0.75f, 1f)
        }

        // Add debug info
        val debugInfo = "Screen: ${screenWidth.toInt()}x${screenHeight.toInt()}\n" +
                         "Button: ${buttonWidth.toInt()}x${buttonHeight.toInt()}"
        debugLabel = Label(debugInfo, LabelStyle(BitmapFont().apply { data.setScale(1.5f) }, Color.YELLOW))
    }

    private fun setupUI() {
        // Get the skin from the game
        val skin = game.assets.skin

        // Root table to organize UI elements
        val rootTable = Table().apply {
            setFillParent(true)
            pad(50f)
        }

        // Add title label
        val titleLabel = Label("EXODUS", skin).apply {
            // Use a very large font scale for the title
            setFontScale(6f)
            setAlignment(Align.center)
            color = Color.WHITE
        }

        // Debug info label
        val debugLabel = Label(
            "Screen: ${screenWidth.toInt()}x${screenHeight.toInt()}\n" +
            "Button: ${buttonWidth.toInt()}x${buttonHeight.toInt()}",
            skin
        ).apply {
            setFontScale(1.5f)
            setAlignment(Align.center)
            color = Color.YELLOW
        }

        // Create menu buttons
        val playButton = createButton("PLAY") {
            game.setScreen(game.gameScreen)
        }

        val settingsButton = createButton("SETTINGS") {
            // TODO: Navigate to settings screen when implemented
            game.setScreen(OptionsScreen(game))
        }

        val aboutButton = createButton("ABOUT") {
            // TODO: Navigate to about screen when implemented
            game.setScreen(CreditsScreen(game))
        }

        val quitButton = createButton("QUIT") {
            Gdx.app.exit()
        }

        // Add elements to the table
        rootTable.apply {
            // Title at the top
            add(titleLabel).padBottom(buttonPadding * 2).row()

            // Debug info
            add(debugLabel).padBottom(buttonPadding).row()

            // Buttons
            add(playButton).width(buttonWidth).height(buttonHeight).padBottom(buttonPadding).row()
            add(settingsButton).width(buttonWidth).height(buttonHeight).padBottom(buttonPadding).row()
            add(aboutButton).width(buttonWidth).height(buttonHeight).padBottom(buttonPadding).row()
            add(quitButton).width(buttonWidth).height(buttonHeight).row()

            // Center everything
            center()
        }

        // Add the table to the stage
        stage.addActor(rootTable)
    }

    private fun createButton(text: String, action: () -> Unit): TextButton {
        return TextButton(text, game.assets.skin).apply {
            // Make button text larger
            label.setFontScale(2.5f)

            // Set action
            onClick { action() }
        }
    }

    override fun show() {
        // Set the input processor to the stage
        Gdx.input.inputProcessor = stage
    }

    // Test helper method
    fun clickNewGameButton() {
        // Implementation needed
    }

    override fun dispose() {
        super.dispose()
        // Dispose of scaled fonts we created
        if (testLabelStyle == null) {
            scaledTitleFont.dispose()
        }
        if (testButtonStyle == null) {
            scaledButtonFont.dispose()
        }
    }
}
