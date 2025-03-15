package com.exodus.game.screens

import com.badlogic.gdx.Gdx
import com.badlogic.gdx.Screen
import com.badlogic.gdx.graphics.GL20
import com.badlogic.gdx.graphics.OrthographicCamera
import com.badlogic.gdx.scenes.scene2d.Stage
import com.badlogic.gdx.utils.viewport.FitViewport
import com.exodus.game.ExodusGame

open class BaseScreen(protected val game: ExodusGame) : Screen {
    protected val camera: OrthographicCamera = OrthographicCamera()
    protected val viewport: FitViewport = FitViewport(800f, 480f, camera)
    protected val stage: Stage = Stage(viewport, game.batch)

    // Test-only getters
    internal fun getStage() = stage
    internal fun getViewport() = viewport
    internal fun getCamera() = camera

    init {
        Gdx.input.inputProcessor = stage
    }

    override fun show() {}

    override fun render(delta: Float) {
        Gdx.gl.glClearColor(0f, 0f, 0f, 1f)
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT)

        camera.update()
        game.batch.projectionMatrix = camera.combined

        stage.act(delta)
        stage.draw()
    }

    override fun resize(width: Int, height: Int) {
        viewport.update(width, height)
        camera.position.set(camera.viewportWidth / 2f, camera.viewportHeight / 2f, 0f)
    }

    override fun pause() {}
    override fun resume() {}
    override fun hide() {}

    override fun dispose() {
        stage.dispose()
    }
}
