package biz.dvlop.exodus.screens

import com.badlogic.gdx.Gdx
import com.badlogic.gdx.Screen
import com.badlogic.gdx.graphics.GL20
import com.badlogic.gdx.graphics.OrthographicCamera
import com.badlogic.gdx.scenes.scene2d.Stage
import com.badlogic.gdx.utils.viewport.FitViewport
import com.badlogic.gdx.utils.viewport.ExtendViewport
import com.badlogic.gdx.utils.viewport.FillViewport
import biz.dvlop.exodus.ExodusGame

/**
 * Base screen implementation for all game screens.
 *
 * Provides common functionality for rendering, viewport management,
 * and stage handling that all game screens will inherit.
 *
 * @param game Reference to the main game instance
 */
open class BaseScreen(protected val game: ExodusGame) : Screen {
    // Use a more reasonable reference size
    private val worldWidth = 640f
    private val worldHeight = 960f
    protected val camera: OrthographicCamera = OrthographicCamera()

    // FillViewport will stretch content to fill the entire screen
    // This works better for menus where exact aspect ratio isn't as important
    protected val viewport: FillViewport = FillViewport(worldWidth, worldHeight, camera)
    protected val stage: Stage = Stage(viewport, game.batch)

    // Test-only getters
    internal fun getStage() = stage
    internal fun getViewport() = viewport
    internal fun getCamera() = camera

    init {
        Gdx.input.inputProcessor = stage

        // Position camera at center of viewport
        camera.position.set(worldWidth / 2f, worldHeight / 2f, 0f)

        // Log viewport size for debugging
        Gdx.app.log("BaseScreen", "Screen size: ${Gdx.graphics.width}x${Gdx.graphics.height}")
        Gdx.app.log("BaseScreen", "World size: ${worldWidth}x${worldHeight}")
    }

    override fun show() {}

    override fun render(delta: Float) {
        // Clear the screen with a darker background
        Gdx.gl.glClearColor(0.05f, 0.05f, 0.1f, 1f)
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT)

        camera.update()
        game.batch.projectionMatrix = camera.combined

        stage.act(delta)
        stage.draw()
    }

    override fun resize(width: Int, height: Int) {
        viewport.update(width, height, true)
        Gdx.app.log("BaseScreen", "Resize: ${width}x${height}")
    }

    override fun pause() {}
    override fun resume() {}
    override fun hide() {}

    override fun dispose() {
        stage.dispose()
    }
}
