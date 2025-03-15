package biz.dvlop.exodus.screens

import com.badlogic.gdx.Gdx
import com.badlogic.gdx.Graphics
import com.badlogic.gdx.graphics.GL20
import com.badlogic.gdx.backends.headless.HeadlessApplication
import com.badlogic.gdx.backends.headless.HeadlessApplicationConfiguration
import com.badlogic.gdx.graphics.g2d.SpriteBatch
import com.badlogic.gdx.graphics.g2d.BitmapFont
import biz.dvlop.exodus.ExodusGame
import org.junit.Before
import org.junit.Test
import org.mockito.Mockito.mock
import kotlin.test.assertNotNull

class BaseScreenTest {
    private lateinit var game: ExodusGame
    private lateinit var mockBatch: SpriteBatch
    private lateinit var mockFont: BitmapFont
    private lateinit var mockGL: GL20

    @Before
    fun setUp() {
        mockBatch = mock(SpriteBatch::class.java)
        mockFont = mock(BitmapFont::class.java)
        mockGL = mock(GL20::class.java)

        val config = HeadlessApplicationConfiguration()
        HeadlessApplication(object : ExodusGame() {
            override fun create() {
                batch = mockBatch
                font = mockFont
                game = this
            }
        }, config)

        Gdx.graphics = mock(Graphics::class.java)
        Gdx.gl = mockGL
    }

    @Test
    fun `test base screen initialization`() {
        val screen = object : BaseScreen(game) {}
        assertNotNull(screen.getStage())
        assertNotNull(screen.getViewport())
        assertNotNull(screen.getCamera())
    }
}
