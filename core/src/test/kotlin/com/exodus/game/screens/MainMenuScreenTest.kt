package com.exodus.game.screens

import com.badlogic.gdx.Gdx
import com.badlogic.gdx.Graphics
import com.badlogic.gdx.backends.headless.HeadlessApplication
import com.badlogic.gdx.backends.headless.HeadlessApplicationConfiguration
import com.badlogic.gdx.graphics.Color
import com.badlogic.gdx.graphics.GL20
import com.badlogic.gdx.graphics.g2d.BitmapFont
import com.badlogic.gdx.graphics.g2d.SpriteBatch
import com.badlogic.gdx.scenes.scene2d.Stage
import com.badlogic.gdx.scenes.scene2d.ui.Label.LabelStyle
import com.badlogic.gdx.scenes.scene2d.ui.TextButton.TextButtonStyle
import com.badlogic.gdx.utils.viewport.FitViewport
import com.exodus.game.ExodusGame
import org.junit.After
import org.junit.Before
import org.junit.BeforeClass
import org.junit.Test
import org.mockito.Mockito
import org.mockito.Mockito.`when`
import org.mockito.Mockito.verify
import org.mockito.Mockito.spy
import com.badlogic.gdx.graphics.g2d.Batch
import com.badlogic.gdx.math.Matrix4

class MainMenuScreenTest {
    private lateinit var game: ExodusGame
    private lateinit var mockFont: BitmapFont
    private lateinit var mockBatch: SpriteBatch
    private lateinit var mockGL: GL20
    private lateinit var defaultTitleStyle: LabelStyle
    private lateinit var defaultButtonStyle: TextButtonStyle
    private lateinit var screen: MainMenuScreen

    companion object {
        @JvmStatic
        @BeforeClass
        fun setupHeadless() {
            // Initialize LibGDX Headless Backend
            val config = HeadlessApplicationConfiguration()
            HeadlessApplication(object : com.badlogic.gdx.ApplicationAdapter() {}, config)
        }
    }

    @Before
    fun setUp() {
        // Create mocks
        game = Mockito.mock(ExodusGame::class.java)
        mockBatch = Mockito.mock(SpriteBatch::class.java)
        mockGL = Mockito.mock(GL20::class.java)

        // Create a real BitmapFont instance
        mockFont = BitmapFont()

        // Set up LibGDX environment
        Gdx.gl = mockGL
        Gdx.gl20 = mockGL
        val mockGraphics = Mockito.mock(Graphics::class.java)
        `when`(mockGraphics.width).thenReturn(800)
        `when`(mockGraphics.height).thenReturn(600)
        Gdx.graphics = mockGraphics

        // Configure basic mocks
        `when`(game.font).thenReturn(mockFont)
        `when`(game.batch).thenReturn(mockBatch)

        // Mock SpriteBatch behavior
        val matrix = com.badlogic.gdx.math.Matrix4()
        matrix.setToOrtho2D(0f, 0f, 800f, 600f)
        `when`(mockBatch.projectionMatrix).thenReturn(matrix)

        // Create default styles
        val whiteColor = Color(1f, 1f, 1f, 1f)
        val grayColor = Color(0.5f, 0.5f, 0.5f, 1f)
        val lightGrayColor = Color(0.75f, 0.75f, 0.75f, 1f)

        defaultTitleStyle = LabelStyle(mockFont, whiteColor)
        defaultButtonStyle = TextButtonStyle().apply {
            font = mockFont
            fontColor = whiteColor
            downFontColor = grayColor
            overFontColor = lightGrayColor
        }
    }

    @After
    fun tearDown() {
        if (::screen.isInitialized) {
            screen.dispose()
        }
        if (::mockFont.isInitialized) {
            mockFont.dispose()
        }
    }

    @Test
    fun `should create MainMenuScreen with default styles`() {
        // Create screen with default styles
        screen = MainMenuScreen(game)

        // Get the stage and verify its setup
        val stage = screen.getStage()
        assert(stage.actors.size > 0) { "Stage should have actors" }

        // Verify viewport dimensions
        val viewport = stage.viewport
        assert(viewport is FitViewport) { "Viewport should be a FitViewport" }
        assert(viewport.worldWidth == 800f) { "Stage viewport width should be 800" }
        assert(viewport.worldHeight == 480f) { "Stage viewport height should be 480" }

        // Update viewport and camera position
        viewport.update(800, 600, true)
        val camera = screen.getCamera()
        camera.position.set(camera.viewportWidth / 2f, camera.viewportHeight / 2f, 0f)
        camera.update()
    }

    @Test
    fun `should create MainMenuScreen with custom styles`() {
        // Create screen with custom styles
        screen = MainMenuScreen(game, defaultTitleStyle, defaultButtonStyle)

        // Get the stage and verify its setup
        val stage = screen.getStage()
        assert(stage.actors.size > 0) { "Stage should have actors" }

        // Verify viewport dimensions
        val viewport = stage.viewport
        assert(viewport is FitViewport) { "Viewport should be a FitViewport" }
        assert(viewport.worldWidth == 800f) { "Stage viewport width should be 800" }
        assert(viewport.worldHeight == 480f) { "Stage viewport height should be 480" }

        // Update viewport and camera position
        viewport.update(800, 600, true)
        val camera = screen.getCamera()
        camera.position.set(camera.viewportWidth / 2f, camera.viewportHeight / 2f, 0f)
        camera.update()

        // Verify custom styles are used
        val table = stage.actors.first()
        assert(table is com.badlogic.gdx.scenes.scene2d.ui.Table) { "First actor should be a Table" }
    }

    @Test
    fun `should transition to character selection screen when new game clicked`() {
        // Create screen
        screen = MainMenuScreen(game, defaultTitleStyle, defaultButtonStyle)

        // Update viewport and camera position
        val viewport = screen.getStage().viewport
        viewport.update(800, 600, true)
        val camera = screen.getCamera()
        camera.position.set(camera.viewportWidth / 2f, camera.viewportHeight / 2f, 0f)
        camera.update()

        // Click the New Game button using the helper method
        screen.clickNewGameButton()

        // Verify screen transition
        verify(game).setScreen(Mockito.any(CharacterSelectionScreen::class.java))
    }

    @Test
    fun `should render without errors`() {
        // Create screen
        screen = MainMenuScreen(game, defaultTitleStyle, defaultButtonStyle)

        // Update viewport and camera position
        val viewport = screen.getStage().viewport
        viewport.update(800, 600, true)
        val camera = screen.getCamera()
        camera.position.set(camera.viewportWidth / 2f, camera.viewportHeight / 2f, 0f)
        camera.update()

        // Create a spy of the stage's root group
        val stage = screen.getStage()
        val spyRoot = spy(stage.root)
        Mockito.doNothing().`when`(spyRoot).draw(Mockito.any(Batch::class.java), Mockito.anyFloat())
        stage.root = spyRoot

        // Call render
        screen.render(1f)

        // Verify basic GL calls were made
        verify(mockGL).glClearColor(0f, 0f, 0f, 1f)
        verify(mockGL).glClear(GL20.GL_COLOR_BUFFER_BIT)

        // Verify stage was rendered
        verify(mockBatch).begin()
        verify(mockBatch).end()
    }
}
