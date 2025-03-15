package com.exodus.game

import com.badlogic.gdx.Game
import com.badlogic.gdx.graphics.g2d.SpriteBatch
import com.badlogic.gdx.graphics.g2d.BitmapFont
import com.exodus.game.screens.LoadingScreen

open class ExodusGame : Game() {
    lateinit var batch: SpriteBatch
    lateinit var font: BitmapFont

    override fun create() {
        batch = SpriteBatch()
        font = BitmapFont()
        setScreen(LoadingScreen(this))
    }

    override fun dispose() {
        batch.dispose()
        font.dispose()
        screen?.dispose()
    }
}
