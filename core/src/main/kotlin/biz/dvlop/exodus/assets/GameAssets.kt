package biz.dvlop.exodus.assets

import com.badlogic.gdx.Gdx
import com.badlogic.gdx.assets.AssetManager
import com.badlogic.gdx.graphics.Color
import com.badlogic.gdx.graphics.g2d.BitmapFont
import com.badlogic.gdx.scenes.scene2d.ui.Label.LabelStyle
import com.badlogic.gdx.scenes.scene2d.ui.Skin
import com.badlogic.gdx.scenes.scene2d.ui.TextButton.TextButtonStyle
import com.badlogic.gdx.utils.Disposable

/**
 * Font sizes for different UI elements
 */
enum class FontSize(val size: Float) {
    SMALL(0.7f),
    REGULAR(1.0f),
    MEDIUM(1.5f),
    LARGE(2.0f),
    XLARGE(3.0f),
    TITLE(4.0f)
}

/**
 * Manages loading and accessing game assets.
 */
class GameAssets : Disposable {
    private val assetManager = AssetManager()
    lateinit var skin: Skin
        private set

    private val fonts = mutableMapOf<FontSize, BitmapFont>()

    /**
     * Loads all game assets.
     */
    fun load() {
        loadSkin()
        // TODO: Load other assets as needed
    }

    private fun loadSkin() {
        // Create scaled fonts using the default bitmap font
        FontSize.values().forEach { fontSize ->
            val font = BitmapFont()
            font.data.setScale(fontSize.size)
            fonts[fontSize] = font
        }

        // Create a skin with the scaled fonts
        skin = Skin().apply {
            // Add fonts to skin
            fonts.forEach { (size, font) ->
                // Create and add label styles
                val labelStyle = LabelStyle(font, Color.WHITE)
                add(size.name.lowercase(), labelStyle)

                // Also add "default" style from REGULAR size
                if (size == FontSize.REGULAR) {
                    add("default", labelStyle)
                }
            }

            // Add default text button style
            val buttonStyle = TextButtonStyle().apply {
                font = fonts[FontSize.LARGE]!!
                fontColor = Color.WHITE
                downFontColor = Color.LIGHT_GRAY
                overFontColor = Color.YELLOW
            }
            add("default", buttonStyle)
        }

        Gdx.app.log("GameAssets", "Skin loaded successfully")
    }

    override fun dispose() {
        fonts.values.forEach { it.dispose() }
        assetManager.dispose()

        if (::skin.isInitialized) {
            skin.dispose()
        }
    }
}
